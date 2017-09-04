package com.at.systemconfig;

import com.at.config.CtrId;
import com.at.entity.TSystemCtrl;
import com.at.entity.TSystemCtrlMethod;
import com.at.entity.TSystemCtrlMethodCriteria;
import com.at.entity.mapper.TSystemCtrlMapper;
import com.at.entity.mapper.TSystemCtrlMethodMapper;
import com.at.frame.Api2DB;
import com.at.frame.AutoCtrlParent;
import com.at.frame.annotation.AutoCtrl;
import com.at.frame.annotation.AutoMethod;
import com.at.frame.utils.PVTransverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 * 该拦截器用来使用，当系统初始化完成之后
 * 自动化将所有的控制器信息、方法信息写入到数据库中
 *
 * 该类只适用于该框架对应的访问权限设计
 * 如果自定义了权限设计表，则需要做对应的修改以适应
 */
@Component
public class Api2DbImpl implements Api2DB {
    private static final Logger LOGGER = LoggerFactory.getLogger(Api2DbImpl.class);
    private static final Class<TSystemCtrl> CLAZZ = TSystemCtrl.class;

    @Resource
    private TSystemCtrlMapper systemCtrlMapper;
    @Resource
    private TSystemCtrlMethodMapper systemCtrlMethodMapper;

    private Api2DbImpl(){

    }

    @Override
    public void beforeSave() {
        final List<TSystemCtrl> parentCtrls = new ArrayList<>();
        parentCtrls.add(new AutoCtrlParent(CtrId.PARENT_SYSTEM_MAMAGER,"系统管理").to(CLAZZ));
        for(int i = 0, s = parentCtrls.size(); i < s; i++){
            TSystemCtrl ctrl = parentCtrls.get(i);
            TSystemCtrl systemCtrl = systemCtrlMapper.selectByPrimaryKey(ctrl.getId());
            if(systemCtrl == null){
                systemCtrl = PVTransverter.transfer(ctrl,CLAZZ);
                systemCtrl.setCtrlName("["+ctrl.getCtrlName()+"]");
                systemCtrlMapper.insert(systemCtrl);
            }else{
                //已存在，判断是否更新
                if(systemCtrl.getCtrlVersion() < ctrl.getCtrlVersion()){
                    systemCtrl.setCtrlName("["+ctrl.getCtrlName()+"]");
                    systemCtrl.setCtrlDesc(ctrl.getCtrlDesc());
                    systemCtrl.setParentId(ctrl.getParentId());
                    systemCtrlMapper.updateByPrimaryKey(systemCtrl);
                }
            }
        }
    }

    @Override
    public void save(AutoCtrl ctrl, List<AutoMethod> methods) {
        TSystemCtrl systemCtrl = systemCtrlMapper.selectByPrimaryKey(ctrl.id());
        if(systemCtrl == null){
            systemCtrl = new TSystemCtrl();
            systemCtrl.setId(ctrl.id());
            systemCtrl.setCtrlName(Arrays.toString(ctrl.name()));
            systemCtrl.setCtrlDesc(ctrl.desc());
            systemCtrl.setCtrlVersion(ctrl.version());
            systemCtrl.setCtrlUrl(ctrl.url());
            systemCtrl.setParentId(ctrl.parentId());
            systemCtrlMapper.insert(systemCtrl);
        }else{
            //已存在，判断是否更新
            if(systemCtrl.getCtrlVersion() < ctrl.version()){
                //版本过低，更新（注：这里强制要求了说，如果修改路径，则必须修改版本，否则将不会自动更新入库)
                //可以自己修改该类的逻辑，适应于自身的代码和情况
                systemCtrl.setCtrlName(Arrays.toString(ctrl.name()));
                systemCtrl.setCtrlDesc(ctrl.desc());
                systemCtrl.setCtrlVersion(ctrl.version());
                systemCtrl.setCtrlUrl(ctrl.url());
                systemCtrl.setParentId(ctrl.parentId());
                systemCtrlMapper.updateByPrimaryKey(systemCtrl);
            }
        }
        //保存对应的方法
        for(int i=0,s=methods.size();i<s;i++){
            AutoMethod method = methods.get(i);
            TSystemCtrlMethodCriteria scmc = new TSystemCtrlMethodCriteria();
            scmc.createCriteria()
                    .andCtrlIdEqualTo(systemCtrl.getId())
                    .andMethodIdEqualTo(method.id());
            TSystemCtrlMethod scm = systemCtrlMethodMapper.getByExample(scmc);
            if(scm == null){
                scm = new TSystemCtrlMethod();
                scm.setMethodId(method.id());
                scm.setCtrlId(ctrl.id());
                scm.setMethodName(Arrays.toString(method.name()));
                scm.setMethodDesc(method.desc());
                scm.setMethodVersion(method.version());
                systemCtrlMethodMapper.insert(scm);
            }else if(scm.getMethodVersion() < ctrl.version()){
                scm.setMethodName(Arrays.toString(method.name()));
                scm.setMethodDesc(method.desc());
                scm.setMethodVersion(method.version());
                systemCtrlMethodMapper.updateByPrimaryKey(scm);
            }
        }
    }
}

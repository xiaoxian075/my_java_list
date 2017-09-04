package com.at.service.impl;

import com.at.config.Text;
import com.at.entity.TSystemCtrl;
import com.at.entity.TSystemCtrlMethod;
import com.at.entity.mapper.TSystemCtrlMapper;
import com.at.entity.mapper.TSystemCtrlMethodMapper;
import com.at.frame.utils.Result;
import com.at.pojo.admin.GroupAuthVO;
import com.at.pojo.admin.TreeLeafVO;
import com.at.service.ISystemCtrlInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
@Service
public class SystemCtrlServiceImpl implements ISystemCtrlInfoService{
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemCtrlServiceImpl.class);
    @Autowired
    private TSystemCtrlMapper systemCtrlMapper;
    @Autowired
    private TSystemCtrlMethodMapper systemCtrlMethodMapper;

    @Override
    public Result<List<TreeLeafVO>> authTree() {
        //取得所有的控制器
        List<TSystemCtrl> ctrls = systemCtrlMapper.selectAll();
        List<TSystemCtrlMethod> methods = systemCtrlMethodMapper.selectAll();
        //组装成树表数据
        /*
        这边只需要组装成对应结构体即可，其他的树的组成逻辑
        由前端框架自动化组装完成
        需要处理的是，将方法的parentId设置为所属控制器的ID
         */
        int ctrlSize = ctrls.size();
        int methodSize = methods.size();
        List<TreeLeafVO> tree = new ArrayList<>(ctrlSize + methodSize);
        int i,j;
        TSystemCtrl ctrl;
        TSystemCtrlMethod method;
        TreeLeafVO treeLeaf;
        for(i = 0; i < ctrlSize; i++){
            ctrl = ctrls.get(i);
            treeLeaf = new TreeLeafVO();
            treeLeaf.setId(ctrl.getId());
            treeLeaf.setParentId(ctrl.getParentId());
            treeLeaf.setText(ctrl.getCtrlDesc());
            tree.add(treeLeaf);
        }
        for(j = 0; j < methodSize; j++){
            method = methods.get(j);
            treeLeaf = new TreeLeafVO();
            treeLeaf.setId(method.getId());
            treeLeaf.setParentId(method.getCtrlId());
            treeLeaf.setText(method.getMethodDesc());
            treeLeaf.setMethodId(method.getId());
            tree.add(treeLeaf);
        }
        return Result.suc(tree,Text.SUCCESS);
    }


    @Override
    public Result<GroupAuthVO> groupAuth(Integer groupId) {
        if(groupId == null){
            LOGGER.error("组Id为空");
            return Result.fail(Text.PARAM_ERROR);
        }
        List<TSystemCtrl> ctrls = systemCtrlMapper.queryByGroupId(groupId.intValue());
        List<TSystemCtrlMethod> methods = systemCtrlMethodMapper.queryByGroupId(groupId.intValue());
        GroupAuthVO groupAuth = new GroupAuthVO();
        int cs,ms;
        List<Integer> ctrlIds = new ArrayList<>((cs = ctrls.size()));
        List<Integer> methodIds = new ArrayList<>((ms = methods.size()));
        for(int i = 0; i < cs; i++){
            TSystemCtrl ctrl = ctrls.get(i);
            ctrlIds.add(ctrl.getId());
        }
        for(int i = 0; i < ms; i++){
            TSystemCtrlMethod method = methods.get(i);
            methodIds.add(method.getId());
        }
        groupAuth.setCtrlIds(ctrlIds);
        groupAuth.setMethodIds(methodIds);
        return Result.suc(groupAuth,Text.SUCCESS);
    }
}

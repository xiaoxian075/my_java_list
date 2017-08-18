package admin.controller;
/**
 * @Description 运费模板类
 * @author cjx
 * @date 2017-7-4
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import admin.entity.Area;
import admin.entity.AreaShort;
import admin.entity.LogiAreaList;
import admin.entity.LogiInit;
import admin.entity.ShipTemplate;
import admin.entity.ShipTemplateVo;
import admin.entity.base.PageListBean;
import admin.entity.base.ReqMsg;
import admin.entity.base.StrStrBean;
import admin.service.AreaService;
import admin.service.LogitempService;

@Controller
@RequestMapping("logitemp")
public class LogitempController {
	@Autowired
	private LogitempService logitempService;
	@Autowired
	private AreaService areaService;
	
	private static int n = 1;
	
	@RequestMapping("trans")
	@ResponseBody
	public String trans(HttpServletRequest request,Model model){
		try {
			if (logitempService.insertShipTemplateTest(1))
				return "succ";
		} catch (Exception e) {
			System.out.println("fail");
		}
		return "fail";
	}
	
//	private void save(List<ShipTemplate> shiptemplateList) {
//		//RedisUtil.setCacheList("shiptemplateList",shiptemplateList,ShipTemplate.class);
//		Map<BigInteger,ShipTemplate> shiptemplateMap = new HashMap<BigInteger,ShipTemplate>();
//		for (ShipTemplate node : shiptemplateList) {
//			shiptemplateMap.put(node.getShip_id(), node);
//		}
//		setCacheMap("shiptemplateMap",shiptemplateMap,20);
//	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,Model model){
		
		
		int pagestart = 0;
		int pagesize = 10;
		HashMap<String, Object> paraMap = new HashMap<String,Object>();
		if (n==1) {
			paraMap.put("ship_name", "11");
			n = 2;
		}else {
			n = 1;
		}
		
		PageHelper.startPage(pagestart,pagesize);
		List<ShipTemplate> shiptemplateList = logitempService.getlist(paraMap);
		PageInfo<ShipTemplate> pageInfo = new PageInfo<ShipTemplate>(shiptemplateList);
		PageListBean page = new PageListBean();
		page.setCurrent_s(pageInfo.getPages());
		page.setPagesize_s(pageInfo.getPageSize());
		page.setTotalCount((int)pageInfo.getTotal());
		model.addAttribute("page", page);
		
		
		model.addAttribute("shiptemplateList", shiptemplateList);
		return "logitemp/list";
	}

	@RequestMapping("insert")
	public String insert(){
		return "logitemp/insert";
	}
	
	@RequestMapping("enableState")
	public String enableState(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) 
			return list(request,model);
		BigInteger ship_id = new BigInteger(parameter_id);
		if (!logitempService.setShipTemplateStatus(ship_id,1))
			model.addAttribute("promptmsg","出错");
		model.addAttribute("promptmsg","启用成功");
		return list(request, model);
	}
	

	@RequestMapping("limitState")
	public String limitState(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) 
			return list(request,model);
		BigInteger ship_id = new BigInteger(parameter_id);
		if (!logitempService.setShipTemplateStatus(ship_id,0))
			model.addAttribute("promptmsg","出错");
		model.addAttribute("promptmsg","禁用成功");
		return list(request, model);
	}
	
	
	@RequestMapping(value="getinit",produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getinit() {
		List<LogiAreaList> logiArea = new ArrayList<LogiAreaList>();
		List<Area> area = areaService.getCityArea();
		for (Area node : area) {
			if (node.getArea_level().equals("1")) {	//省级
				logiArea.add(new LogiAreaList(node.getArea_id(),node.getArea_name(),new ArrayList<AreaShort>(),node.getRegion()));
			} else if (node.getArea_level().equals("2")) {	//市级
				String parent_id = node.getParent_area_id();
				//找出父级
				LogiAreaList logi = null;
				for (LogiAreaList parent : logiArea) {
					if (parent.getArea_id().equals(parent_id)) {
						logi = parent;
						break;
					}
				}
				if (logi!=null) {
					List<AreaShort> list = logi.getChild_area();
					list.add(new AreaShort(node.getArea_id(),node.getArea_name()));
				}
			}
		}
		//"1":"华东" "2":"华北" "3":"华中" "4":"华南" "5":"东北" "6":"西北" "7":"西南"
		List<StrStrBean> sendtime = new ArrayList<StrStrBean>();
		sendtime.add(new StrStrBean("1","华东"));
		sendtime.add(new StrStrBean("2","华北"));
		sendtime.add(new StrStrBean("3","华中"));
		sendtime.add(new StrStrBean("4","华南"));
		sendtime.add(new StrStrBean("5","东北"));
		sendtime.add(new StrStrBean("6","西北"));
		sendtime.add(new StrStrBean("7","西南"));

		return new Gson().toJson(new ReqMsg(0,"succ",new LogiInit(logiArea,sendtime)));
	}
	
	@RequestMapping(value="getlist",produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getlist(String com_id, int goods_id) {
		BigInteger _com_id = new BigInteger(com_id);

		List<ShipTemplateVo> shipTemplateVoList = logitempService.getlist2(_com_id);
		
		return new Gson().toJson(new ReqMsg(0,"succ",shipTemplateVoList));
	}
	
	@RequestMapping(value="insert",produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String insert(ShipTemplateVo vo) {
		if (!logitempService.insertShipTemplate(vo)) {
			return new Gson().toJson(new ReqMsg(1,"插入失败",null));
		}
		return new Gson().toJson(new ReqMsg(0,"succ",null));
	}
	
	@RequestMapping(value="update",produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String update(ShipTemplateVo vo) {
		if (!logitempService.updateShipTemplate(vo)) {
			return new Gson().toJson(new ReqMsg(1,"更新失败",null));
		}
		return new Gson().toJson(new ReqMsg(0,"succ",null));
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) return list(request,model);
		BigInteger ship_id = new BigInteger(parameter_id);
		this.logitempService.deleteShipTemplateStatus(ship_id);
		model.addAttribute("promptmsg","删除成功！");
		return list(request, model);
	}
	
	@RequestMapping("batchdelete")
	public String batchDelete(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) return list(request,model);
		//转成数组更新
		String[] ids = parameter_id.split(",");
		List<BigInteger> arr_shipid = new ArrayList<BigInteger>();
		for(String id:ids){
			BigInteger ship_id = new BigInteger(id);
			arr_shipid.add(ship_id);
		}

		if(logitempService.batchShipTemplateDelete(arr_shipid)){
			model.addAttribute("promptmsg","批量删除成功");
		}else{
			model.addAttribute("promptmsg","批量删除失败");
		}
		return list(request, model);
	}
	
	
	@RequestMapping("batchenablestate")
	public String batchEnableState(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) {
			return list(request,model);
		}
		//转成数组更新
		String[] ids = parameter_id.split(",");
		List<BigInteger> arr_shipid = new ArrayList<BigInteger>();
		for(String id:ids){
			BigInteger ship_id = new BigInteger(id);
			arr_shipid.add(ship_id);
		}
		if(logitempService.batchShipTemplateUpdateState(arr_shipid,1)){
			model.addAttribute("promptmsg","批量启用成功");
		}else{
			model.addAttribute("promptmsg","批量启用失败");
		}
		return list(request, model);
	}
	
	@RequestMapping("batchlimitstate")
	public String batchLimitState(HttpServletRequest request,Model model){
		String parameter_id = request.getParameter("parameter_id");
		if(parameter_id==null ||parameter_id.equals("")) return list(request,model);
		//转成数组更新
		String[] ids = parameter_id.split(",");
		List<BigInteger> arr_shipid = new ArrayList<BigInteger>();
		for(String id:ids){
			BigInteger ship_id = new BigInteger(id);
			arr_shipid.add(ship_id);
		}
		if(logitempService.batchShipTemplateUpdateState(arr_shipid,0)){
			model.addAttribute("promptmsg","批量禁用成功");
		}else{
			model.addAttribute("promptmsg","批量禁用失败");
		}
		return list(request, model);
	}
	
	
//	@RequestMapping("/object")
//	@ResponseBody
//	public String object(){
////		RedisUtil.setCacheObject("age", "32kjf",String.class);
////		String str = RedisUtil.getCacheObject("age",String.class);
////		System.out.println(str);
//		UserInfo userInfo = new UserInfo(1,"陈建先","田",31);
//		System.out.println(userInfo);
//		RedisUtil.setCacheObject("age", userInfo,UserInfo.class);
//		UserInfo _userInfo = RedisUtil.getCacheObject("age",UserInfo.class);
//		System.out.println(_userInfo);
//		return "success";
//	}
//	
//	@RequestMapping("/list")
//	@ResponseBody
//	public String list(){
//		//RedisUtil.setCacheList("shiptemplateList",shiptemplateList,ShipTemplate.class);
//		List<ShipTemplate> _shiptemplateList = RedisUtil.getCacheList("shiptemplateList", ShipTemplate.class);
//		System.out.println(_shiptemplateList);
//		return "success";
//	}
}

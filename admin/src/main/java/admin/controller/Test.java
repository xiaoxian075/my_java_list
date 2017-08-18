package admin.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cache.redis.RedisUtil;

import admin.entity.ShipTemplate;
import admin.entity.UserInfo;

@Controller
@RequestMapping("/redis")
public class Test {
	
	@RequestMapping("/object")
	@ResponseBody
	public String object(){
//		RedisUtil.setCacheObject("age", "32kjf",String.class);
//		String str = RedisUtil.getCacheObject("age",String.class);
//		System.out.println(str);
		UserInfo userInfo = new UserInfo(1,"陈建先","田",31);
		System.out.println(userInfo);
		RedisUtil.setCacheObject("age", userInfo,UserInfo.class);
		UserInfo _userInfo = RedisUtil.getCacheObject("age",UserInfo.class);
		System.out.println(_userInfo);
		return "success";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(){
		//RedisUtil.setCacheList("shiptemplateList",shiptemplateList,ShipTemplate.class);
		List<ShipTemplate> _shiptemplateList = RedisUtil.getCacheList("shiptemplateList", ShipTemplate.class);
		System.out.println(_shiptemplateList);
		return "success";
	}
	
	@RequestMapping("/map")
	@ResponseBody
	public String map(){
		//RedisUtil.setCacheMap("shiptemplateList",shiptemplateMap,ShipTemplate.class);
		Map<BigInteger,ShipTemplate> _shiptemplateMap = RedisUtil.getCacheMap("shiptemplateMap", BigInteger.class, ShipTemplate.class);
		System.out.println(_shiptemplateMap);
		return "success";
	}
	
}

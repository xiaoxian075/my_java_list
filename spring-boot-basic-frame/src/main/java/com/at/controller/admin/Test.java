package com.at.controller.admin;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("/hello")
    public String helloHtml(HashMap<String,Object> map){
        map.put("hello","hello");
        return"/index";
    }
}

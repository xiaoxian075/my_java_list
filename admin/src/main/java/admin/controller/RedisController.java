package admin.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import com.cache.redis.RedisUtil;

@Controller
public class RedisController {
	@Autowired
    private RedisTemplate<String, Serializable> template;
	
	public RedisTemplate<String, Serializable> getTemplate() {
		return template;
	}
	
	@PostConstruct
	public void init() {
		RedisUtil.setTemplate(template);
	}
}

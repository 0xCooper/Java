package com.zlt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
public class TestController {
	@RequestMapping(value="test")
	@ResponseBody
	public String testSpringBoot(String name) {
		return "hello:"+name;		
	}
}

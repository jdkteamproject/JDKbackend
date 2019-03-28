package com.cue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(method=RequestMethod.GET, value="/test")
	@ResponseBody
	public String returnHomePage() {
		return "Testing is working";
	}

}

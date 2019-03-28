package com.cue.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cue.handler.Handler;

@Controller
public class APIController {
	
	@Autowired
	Handler handler;
	
	@GetMapping("/api")
    @ResponseBody
    public JSONObject getAPI(@RequestParam(value="page", required=false) Integer page, @RequestParam(value="city", required=false) String city, @RequestParam(value="category", required=false) String category){
		
		if(city==null) {
        	city = "";
        }
        if(category==null) {
        	category = "";
        }
        if(page==null) {
        	page = 0;
        }
   
        return handler.getAPIEvents(page, city, category);
    }
	
	@GetMapping("/test")
	@ResponseBody
	public String testing() {
		return "Testing!";
	}

}

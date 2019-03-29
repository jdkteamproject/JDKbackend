package com.cue.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cue.dao.Handler;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired
	Handler handler;
	
	@GetMapping
    public JSONObject getAPI(@RequestParam(value="page", required=false) Integer page, @RequestParam(value="city", required=false) String city, @RequestParam(value="category", required=false) String category, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="id", required=false) String id){
		
		if(keyword==null) {
			keyword = "";
		}
		if(city==null) {
        	city = "";
        }
        if(category==null) {
        	category = "";
        }
        if(page==null) {
        	page = 0;
        }
        if(id==null) {
        	id = "";
        }
   
        return handler.getAPIEvents(page, city, category, keyword, id);
    }
	

}

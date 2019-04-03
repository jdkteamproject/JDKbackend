package com.cue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cue.dao.Handler;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	Handler handler;
	
	@GetMapping(path="/cities")
    public List<String> listOfCities(){
		return handler.getAllCities();
    }
	
	@GetMapping(path="/categories")
    public List<String> listOfCategories(){
		return handler.getAllCategories();
    }

}

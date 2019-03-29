package com.cue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cue.beans.User;
import com.cue.dao.Handler;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	Handler handler;
	
	@GetMapping(value="/all")
    public List<User> getAPI(){
		return handler.getAllUsers();
    }
	

}

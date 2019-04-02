package com.cue.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cue.dao.Handler;
import com.cue.models.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	Handler handler;
	
	@GetMapping
    public List<User> getAllUsers(){
		return handler.getAllUsers();
    }
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = handler.getUserById(id);
		return user;
	}
	
	@GetMapping(value="/{id}/events")
	public List<JSONObject> getUsersavedEvents(@PathVariable("id") Integer id) {
		List<JSONObject> events = handler.getUserEvents(id);
		return events;
	}
	
	@PostMapping
	public boolean createUser(@RequestBody User user){
		List<User> users = handler.getAllUsers();
		for(User u : users) {
			if(u.getId() == user.getId()) {
				return false;
			}
		}
		return handler.createUser(user);
	}
	
	@PutMapping("/{id}")
	public boolean updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		List<User> users = handler.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				user.setId(id);
				return handler.updateUser(user);
			}
		}
		return false;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") Integer id) {
		List<User> users = handler.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				return handler.deleteUserById(id);
			}
		}
		return false;
	}

}

package com.cue.controller;

import java.util.List;
import java.util.Set;

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
import com.cue.models.Event;
import com.cue.models.Notification;
import com.cue.models.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	
	@GetMapping(value="/{id}/notifications")
	public Set<Notification> getUserNotifications(@PathVariable("id") Integer id) {
		Set<Notification> notifications = handler.getUserNotifications(id);
		return notifications;
	}
	
	@PostMapping
	public boolean createUser(@RequestBody User user){
		return handler.createUser(user);
	}
	
	@PostMapping(value="/{id}/events")
	public boolean addEventToUser(@PathVariable("id") Integer id, @RequestBody Event event){
		User user = handler.getUserById(id);
		
		if(user != null) {
			boolean exists = false;
			List<Event> allEvents = handler.getAllEvents();
			if(event.getE_id() != null) {
				for(Event e : allEvents) {
					if(e.getE_sid().equals(event.getE_sid())) {
						exists = true;
						event = e;
					}
				}
				if(!exists) {
					handler.createEvent(event);
				}
				user.addFavEvent(event);
				
				return handler.updateUser(user);
			}
		}
		return false;
	}
	
	@PostMapping(value="/{id}/notifications")
	public boolean addNotificationToUser(@PathVariable("id") Integer id, @RequestBody Notification notification){
		User user = handler.getUserById(id);
		if(user == null) {
			return false;
		}
		boolean exists = false;
		List<Notification> allNotifications = handler.getAllNotifications();
		for(Notification n : allNotifications) {
			if(n.getMessage().equals(notification.getMessage())) {
				exists = true;
				notification = n;
			}
		}
		if(!exists) {
			handler.createNotification(notification);
		}
		
		user.addNotification(notification);
		
		return handler.updateUser(user);
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
	
	@DeleteMapping("/notification/{id}")
	public boolean Test(@PathVariable("id") Integer id) {
		List<Notification> notifications = handler.getAllNotifications();
		for(Notification n : notifications) {
			if(n.getId() == id) {
				return handler.deleteNotificationById(id);
			}
		}
		return false;
	}


}

package com.cue.dao;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.cue.models.Event;
import com.cue.models.User;

@Component
public class Handler implements UserDao, EventDao{
	
	UserDao ud = new UserDaoImpl();
	EventDao ed = new EventDaoImpl();
	
	public Integer validateLogin(String email, String password) {
		Integer status = -1;
		
		User u = ud.getUserByEmail(email);
		
		if(u != null) {
			if(u.getPassword().equals(password)) {
				status = u.getId();
			}
		}
		
		return status;
	}
	
	@Override
	public List<Event> getAllEvents() {
		return ed.getAllEvents();
	}

	@Override
	public Event getEventById(String id) {
		return ed.getEventById(id);
	}

	@Override
	public boolean createEvent(Event event) {
		return ed.createEvent(event);
	}

	@Override
	public boolean updateEvent(Event event) {
		return ed.updateEvent(event);
	}

	@Override
	public boolean deleteEventById(String id) {
		return ed.deleteEventById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	@Override
	public User getUserById(Integer id) {
		return ud.getUserById(id);
	}

	@Override
	public boolean createUser(User user) {
		return ud.createUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return ud.updateUser(user);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		return ud.deleteUserById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return ud.getUserByEmail(email);
	}

	@Override
	public List<JSONObject> getUserEvents(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

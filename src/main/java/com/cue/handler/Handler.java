package com.cue.handler;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.cue.beans.User;

@Component
public class Handler {
	
	private UserDao ud = new UserDaoImpl();
	private TicketMasterAPI tm = new TicketMasterAPI();
	
	public JSONObject getAPIEvents(Integer page, String city, String category) {
		return tm.getAPIEvents(page, city, category);
	}

	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	public User getUserById(int id) {
		return ud.getUserById(id);
	}

	public boolean createUser(User user) {
		return ud.createUser(user);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

}

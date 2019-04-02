package com.cue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.cue.models.Event;
import com.cue.models.Notification;
import com.cue.models.User;

@Component
public class Handler implements UserDao, EventDao, NotificationDao {
	
	UserDao ud = new UserDaoImpl();
	EventDao ed = new EventDaoImpl();
	TicketMasterAPI tm = new TicketMasterAPI();
	NotificationDao nd = new NotificationDaoImpl();
	
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
	
	@SuppressWarnings("null")
	public List<JSONObject> getUserEvents(Integer id) {
		List<JSONObject> total = new ArrayList<JSONObject>();
		User user = this.getUserById(id);
		
		if(user.getFavEvents() != null) {
			Set<Event> userEvents = user.getFavEvents();
			for(Event event : userEvents) {
				JSONObject boi = tm.getAPIEvents(0, "", "", "", event.getE_sid());
				try {
					TimeUnit.MILLISECONDS.sleep(350);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(boi);
				if(boi != null) total.add(boi);
			}
		}
		
		return total;
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
	public List<Notification> getAllNotifications() {
		return nd.getAllNotifications();
	}

	@Override
	public Notification getNotificationById(String id) {
		return nd.getNotificationById(id);
	}

	@Override
	public boolean createNotification(Notification notification) {
		return nd.createNotification(notification);
	}

	@Override
	public boolean updateNotification(Notification notification) {
		return nd.updateNotification(notification);
	}

	@Override
	public boolean deleteNotificationById(String id) {
		return nd.deleteNotificationById(id);
	}

}

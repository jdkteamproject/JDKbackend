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
	
	public List<String> getAllCities(){
		List<String> temp = new ArrayList<String>();
		temp.add("Balitimore");
		temp.add("Boston");
		temp.add("Chicago");
		temp.add("Cincinnati");
		temp.add("Denver");
		temp.add("Detroit");
		temp.add("Honolulu");
		temp.add("Houston");
		temp.add("Kansas City");
		temp.add("Las Vegas");
		temp.add("Memphis");
		temp.add("Miami");
		temp.add("New Orleans");
		temp.add("New York");
		temp.add("Philadelphia");
		temp.add("Pittsburgh");
		temp.add("Portland");
		temp.add("Richmond");
		temp.add("Salt Lake City");
		temp.add("Seattle");
		temp.add("Utica");
		
		return temp;
	}
	
	public List<String> getAllCategories(){
		List<String> temp = new ArrayList<String>();
		temp.add("Arts");
		temp.add("Music");
		temp.add("Sports");
		
		return temp;
	}
	
	UserDao ud = new UserDaoImpl();
	EventDao ed = new EventDaoImpl();
	TicketMasterAPI tm = new TicketMasterAPI();
	NotificationDao nd = new NotificationDaoImpl();
	
	public Set<Notification> getUserNotifications(Integer id){
		Set<Notification> total = null;
		
		User user = this.getUserById(id);
		if(user != null) {
			total = user.getNotifications();
		}
		
		return total;
	}
	
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
	
	public List<JSONObject> getUserEvents(Integer id) {
		List<JSONObject> total = new ArrayList<JSONObject>();
		User user = this.getUserById(id);
		
		if(user.getFavEvents() != null) {
			Set<Event> userEvents = user.getFavEvents();
			for(Event event : userEvents) {
				JSONObject boi = tm.getAPIEvents(0, "", "", "", event.getE_sid());
				try {
					TimeUnit.MILLISECONDS.sleep(500); //Limited API calls per second
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
	public Event getEventById(Integer id) {
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
	public boolean deleteEventById(Integer id) {
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
	public Notification getNotificationById(Integer id) {
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
	public boolean deleteNotificationById(Integer id) {
		return nd.deleteNotificationById(id);
	}

}

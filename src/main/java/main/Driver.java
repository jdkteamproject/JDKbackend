package main;

import com.cue.dao.Handler;
import com.cue.models.Event;
import com.cue.models.User;
import com.cue.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		Handler handler = new Handler();
		
		User user1 = new User("shimjay1@gmail.com", "magikarp", "123", "New York");
		User user2 = new User("alfonzo@gmail.com", "alfonzo", "123", "Reston");
		User user3 = new User("newPerson@gmail.com", "NewGuy", "password1", "Seattle");
		
		Event event1 = new Event("event1");
		Event event2 = new Event("event2");
		
		handler.createEvent(event1);
		handler.createEvent(event2);
		
		handler.createUser(user1);
		handler.createUser(user2);
		handler.createUser(user3);
		
		user1.addFavEvent(event1);
		user1.addFavEvent(event2);
		user2.addFavEvent(event1);
		
//		user2.addFriend(user1);
		
		handler.updateUser(user1);
		handler.updateUser(user2);
		handler.updateUser(user3);
		
		HibernateUtil.closeSessionFactory();
	}

}
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
		user3.setCategory("Sports");
		
		Event event1 = new Event("G5diZ4oLvGfYG");
		Event event2 = new Event("vv1A7ZAf4Gkdb0k-J");
		
		handler.createEvent(event1);
		handler.createEvent(event2);
		
		user1.addFavEvent(event1);
		user1.addFavEvent(event2);
		user2.addFavEvent(event1);
		
		handler.createUser(user1);
		handler.createUser(user2);
		handler.createUser(user3);
		
//		HibernateUtil.closeSessionFactory();
	}

}
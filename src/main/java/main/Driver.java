package main;

import com.cue.beans.User;
import com.cue.handler.Handler;
import com.cue.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		Handler handler = new Handler();
		
//		User user1 = new User("shimjay1@gmail.com", "magikarp", "123");
//		handler.createUser(user1);
//		
//		User user2 = new User("alfonzo@gmail.com", "alfonzo", "123");
//		handler.createUser(user2);
//		
//		HibernateUtil.closeSessionFactory();
		
		handler.getAPIEvents(0, "New Orleans", "Sports");
	}

}

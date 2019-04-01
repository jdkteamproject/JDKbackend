package com.cue.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cue.models.User;
import com.cue.util.HibernateUtil;

@Component
public class UserDaoImpl implements UserDao {
	
	@Override
	public User getUserByEmail(String email) {
		Session s = HibernateUtil.getSession();
		User u = null;
		
		try{
			u = (User) s.get(User.class, email);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = null;
		
		try {
			users = s.createQuery("From User").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return users;
	}

	@Override
	public User getUserById(Integer id) {
		Session s = HibernateUtil.getSession();
		User u = null;
		
		try{
			u = (User) s.get(User.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	@Override
	public boolean createUser(User user) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(user);
			tx.commit();
			created = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			s.close();
		}
	
		return created;
	}

	@Override
	public boolean updateUser(User change) {
		boolean changed = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u = null;
		
		try {
			u = (User) s.get(User.class, change.getId());
			
			if(change.getEmail() != null) {
				u.setEmail(change.getEmail());
			}
			if(change.getPassword() != null) {
				u.setPassword(change.getPassword());
			}
			if(change.getUsername() != null) {
				u.setUsername(change.getUsername());
			}
			if(change.getFavEvents() != null) {
				u.setFavEvents(change.getFavEvents());
			}
//			if(change.getFriends() != null) {
//				u.setFriends(change.getFriends());
//			}
			
			s.save(u);
			tx.commit();
			changed = true;
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			s.close();
		}
		
		return changed;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		boolean deleted = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();;
		
		try {
			s.delete(s.get(User.class, id));
			tx.commit();
			
			deleted = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return deleted;
		
	}

}

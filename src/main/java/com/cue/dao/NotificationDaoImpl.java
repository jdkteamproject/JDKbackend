package com.cue.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cue.models.Notification;
import com.cue.util.HibernateUtil;

@Component
public class NotificationDaoImpl implements NotificationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getAllNotifications() {
		Session s = HibernateUtil.getSession();
		List<Notification> notifications = null;
		
		try {
			notifications = s.createCriteria(Notification.class).list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return notifications;
	}

	@Override
	public Notification getNotificationById(Integer id) {
		Session s = HibernateUtil.getSession();
		Notification u = null;
		
		try{
			u = (Notification) s.get(Notification.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	@Override
	public boolean createNotification(Notification notification) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(notification);
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
	public boolean updateNotification(Notification change) {
		boolean changed = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Notification u = null;
		
		try {
			u = (Notification) s.get(Notification.class, change.getId());
			
			if(change.getMessage() != null) {
				u.setMessage(change.getMessage());
			}
			
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
	public boolean deleteNotificationById(Integer id) {
		boolean deleted = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();;
		
		try {
			s.delete(s.get(Notification.class, id));
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

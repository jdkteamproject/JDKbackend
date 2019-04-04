package com.cue.dao;

import java.util.List;

import com.cue.models.Notification;

public interface NotificationDao {
	
	public List<Notification> getAllNotifications();
	public Notification getNotificationById(Integer id);
	public boolean createNotification(Notification notification);
	public boolean updateNotification(Notification notification);
	public boolean deleteNotificationById(Integer id);

}

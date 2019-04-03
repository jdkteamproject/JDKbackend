package com.cue.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="u_id")
	@SequenceGenerator(sequenceName="user_seq", name="u_seq")
	@GeneratedValue(generator="u_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="u_email")
	private String email;
	@Column(name="u_username")
	private String username;
	@Column(name="u_password")
	private String password;
	@Column(name="u_isAdmin")
	private Boolean isAdmin;
	@Column(name="u_isBanned")
	private Boolean isBanned;
	@Column(name="u_reportedNum")
	private Integer reportedNum;
	@Column(name="u_region")
	private String region;
	@Column(name="u_category")
	private String category;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_event_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="e_id"))
	private Set<Event> favEvents;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_notification_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="n_id"))
	private Set<Notification> notifications;
	
	
	public User() {
		super();
	}
	
	public User(String email, String username, String password, String category, String region) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = false;
		this.isBanned = false;
		this.reportedNum = 0;
		this.region = region;
		this.category = category;
		this.favEvents = new HashSet<Event>();
		this.notifications = new HashSet<Notification>();
	}
	
	public User(String email, String username, String password, Boolean isAdmin, Boolean isBanned,
			Integer reportedNum, String region, String category, Set<Event> favEvents,
			Set<Notification> notifications) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.reportedNum = reportedNum;
		this.region = region;
		this.category = category;
		this.favEvents = favEvents;
		this.notifications = notifications;
	}

	public User(Integer id, String email, String username, String password, Boolean isAdmin, Boolean isBanned,
			Integer reportedNum, String region, String category, Set<Event> favEvents,
			Set<Notification> notifications) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.reportedNum = reportedNum;
		this.region = region;
		this.category = category;
		this.favEvents = favEvents;
		this.notifications = notifications;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean isBanned() {
		return isBanned;
	}

	public void setBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}

	public Integer getReportedNum() {
		return reportedNum;
	}

	public void setReportedNum(Integer reportedNum) {
		this.reportedNum = reportedNum;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Event> getFavEvents() {
		return favEvents;
	}

	public void setFavEvents(Set<Event> favEvents) {
		this.favEvents = favEvents;
	}
	
	public void addFavEvent(Event event) {
		this.favEvents.add(event);
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public void addNotification(Notification notification) {
		this.notifications.add(notification);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", isAdmin=" + isAdmin + ", isBanned=" + isBanned + ", reportedNum=" + reportedNum + ", region="
				+ region + ", category=" + category + ", favEvents=" + favEvents + ", notifications=" + notifications
				+ "]";
	}
	

}

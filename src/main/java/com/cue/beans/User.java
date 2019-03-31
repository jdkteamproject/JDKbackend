package com.cue.beans;

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
	private int id;
	@Column(name="u_email")
	private String email;
	@Column(name="u_username")
	private String username;
	@Column(name="u_password")
	private String password;
	@Column(name="u_isAdmin")
	private boolean isAdmin;
	@Column(name="u_isBanned")
	private boolean isBanned;
	@Column(name="u_reportedNum")
	private int reportedNum;
	@Column(name="u_region")
	private String region;
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_event_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="e_id"))
	private Set<Event> favEvents;
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_friend_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="f_id"))
	private Set<User> friends;
	
	public User() {
		super();
	}
	
	public User(String email, String username, String password, String region) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = false;
		this.isBanned = false;
		this.reportedNum = 0;
		this.region = region;
		this.favEvents = new HashSet<Event>();
		this.friends = new HashSet<User>();
	}
	
	public User(String email, String username, String password, boolean isAdmin, boolean isBanned,
			int reportedNum, String region, Set<Event> favEvents, Set<User> friends) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.reportedNum = reportedNum;
		this.region = region;
		this.favEvents = favEvents;
		this.friends = friends;
	}

	public User(int id, String email, String username, String password, boolean isAdmin, boolean isBanned,
			int reportedNum, String region, Set<Event> favEvents, Set<User> friends) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.reportedNum = reportedNum;
		this.region = region;
		this.favEvents = favEvents;
		this.friends = friends;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public int getReportedNum() {
		return reportedNum;
	}

	public void setReportedNum(int reportedNum) {
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

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User user) {
		this.friends.add(user);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", isAdmin=" + isAdmin + ", isBanned=" + isBanned + ", reportedNum=" + reportedNum + ", region="
				+ region + ", favEvents=" + favEvents + ", friends=" + friends + "]";
	}
	

}

package com.project.TripHub.models;


import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Size(min=3, max=30)
    private String firstName;
    
	@Size(min=3, max=30)
    private String lastName;
    
	@Size(min=5)
    private String email;
    
	@Size(min=5)
    private String password;
    
    @Transient
    private String confirm;
    
    @Column(updatable=false)
    private Date createdAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    private Date lastLogin;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
    		name = "user_roles",
    		joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "role_id")
    		)
    private List<Role> roles;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Guide guide;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "event_guests", joinColumns = @JoinColumn(name = "host_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> events;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tour_guests", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tour_id"))
	private List<Tour> userTours;
    
    
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> hostedEvents;

    public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Tour> getUserTours() {
		return userTours;
	}

	public void setUserTours(List<Tour> userTours) {
		this.userTours = userTours;
	}

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}
    
}

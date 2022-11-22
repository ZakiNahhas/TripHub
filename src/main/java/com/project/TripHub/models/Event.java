package com.project.TripHub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Id;
	@NotNull(message="name must be present")
	@NotEmpty(message="name cannot be empty")
	String eventName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_id")
	private User host;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "event_guests", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> guests;

	@NotNull(message = "description can't be blank")
	@Size(min = 3, message = "description has to be min 3 characters")
	private String description;
	@NotNull(message = "location can't be blank")
	@Size(min = 3, message = "location has to be min 3 characters")
	private String location;
	@Size(min = 3, message = "participants has to be minimum 3 persons")
	private int participants;
	@Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@OneToMany(mappedBy="event", fetch = FetchType.EAGER)
    private List<FileDB> images;	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	public Event(String eventName, String description, Date eventDate) {
		this.eventName = eventName;
		this.description = description;
		this.eventDate = eventDate;
	}
	
	public Event() {
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return Id;
	}


	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getGuests() {
		return guests;
	}

	public List<FileDB> getImages() {
		return images;
	}

	public void setImages(List<FileDB> images) {
		this.images = images;
	}

	public void setGuests(List<User> guests) {
		this.guests = guests;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getParticipants() {
		return participants;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}
}
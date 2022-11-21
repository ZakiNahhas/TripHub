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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Tour")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	@NotNull(message = "name must be present")
	@NotEmpty(message = "name cannot be empty")
	String tourName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guide_id")
	private Guide guide;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tour_guests", joinColumns = @JoinColumn(name = "tour_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> tourGuests;

	@NotNull(message = "description can't be blank")
	@Size(min = 3, message = "description has to be min 3 characters")
	private String description;

	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tourDate;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public List<User> getTourGuests() {
		return tourGuests;
	}

	public void setTourGuests(List<User> guests) {
		this.tourGuests = tourGuests;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public Long getId() {
		return Id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}

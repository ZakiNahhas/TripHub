package com.project.TripHub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="guide_requests")
public class GuideRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@ElementCollection
	private List <String> languages;
	@NotNull(message="driver license cannot be null")
	Long license;
	
	@OneToOne(fetch=FetchType.LAZY)
	User user;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public Long getLicense() {
		return license;
	}
	public void setDriverLicense(Long driverLicense) {
		this.license = driverLicense;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
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

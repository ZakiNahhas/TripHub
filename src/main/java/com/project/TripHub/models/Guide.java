package com.project.TripHub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
<<<<<<< HEAD
import javax.persistence.ElementCollection;
=======
>>>>>>> bd0cc61cf6288d00d20a885034b77ac3fd9d9b1b
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "guides")
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message="liecnse number cannot be empty")
	private Long license;

	@ElementCollection
	private List<String> languages;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
	private List<Tour> guidedTours;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Guide() {

	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Long getLicense() {
		return license;
	}

	public void setLicense(Long license) {
		this.license = license;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Tour> getGuidedTours() {
		return guidedTours;
	}

	public void setGuidedTours(List<Tour> guidedTours) {
		this.guidedTours = guidedTours;
	}

=======
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="guides")
public class Guide { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long         id;
    @NotEmpty
    private List<String> languages;

    @Size(min=9)
    private Long license;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy="guide", fetch = FetchType.LAZY)
    private List<Tour> guidedTours;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    public Guide() {
    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Long getLicense() {
        return license;
    }

    public void setLicense(Long license) {
        this.license = license;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Tour> getGuidedTours() {
        return guidedTours;
    }

    public void setGuidedTours(List<Tour> guidedTours) {
        this.guidedTours = guidedTours;
    }
>>>>>>> bd0cc61cf6288d00d20a885034b77ac3fd9d9b1b
}

package com.project.TripHub.models;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Guide {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty
    private List<String> languages;
   
	@Size(min=9)
    private Long license;
	
	
    
	@OneToMany(mappedBy="guide", fetch = FetchType.LAZY)
    private List<Tour> guidedTours;
}

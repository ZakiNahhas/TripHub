package com.project.TripHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.TripHub.models.Guide;
import com.project.TripHub.models.Tour;

public interface TourRepo extends CrudRepository<Tour, Long> {
	List<Tour> findAll();
	List<Tour> findByTourName(String name);
	List<Tour> findByGuideNotContains(Guide guide);
	List<Tour> findAllByGuide(Guide guide);
}


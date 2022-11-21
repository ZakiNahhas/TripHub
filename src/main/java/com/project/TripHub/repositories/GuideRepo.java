package com.project.TripHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.TripHub.models.Guide;

	
public interface GuideRepo extends CrudRepository<Guide, Long> {
	List<Guide> findAll();
}

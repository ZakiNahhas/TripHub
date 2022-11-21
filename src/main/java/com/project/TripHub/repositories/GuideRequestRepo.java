package com.project.TripHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.TripHub.models.GuideRequest;

public interface GuideRequestRepo extends CrudRepository <GuideRequest, Long> {
	List<GuideRequest> findAll();
}
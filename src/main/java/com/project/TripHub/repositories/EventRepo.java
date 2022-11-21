package com.project.TripHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.TripHub.models.Event;
import com.project.TripHub.models.User;

public interface EventRepo extends CrudRepository<Event, Long> {
	List<Event> findAll();
	List<Event> findByEventName(String name);
	List<Event> findByHostNotContains(User user);
	List<Event> findAllByHost(User user);
}
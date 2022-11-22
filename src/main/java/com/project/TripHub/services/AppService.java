package com.project.TripHub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.TripHub.models.Event;
import com.project.TripHub.models.Guide;
import com.project.TripHub.models.GuideRequest;
import com.project.TripHub.models.Tour;
import com.project.TripHub.models.User;
import com.project.TripHub.repositories.EventRepo;
import com.project.TripHub.repositories.GuideRepo;
import com.project.TripHub.repositories.GuideRequestRepo;
import com.project.TripHub.repositories.TourRepo;

@Service
public class AppService {
	private final UserService userService;
	private final EventRepo eventRepo;
	private final TourRepo tourRepo;
	private final GuideRepo guideRepo;
	private final GuideRequestRepo guideRequestRepo;
	public AppService(UserService userService, EventRepo eventRepo, TourRepo tourRepo, GuideRepo guideRepo, GuideRequestRepo guideRequestRepo) {
		this.userService = userService;
		this.eventRepo = eventRepo;
		this.tourRepo = tourRepo;
		this.guideRepo = guideRepo;
		this.guideRequestRepo = guideRequestRepo;
	}
	//****************************
	// Events
	//****************************
	public List<Event> allEvents() {
		return eventRepo.findAll();
	}

	public List<Event> findEventByName(String name) {
		List<Event> event = eventRepo.findByEventName(name);
		return event;
	}

	public Event saveEvent(Event event) {
		return eventRepo.save(event);
	}

	public void deleteEvent(Event event) {
		eventRepo.delete(event);
	}

	public Event findByEventId(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		if (event.isPresent()) {
			return event.get();
		}
		return null;
	}
	
	public void addUserToEvent(Event event, Long userId) {
		User user = userService.findById(userId);
		event.getGuests().add(user);
	}
	public void removeUserFromEvent(Event event, Long userId) {
		User user = userService.findById(userId);
		event.getGuests().remove(user);
	}
	
	public List<Event> findUserEvents(User user) {
		return eventRepo.findAllByHost(user);
	}
	
	public List<Event> EventsExcludingUser(User user) {
		return eventRepo.findByHostNotContains(user);
	}
	
	//****************************
	// Tours
	//****************************
	public List<Tour> allTours() {
		return tourRepo.findAll();
	}

	public List<Tour> findTourByName(String name) {
		List<Tour> tour = tourRepo.findByTourName(name);
		return tour;
	}

	public Tour saveTour(Tour tour) {
		return tourRepo.save(tour);
	}

	public void deleteTour(Tour tour) {
		tourRepo.delete(tour);
	}

	public Tour findByTourId(Long id) {
		Optional<Tour> tour = tourRepo.findById(id);
		if (tour.isPresent()) {
			return tour.get();
		}
		return null;
	}
	public void addUserToTour(Tour tour, Long userId) {
		User user = userService.findById(userId);
		tour.getTourGuests().add(user);
	}
	public void removeUserFromTrour(Tour tour, Long userId) {
		User user = userService.findById(userId);
		tour.getTourGuests().remove(user);
	}
	public List<Tour> findUserTours(Guide guide) {
		return tourRepo.findAllByGuide(guide);
	}
	
	public List<Tour> toursExcludingUser(Guide guide) {
		return tourRepo.findByGuideNotContains(guide);
	}
	
	//****************************
	// Guide and guide requests
	//****************************
	
	public List<GuideRequest> allGuideRequest() {
		return guideRequestRepo.findAll();
	}
	
	public void saveGuideRequest (GuideRequest request) {
		guideRequestRepo.save(request);
	}
	
	public GuideRequest findByGuideRequestId(Long id) {
		Optional<GuideRequest> guideRequest = guideRequestRepo.findById(id);
		if (guideRequest.isPresent()) {
			return guideRequest.get();
		}
		return null;
	}
	public void deleteGuideRequest(GuideRequest guideRequest) {
		guideRequestRepo.delete(guideRequest);
	}
	
	public void saveGuide (Guide guide) {
		guideRepo.save(guide);
	}
	
	public Guide findByGuideId(Long id) {
		Optional<Guide> guide = guideRepo.findById(id);
		if (guide.isPresent()) {
			return guide.get();
		}
		return null;
	}
	public void deleteGuide(Guide guide) {
		guideRepo.delete(guide);
	}
	public void approveGuide(GuideRequest request) {
		Guide newGuide = new Guide();
		userService.upgradeUserToGuide(request.getUser());
		newGuide.setLanguages(request.getLanguages());
		newGuide.setLicense(request.getLicense());
		guideRepo.save(newGuide);
	}
	
}

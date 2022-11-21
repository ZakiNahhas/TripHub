package com.project.TripHub.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TripHub.Validator.UserValidator;
import com.project.TripHub.models.Event;
import com.project.TripHub.models.GuideRequest;
import com.project.TripHub.models.Tour;
import com.project.TripHub.models.User;
import com.project.TripHub.services.AppService;
import com.project.TripHub.services.UserService;

@Controller
public class MainController {

	private UserService userService;
	private UserValidator userValidator;
	private AppService appService;

	public MainController(UserService userService, UserValidator userValidator, AppService appService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.appService = appService;
	}

	@RequestMapping("/register")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request) {
		userValidator.validate(user, result);
		// Store the password before it is encrypted
		String password = user.getPassword();
		if (result.hasErrors()) {
			return "loginPage.jsp";
		}
		// Make first user SUPER ADMIN
		if (userService.allUsers().size() == 0) {
			userService.newUser(user, "ROLE_SUPER_ADMIN");
		} else {
			userService.newUser(user, "ROLE_USER");
		}

		// Log in new user with the password we stored before encrypting it
		authWithHttpServletRequest(request, user.getEmail(), password);
		return "redirect:/";
	}

	// We will call this method to automatically log in newly registered users
	public void authWithHttpServletRequest(HttpServletRequest request, String email, String password) {
		try {
			request.login(email, password);
		} catch (ServletException e) {
			System.out.println("Error while login: " + e);
		}
	}

	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String email = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(email));
		model.addAttribute("users", userService.allUsers());
		return "adminPage.jsp";
	}

	@RequestMapping("/admin/{id}")
	public String makeAdmin(@PathVariable("id") Long id, Model model) {

		User user = userService.findById(id);
		userService.upgradeUser(user);

		model.addAttribute("users", userService.allUsers());

		return "redirect:/admin";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}

		return "loginPage.jsp";
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("user", user);

		if (user != null) {
			user.setLastLogin(new Date());
			userService.updateUser(user);
			// If the user is an ADMIN or SUPER_ADMIN they will be redirected to the admin
			// page
			if (user.getRoles().get(0).getName().contains("ROLE_SUPER_ADMIN")
					|| user.getRoles().get(0).getName().contains("ROLE_ADMIN")) {
				model.addAttribute("currentUser", userService.findByEmail(email));
				model.addAttribute("users", userService.allUsers());
				return "adminPage.jsp";
			}
			// All other users are redirected to the home page
		}

		return "home.jsp";
	}

//	@RequestMapping("/guides/approve/{id}")
	
	@GetMapping("/trips/guidenew")
	public String newGuide(@Valid @ModelAttribute("newGuide") GuideRequest request, BindingResult result, Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		SortedSet<String> allLanguages = new TreeSet<String>();
		String[] choiceLanguages = Locale.getISOLanguages();
		for (int i = 0; i < choiceLanguages.length; i++){
		    Locale loc = new Locale(choiceLanguages[i]);
		    allLanguages.add(loc.getDisplayLanguage());
		}
		model.addAttribute("choiceLanguages", choiceLanguages);
		model.addAttribute("user", user);
		return "guideForm.jsp";
	}
	
	@RequestMapping("/delete/tour/{id}")
	public String deleteTour(@PathVariable("id") Long id, HttpSession session, Model model) {
		Tour tour = appService.findByTourId(id);
		appService.deleteTour(tour);
		return "redirect:/admin";
	}

	@RequestMapping("/delete/event/{id}")
	public String deleteEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
		Event event = appService.findByEventId(id);
		appService.deleteEvent(event);
		return "redirect:/admin";
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, HttpSession session, Model model) {
		User user = userService.findById(id);
		userService.deleteUser(user);

		model.addAttribute("users", userService.allUsers());

		return "redirect:/admin";
	}

	@RequestMapping("/guide/test")
	public String showGuide() {
		return "test.jsp";
	}
}
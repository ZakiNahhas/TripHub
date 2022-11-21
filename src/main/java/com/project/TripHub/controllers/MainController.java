package com.project.TripHub.controllers;


import java.security.Principal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TripHub.services.UserService;
import com.project.TripHub.Validator.UserValidator;
import com.project.TripHub.models.User;

@Controller
public class MainController {

	private UserService userService;
	private UserValidator userValidator;

	public MainController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
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
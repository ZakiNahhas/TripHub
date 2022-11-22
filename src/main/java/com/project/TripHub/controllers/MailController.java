package com.project.TripHub.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.TripHub.models.EmailDetails;
import com.project.TripHub.services.EmailService;

@RestController
public class MailController {
	private final EmailService emailService;
	public MailController( EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		System.out.println("++++++++++");
		String status = emailService.sendSimpleMail(details);
	
		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);

		return status;
	}
}

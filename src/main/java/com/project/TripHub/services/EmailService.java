package com.project.TripHub.services;

import com.project.TripHub.models.EmailDetails;

//Importing required classes

//Interface
public interface EmailService {

 // Method
 // To send a simple email
 String sendSimpleMail(EmailDetails details);

 // Method
 // To send an email with attachment
 String sendMailWithAttachment(EmailDetails details);
}
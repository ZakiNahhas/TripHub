
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>addEvent</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/static/homepage.css">
    <link rel="stylesheet" href="/static/edit.css">
</head>
<body>

    <!--===========Nav Bar=================-->
    <section class="nav-bar">
      <div class="logo">TripHub</div>
      <ul class="menu">
        <li><a href="#">home</a></li>
        <li><a href="#">tours</a></li>
        <li><a href="#">package</a></li>
        <li><a href="#">blog</a></li>
        <li><a href="#">about us</a></li>
        <li><a href="#">contact us</a></li>
      </ul>

    </section>
    <!--===============Banner================-->

    <section class="banner">
      <form:form action="/trips/addNewEvent" class="bootstrap-iso cleaner-application-form" style="background-color: rgba(255, 255, 255, 0.7); border-radius:5px;" modelAttribute="newEvent">
        <div class="tb-container tmp-form-wrapper">
          <div class="tb-form-horizontal">
            <div class="tb-form-group tb-row">
                <h1>Create Your Event</h1>

              <form:label for="EventName" path="eventName" class="tb-col-md-2 tb-control-label">Event Name</form:label>
              <div class="tb-col-md-4">
                <form:errors path="EventName" class="text-danger"/>
                <form:input type="text" class="tb-form-control" path="eventName" placeholder="Tour Name"></form:input>
              </div>
            </div>
            <div class="tb-form-group tb-row">
              <form:label path="location" class="tb-col-md-2 tb-control-label">Location</form:label>
              <div class="tb-col-md-4">
                <form:errors path="location" class="text-danger"/>
                <form:input type="text" class="tb-form-control" id="location" path="location" placeholder="Location"></form:input>
              </div>
            </div>
            <div class="tb-form-group tb-row">
              <form:label path="participants" class="tb-col-md-2 tb-control-label">Maximum participant</form:label>
              <div class="tb-col-md-4">
                <form:errors path="participants" class="text-danger"/>
                <form:input type="number" class="tb-form-control" id="number" path="participants" placeholder="Maximum participant"></form:input>
              </div>
            </div>

              <div class="tb-form-group tb-row">
                <form:errors path="description" class="text-danger"/>
                <form:label  path="description" class="tb-col-md-2 tb-control-label">Even Description</form:label>
                <div class="tb-col-md-6">
                  <form:textarea class="tb-form-control tb-textarea" id="application-reason-textarea" path="description" rows="8"></form:textarea>
                </div>
              </div>
            </div>
            <div class="tb-row">
              <div class="tb-col-md-offset-2 tb-col-md-6" path="eventImage"><p class="application-form-explanation">Photo of the location</p></div>
            </div>
            </div>
            <div class="tb-form-group tb-row">
              <div class="tb-col-md-6">
              </div>
            </div>
            <div class="tb-form-group tb-row">
              <p class="tb-col-md-2 tb-control-label">Photo</p>
              <div class="tb-col-md-6">
                <form:input type="file" path="images" id="doc-gewerbeschein"></form:input>
              </div>
            </div>
            </div>
            <div class="tb-form-group tb-row">
            </div>
            <div class="tb-form-group tb-row">
              <div class="tb-col-md-offset-2 tb-col-md-6">
                <input type="submit" value="Submit" class="tb-btn tb-btn-default wpcf7-submit">
              </div>
            </div>
          </form:form>



    </section>

    <!--===========Footer=================-->
    <div class="footer">
      <div class="links">
        <h3>Quick Links</h3>
        <ul>
          <li>Offers & Discounts</li>
          <li>Get Coupon</li>
          <li>Contact Us</li>
          <li>About</li>
        </ul>
      </div>
      <div class="links">
        <h3>New Products</h3>
        <ul>
          <li>Woman Cloth</li>
          <li>Fashion Accessories</li>
          <li>Man Accessories</li>
          <li>Rubber made Toys</li>
        </ul>
      </div>
      <div class="links">
        <h3>Support</h3>
        <ul>
          <li>Frequently Asked Questions</li>
          <li>Report a Payment Issue</li>
          <li>Terms & Conditions</li>
          <li>Privacy Policy</li>
        </ul>
      </div>
    </div>
  </div>
</div>
        </div>
    </div>

  </body>

  </html>
</html>
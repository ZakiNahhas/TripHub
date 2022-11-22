<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<c:if test="${logoutMessage != null}">
		<c:out value="${logoutMessage}"></c:out>
	</c:if>
	<c:if test="${errorMessage != null}">
		<c:out value="${errorMessage}"></c:out>
	</c:if>

	<!--===========Nav Bar=================-->
	<section class="nav-bar">
	<div class="logo">Trip Hub</div>
	<ul class="menu">
		<li><a href="#">home</a></li>
		<li><a href="#">tours</a></li>
		<li><a href="#">package</a></li>
		<li><a href="#">blog</a></li>
		<li><a href="#">about us</a></li>
		<li><a href="#">contact us</a></li>
		<li><a href="#" class="sign"
			onclick="document.getElementById('id01').style.display='block'"
			style="width: auto;">Login</a></li>


	</ul>
	</div>

	</section>
	<!--===============Banner================-->
	<section class="banner">
	<div class="banner-text-item">
		<div class="banner-heading">
			<h1>Find your Next tour!</h1>
		</div>
		<form class="form">
			<input id="button" type="text" list="mylist"
				placeholder="Where would you like to go?">
			<datalist id="mylist">
			<option>London</option>
			<option>Canada</option>
			<option>Monaco</option>
			<option>France</option>
			<option>Japan</option>
			<option>Switzerland</option>
			<option>Seoul</option>
			</datalist>
			<input type="date" class="date"> <a href="#" class="book">book</a>
		</form>
	</div>
	</section>

	<!--=========Services===============-->
	<section class="services">
	<div class="service-item">
		<img
			src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293634/tour-guide_onzla9.png">
		<h2>8000+ Our Local Guides</h2>
	</div>
	<div class="service-item">
		<img
			src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293738/reliability_jbpn4g.png">
		<h2>100% Trusted Tour Agency</h2>
	</div>
	<div class="service-item">
		<img
			src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293635/experience_a3fduk.png">
		<h2>28+ Years of Travel Experience</h2>
	</div>
	<div class="service-item">
		<img
			src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293634/feedback_s8z7d9.png">
		<h2>98% Our Travelers are Happy</h2>
	</div>
	</section>
	<!--==============Places===================-->
	<section class="places">
	<div class="places-text">
		<small>FEATURED TOURS PACKAGES</small>
		<h2>Favourite Places</h2>
	</div>

	<div class="cards">
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293736/james-wheeler_xqmq2y.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Vancouver, Canada</p>
				</div>
			</div>

		</div>
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293755/paris_uj8wum.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Paris, France</p>
				</div>
			</div>

		</div>
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293955/monaco_usu7xb.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Monaco, Monaco</p>
				</div>
			</div>

		</div>
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293874/switzerland_tubxcm.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Bern, Switzerland</p>
				</div>
			</div>

		</div>
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293673/korea_bxrcj5.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Seoul, South Korea</p>
				</div>
			</div>

		</div>
		<div class="card">
			<div class="zoom-img">
				<div class="img-card">
					<img
						src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293673/night-4336403_1920_demehp.jpg">
				</div>
			</div>

			<div class="text">
				<span class="rating">&#11088;&#11088;&#11088;&#11088;&#11088;</span>
				<h2>The Dark Forest Adventure</h2>
				<p class="cost">$1870 / Per Person</p>
				<div class="card-box">
					<p class="time">&#128339; 3 Days</p>
					<p class="location">&#9992; Tokyo, japan</p>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--===========About Us===============-->
	<section class="about">
	<div class="about-img">
		<img
			src="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293719/outdoor_tjjhxk.jpg">
	</div>
	<div class="about-text">
		<small>ABOUT OUR COMPANY</small>
		<h2>We are Go Trip Ravels Support Company</h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
			do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
			enim ad minim veniam, quis nostrud</p>

		<label><input type="checkbox" checked>Lorem ipsum
			dolor sit amet</label> <label><input type="checkbox" checked>consectetur
			adipisicing elit</label> <label><input type="checkbox" checked>Architecto
			atque consequuntur</label> <label><input type="checkbox" checked>cupiditate
			doloremque ducimus</label> <a href="#">ABOUT US</a>
	</div>
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

	<h2>Modal Signup Form</h2>


	<div id="id01" class="modal">
		<form:form class="modal-content" action="/login" method="post"
			modelAttribute="user">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="container">
				<p>
					Don't have an account ? <a href="#" class="sign"
						onclick="document.getElementById('id02').style.display='block' , document.getElementById('id01').style.display='none'"
						style="width: auto;">Sign Up</a>
				</p>
				<hr>
				<label><b>Email</b></label>
				<form:errors path="email" class="text-danger" />
				<form:input type="text" class="input" path="email" />

				<label><b>Password</b></label>
				<form:errors path="password" class="text-danger" />
				<form:input type="password" class="input" path="password" />


				<label><input type="checkbox" checked="checked"
					name="remember" style="margin-bottom: 15px"> Remember me </label>

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Login</button>
				</div>
			</div>
		</form:form>
	</div>
	<div id="id02" class="modal">
		<form:form class="modal-content" action="/register" method="post"
			modelAttribute="user">
			<div class="container">
				<p>
					<a href="#" class="sign"
						onclick="document.getElementById('id01').style.display='block' , document.getElementById('id02').style.display='none'"
						style="width: auto;">Login</a>
				</p>

				<label><b>First Name</b></label>
				<form:errors path="firstName" class="text-danger" />
				<form:input type="text" class="input" path="firstName" />

				<label><b>Last Name</b></label>
				<form:errors path="lastName" class="text-danger" />
				<form:input type="text" class="input" path="lastName" />

				<label><b>Email</b></label>
				<form:errors path="email" class="text-danger" />
				<form:input type="text" class="input" path="email" />

				<label><b>Password</b></label>
				<form:errors path="password" class="text-danger" />
				<form:input type="password" class="input" path="password" />

				<label><b>Repeat Password</b></label>
				<form:errors path="confirm" class="text-danger" />
				<form:input type="password" class="input" path="confirm" />

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Sign Up</button>
				</div>
			</div>
		</form:form>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
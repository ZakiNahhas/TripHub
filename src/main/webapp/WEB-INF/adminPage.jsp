
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h1>Welcome, ${currentUser.firstName}</h1>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!"  class="btn btn-outline-danger"/>
</form>
</div>
<div class="d-flex">

<div class="container">
<h2> All Users </h2>
<table class="table table-light">
    <thead> 
    	<tr>
    		<th>Name</th>
    		<th>Email</th>
    		<th>Action</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="user" items="${users}">
	    	<c:if test = "${!user.roles.get(0).name.contains('ROLE_SUPER_ADMIN')}">
		        <tr>
					<td>${user.firstName} ${user.lastName}</td>
					<td>${user.email}</td>
					<c:if test = "${currentUser.roles.get(0).name.contains('ROLE_SUPER_ADMIN')}">
				        <td><a href="/delete/${user.id}">Delete</a> <a href="/admin/${user.id}">Make Admin</a></td>
				    </c:if>
				    <c:if test = "${currentUser.roles.get(0).name.contains('ROLE_ADMIN')}">        
				        <c:if test = "${user.roles.get(0).name.contains('ROLE_USER')}">
				        	<td><a href="/delete/${user.id}">Delete</a> <a href="/admin/${user.id}">Make Admin</a></td>
				    	</c:if>
				    	<c:if test = "${user.roles.get(0).name.contains('ROLE_ADMIN')}">
				        	<td>Admin</td>
				    	</c:if>
					    </c:if>
				</tr>
			 </c:if>	
		</c:forEach>
    </tbody>
	</table>
</div>
<div class="container"> 
   	<h3>Guide requests</h3>
	<table class="table table-light">
	<thead> 
    	<tr>
    		<th>Name</th>
    		<th>Email</th>
    		<th>Action</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="guideReq" items="${guideRequests}">
   		        <tr>
					<td>${guideReq.user.firstName} ${guideReq.user.lastName}</td>
					<td>${guideReq.user.email}</td>
				    <td class="d-flex">
	<form:form action="/guides/approveGuide/${guideReq.id}" method="post">
		<input type="hidden" value="${guideReq.id}"/>
		<input type="submit" value="Approve" class="btn btn-outline-primary"/>
	</form:form>
	 <a href="/delete/guiderequest/${guideReq.id}" class="btn btn-outline-danger">delete</a></td>
				</tr>
		</c:forEach>
    </tbody>
	</table>
	
</div>
</div>

<div class="container"> 
   	<h3>Guide requests</h3>
	<table class="table table-light">
	<thead> 
    	<tr>
    		<th>Name</th>
    		<th>Email</th>
    		<th>Action</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="guide" items="${allGuides}">
   		        <tr>
					<td>${guide.user.firstName} ${guide.user.lastName}</td>
					<td>${guide.user.email}</td>
				    <td class="d-flex">

	 <a href="/delete/${guide.id}/guide" class="btn btn-outline-danger">Remove</a></td>
				</tr>
		</c:forEach>
    </tbody>
	</table>
	
</div>
</body>
</html>
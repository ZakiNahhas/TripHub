<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TripHub</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
<c:if test="${logoutMessage != null}">
    <c:out value="${logoutMessage}"></c:out>
</c:if>
<h1>Login</h1>
<c:if test="${errorMessage != null}">
    <c:out value="${errorMessage}"></c:out>
</c:if>
    
<form:form action="/makeguide/{user.id}" method="post" modelAttribute="newGuide">
	<table>
		<thead>
	    	<tr>
	            <td colspan="2">Become a Guide</td>
	        </tr>
	    </thead>
	    <tbody>
	    	<tr>
	            <td class="float-left">Languages:</td>
	            <td class="float-left">
	            <form:errors path="languages" class="text-danger"/>    
	            <form:select path="languages" placeholder="Choose a Language..." class="form-controll">
                    <c:forEach var="lang" items="${choiceLanguages }" >
		            	  <option value="${lang}" class="text-capitalize w-100">${lang}</option>
                    </c:forEach>
                 </form:select>
	            </td>
	        </tr>
            <tr>
                <td class="float-left">License:</td>
                <td class="float-left">                     
                  <form:input type="number" path="license"/>
                  <form:errors path="license" class="text-danger"/>
	            </td>
            </tr>
            <tr>
	        	<td colspan=2><input class="input" class="button" type="submit" value="Submit" class="btn btn-outline-success"/></td>
	        </tr>
	    </tbody>
	</table>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW USER</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<h2 class="text-center">Register!</h2>
	</div>
	<div class="row justify-content-center">
	<p><form:errors path="user.*"/></p>
	
		<div class="col-6 p-2">
			<form:form action="/registration" method="post" modelAttribute="user">
				<div class="row justify-content-start">
					<div class="col-6">
						<form:label path="email">Mail:</form:label>
					</div>
					<div class="col-6">  
						<form:input path="email" type="email" class="w-100"/>
					</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="email"/></p>
					</div>
					<div class="col-6">

						<form:label for="inputPassword5" path="password">Password:</form:label>
					</div>
					<div class="col-6">  
						<form:input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock" path="password"/>
					</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="password"/></p>
					</div>
					<div class="col-6">
						<form:label for="inputPassword5" path="passwordConfirmation">Password Confirmation:</form:label>
					</div>
					<div class="col-6">  
						<form:input id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock" path="passwordConfirmation" type="password"/>
						
						</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="passwordConfirmation"/></p>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2">
						<input type="submit" value="Register!" class="btn btn-success"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
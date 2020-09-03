<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="text-center">New Category</h2>
	</div>
	<div class="row justify-content-center">
		<div class="col-6 p-2">
			<form:form action="/product/new" method="post" modelAttribute="product">
				<div class="row justify-content-start">
					<div class="col-6">
						<form:label path="name">Name:</form:label>
					</div>
					<div class="col-6">  
						<form:input path="name" class="w-100"/>
					</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="name"/></p>
					</div>
					<div class="col-6">
						<form:label path="description">description:</form:label>
					</div>
					<div class="col-6">  
						<form:input path="description"/>
					</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="description"/></p>
					</div>
					<div class="col-6">
						<form:label path="name">Price:</form:label>
					</div>
					<div class="col-6">  
						<form:input path="price" type="number"/>
					</div>
					<div class="col-12">
						<p class="text-danger"><form:errors path="price"/></p>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-2">
						<input type="submit" value="Submit" class="btn btn-success"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
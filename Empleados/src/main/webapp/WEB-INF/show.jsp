<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees List</title>
</head>
<body>
<div class="container">
			<div class="row justify-content-center">
				<div class="col-8 p-3">
					<div class="row justify-content-center">
						<div class="col-4 p-2">
						<h1>Empleado :<c:out value="${employe.first_name}"/> <c:out value="${employe.last_name}"/></h1>
						<c:if test="${not empty employe.getManager()}" >
							<div class="col-8 p-3">
								<div class="row justify-content-center">
							        <table class="table">
							        	<thead>
							        		<tr>
								        		<th scope="col">First Name</th>
								        		<th scope="col">Last Name</th>
								        		<th scope="col">Manager</th>
								        	</tr>					        		
							        	</thead>
							        	<c:forEach items="${dojo.getNinjas()}" var="ninja">								    
									        <tr>
									            <td><c:out value="${ninja.getFirstName()}"/></td>
									            <td><c:out value="${ninja.getLastName()}"/></td>
									            <td><c:out value="${ninja.getAge()}"/></td>
									        </tr>
							        	</c:forEach>
							        </table>
								</div>
							</div>
						</c:if>
						<c:if test="${empty employe.getManager()}" >
							<div class="row justify-content-center p-5">						
								<h1 class="text-center">ingresa tu manager...</h1>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
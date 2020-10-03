<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<a href="/logout">Logout</a>
	
	<table class="table">
    <thead>
        <th>Show</th>
        <th>Network</th>
        <th>Raiting</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0].name}</td>
            <td>${row[1].Language}</td>
            <td>${row[1].percentage}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	
	
	<a href="/shows/new">Add a Show</a>
</body>
</html>
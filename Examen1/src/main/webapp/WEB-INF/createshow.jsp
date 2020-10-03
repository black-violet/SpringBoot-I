<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Show</title>
</head>
<body>
<h1>mi nuevo show</h1>
<p><form:errors path="tvshows.*"/></p>
    
    <form:form method="POST" action="/shows/new" modelAttribute="tvshow">
    <h1><c:out value="${creator.name}"/> <c:out value="${employe.last_name}"/></h1>
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso</title>
</head>
<body>
	<p><c:out value="${error}"/></p>
	<h1>Blanco por dentro, verde por fuera, si quieres saberlo espera?</h1>
	<form action="/code" method="get">
		<div class="form-group">
			<div class="col-sm-10">
 				<input type="text" class="form-control" name="code" id="code" placeholder="code" required="required"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ingresar</button>
			</div>
		</div>
	</form>
</body>
</html>
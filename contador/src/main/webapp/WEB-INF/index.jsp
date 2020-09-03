<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
        <h1>Hello World</h1>
        
		<h1>Aca va una cuenta</h1>
	    <div class="contenedor">
	    <form action=cuenta method="get">	  
	     <input type="submit" value="click" name="ok"/>
		 <%  
		 Integer count = (Integer) session.getAttribute("count");
	  		if(request.getAttribute("count")!=null){
	           out.print(String.format("has hecho "+count+ " click"));
	       }
	%>
	</form>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW EMPLOYE</title>
</head>
<body>
<div class="container">
			<div class="row justify-content-center">
				<div class="col-8 p-3">
					<div class="row justify-content-center border-bottom pb-2">
						<h2 class="text-center">New Employe</h2>
					</div>
					<div class="row justify-content-center">
						<div class="col-4 p-2">
							<form:form action="new" method="post" modelAttribute="employe">
								<table>
                <tr>
                    <td><form:label path="first_name">First Name</form:label></td>
                    <td><form:input path="first_name"/></td>
                    <td><p class="text-danger"><form:errors path="first_name"/></p></td>
                </tr>
                <tr>
                    <td><form:label path="last_name">last Name</form:label></td>
                    <td><form:input path="last_name"/></td>
                    <td><p class="text-danger"><form:errors path="last_name"/></p></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create"/></td>
                </tr>
            </table>
        </form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
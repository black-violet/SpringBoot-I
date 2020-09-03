<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<title>Information for <c:out value="${language.name}" /></title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col p-4">
					<div class="row p-2 justify-content-center">
						<div class="col-8">
							<div class="row justify-content-center border-bottom mb-4">
								<h2 class="text-start"><c:out value="${language.name}" /></h2>
							</div>
							<div class="row justify-content-start">
								<h5 class="text-start">Creator: <c:out value="${language.creator}" /></h5>
							</div>
							<div class="row justify-content-start mb-4">
								<h5 class="text-start">Current Version: <c:out value="${language.version}" /></h5>
							</div>
							<div class="row justify-content-center border-top pt-3">
								<div class="col-sm-6-offset-3 border-right px-5">
			            			<form action="/languages/<c:out value="${language.id}"/>" method="post">
			            				<input type="hidden" name="_method" value="delete">
    									<input type="submit" class="btn btn-link" value="delete">
			            			</form>
			            		</div>
			            		<div class="col-sm-6-offset-3 border-left px-5">
			            			<form action="/languages/edit/<c:out value="${language.id}"/>" method="get">
    									<input type="submit" class="btn btn-link" value="edit">
			            			</form>
			            		</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
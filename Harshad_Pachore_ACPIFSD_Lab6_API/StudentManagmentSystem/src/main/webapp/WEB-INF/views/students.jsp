<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Directory</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="/application/students/list">Student
		Directory</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"> </span>
	</button>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item"><a class="nav-link" href="/application/logout">Logout
				<span class="sr-only">(current)</span>
		</a></li>
	</ul>
	</nav>
	<div class="container">

		<br> <br>
		<h3>Student Directory</h3>
		<hr>

		<!-- Add a button -->
		<a href="/application/students/insert"
			class="btn btn-dark btn-sm mb-3 float-left"> Add Student </a>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Course</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="Student">
					<tr>
						<td><c:out value="${Student.firstName}" /></td>
						<td><c:out value="${Student.lastName}" /></td>
						<td><c:out value="${Student.course}" /></td>
						<td><c:out value="${Student.country}" /></td>
						<td>
							<a
							href="/application/students/update?id=${Student.id}"
							class="btn btn-info btn-sm"> Update </a>
							<a href="/application/students/delete?id=${Student.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
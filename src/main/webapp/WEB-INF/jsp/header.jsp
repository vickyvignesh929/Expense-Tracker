<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Expensa</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="css/dashboardstyle.css">
<link rel="stylesheet" href="css/headerstyle.css">
<link rel="stylesheet" href="css/bottom.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600"
	rel="stylesheet" type="text/css">
<link
	href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<body>
	<%
		if (session.getAttribute("user") == null)
		response.sendRedirect("login");
	%>
	<%!long millis = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(millis);%>
	<nav>
		<label class="logo"> Expensa</label>
		<ul>
			<li><a class="active" href="home">Home</a></li>
			<li><a href="#">Analysis <i class="down"></i>
			</a>
				<ul>
					<li><a href="#">monthly</a>
						<ul>
							<li><a href="monthlyincomechart">income</a></li>
							<li><a href="monthlyexpensechart">expense</a></li>
						</ul></li>
					<li><a href="#">yearly</a>
						<ul>
							<li><a href="yearlyincomechart">income</a></li>
							<li><a href="yearlyexpensechart">expense</a></li>
						</ul></li>
				</ul></li>
			<li><a href="#">custom search</a>
				<ul>
					<li><a class="siz" href="customsearch">monthly</a></li>
					<li><a class="siz1" href="customyearsearch">yearly</a></li>
				</ul>
			
			</li>
			<li><a href="#">settings</a>
				<ul>
					<li><a class="siz" href="addacategory">add a category</a></li>
					<li><a class="siz1" href="limitpage">set a monthly limit</a></li>
				</ul></li>
			<li class="boom username"><a href="#"><%=session.getAttribute("user")%></a></li>
			<li><a class="logout boom" href="logout">log out</a></li>
		</ul>
	</nav>
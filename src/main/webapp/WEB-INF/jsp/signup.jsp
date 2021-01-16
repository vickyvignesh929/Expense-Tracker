<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup page</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/dashboardstyle.css" type="text/css" rel="stylesheet" />
<link href="css/headerstyle.css" type="text/css" rel="stylesheet" />

<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">


</head>
<body>
	
	<div class="qoute">
		<h3>"Never spend your money before you have earned it"</h3>
	</div>
	<div class="wrapper">
		<div class="title">signin Form</div>
		<f:form action="adduser" method="post" modelAttribute="userdata">
			<div class="content">
				<f:errors path="username" cssClass="warning"></f:errors>
			</div>
			<div class="field">
				<input type="email" name="email" required="required" autofocus="autofocus"> <label>Email
					Id</label>
			</div>
			<div class="field">
				<input type="text" name="username" required> <label>Username</label>
			</div>

			<div class="field">
				<input type="password" id="password" name="password"
					onkeyup='check();' required> <label>Password</label>
			</div>
			<div class="field">
				<input type="password" id="confirm_password" onkeyup='check();'
					required> <label>re-type Password</label>
			</div>
			<div class="content">
				<span id='message'></span>
			</div>

			<div class="content">
				<div class="checkbox">
					<input type="checkbox" id="remember-me"> <label
						for="remember-me">Remember me</label>
				</div>

			</div>
			<div class="field">
				<input type="submit" value="signup"
					onclick="return validatePassword()">
			</div>
			<div class="signup-link">
				Already a member? <a href="login">Login now</a>
			</div>
		</f:form>
	</div>
	<script src="js/app.js"></script>
</body>

</html>
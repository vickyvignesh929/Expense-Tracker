<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<link rel="icon" href="https://image.flaticon.com/icons/svg/845/845665.svg" type="image/x-icon">
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
</head>
<body>
	<div class="qoute">
	<h3>"the art is not in making money, but in keeping it"</h3>
	
	
	</div>
	<div class="wrapper">
		<div class="title">Login Form</div>
		<f:form action="dashboard" method="post" modelAttribute="userdata">
			<div class="content">
				<f:errors class="warning" path="username"></f:errors>
			</div>
			<div class="field">
				<input type="text" name="username"> <label>Username</label>
			</div>
			<div class="field">
				<input type="password" name="password" required> <label>Password</label>
			</div>
			<div class="content">
				<div class="checkbox">
					<input type="checkbox" id="remember-me"> <label
						for="remember-me">Remember me</label>
				</div>
				<div class="pass-link">
					<a href="#">Forgot password?</a>
				</div>
			</div>
			<div class="field">
				<input type="submit" value="Login">
			</div>
			<div class="signup-link">
				Not a member? <a href="signup">Signup now</a>
			</div>
		</f:form>
	</div>
</body>
</html>
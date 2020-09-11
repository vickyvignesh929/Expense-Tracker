<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>category-Expensa</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<link rel="stylesheet" href="css/category.css">
<link>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="categorycontainer boom">
		<div class="text">Add a category</div>
		<form action="addcategory">
			<div class="form-row">

				<div class="input-data">
					<input list="categorys" name="function" required>
					<datalist id="categorys">
						<option value="income">
						<option value="expense">
					</datalist>
					<div class="underline"></div>
					<label for="">add to</label>
				</div>
				<div class="input-data">
					<input type="text" name="category" required>
					<div class="underline"></div>
					<label for="">category name</label>
				</div>
			</div>
			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="Add">
				</div>
			</div>

		</form>
	</div>

</body>
</html>
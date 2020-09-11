<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>limit-Expensa</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<link rel="stylesheet" href="css/limitpage.css">
<link rel="stylesheet" href="css/category.css">

<link>
</head>
<body>
	<%@ include file="header.jsp"%>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/expense_tracker" user="root"
		password="Vicky@@@12345" />
	<div class="categorycontainer boom">
		<div class="text">Add a category</div>
		<f:form action="addlimit" modelAttribute="limit">
			<div class="form-row">
				<div class="input-data">
					<sql:query dataSource="${db}" var="rs4">select category from expense_category where category not in (select limit_category from monthly_limit_table where username="${user}");
</sql:query>
					<input list="limitCategory" name="limitCategory" id="limitCategorys"
						required>
					<datalist id="limitCategory">
						<c:forEach var="row" items="${rs4.rows}">
							<option value="<c:out value="${row.category}"></c:out>">
						</c:forEach>
					</datalist>
					<div class="underline"></div>
					<label for="">select a category</label>
				</div>
				<div class="input-data">
					<input type="number" name="limitAmount" required>
					<div class="underline"></div>
					<label for="">limit amount</label>
				</div>
			</div>
			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="Add">
				</div>
			</div>

		</f:form>
	</div>
	<div class="bottom">
		<div class="container2 clearfix">
			<div class="limit">
				<h2 class="limit__title">MONTHLY LIMIT</h2>
				<div class="limit__list">
					<div class="item clearfix" id="income-0">
						<div class="limit__description">CAREGORY</div>
						<div class="right clearfix">
							<div class="limit__value">LIMIT AMOUNT</div>
						</div>
					</div>

					<sql:query dataSource="${db}" var="rs">select limit_category,limit_amount from monthly_limit_table where username = "${user}"</sql:query>

					<c:forEach var="row" items="${rs.rows}">
						<div class="item clearfix">
							<div class="lim__description">
								<c:out value="${row.limit_category}"></c:out>
							</div>
							<div class="right clearfix">
								<div class="lim__value">
									<c:out value="${row.limit_amount}"></c:out>
								</div>
								<div class="lim__delete">
									<a class="lim__delete--btn delbt" href="deletelimit?category=${row.limit_category}" >delete</a>
								</div>
							</div>
						</div>

					</c:forEach>

				</div>
			</div>
		</div>


	</div>

</body>
</html>
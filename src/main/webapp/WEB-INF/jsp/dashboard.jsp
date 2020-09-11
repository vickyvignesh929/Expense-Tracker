<%@page import="java.util.Date"%>
<%@include file="header.jsp"%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/expense_tracker" user="root"
	password="Vicky@@@12345" />


	<sql:query dataSource="${db}" var="rs6">select limit_category from
 (select limit_category,limit_amount from monthly_limit_table where username="${user}") a join
 (select expense_category,sum(expense_amount) as total_amount  from expense_table where username="${user}" and MONTH(expense_date) = MONTH(CURRENT_DATE()) group by expense_category) b on
 a.limit_category=b.expense_category where b.total_amount > a.limit_amount;</sql:query>
	<c:forEach var="row" items="${rs6.rows}">
		<div class="alert  show showAlert">
		<span class="msg"><c:out value="Alert: '${row.limit_category}'"></c:out>
			Limit reached
		</span>
		<div class="close-btn">
		<a class="fas fa-times">close</a>
	</div>
</div>
	</c:forEach>
	
<script>
	$('.close-btn').click(function() {
		$('.alert').removeClass("show");
		$('.alert').addClass("hide");
	});
</script>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/expense_tracker" user="root"
	password="Vicky@@@12345" />
<sql:update dataSource="${db}">update userdata set total_amount=
(case
when(select sum(income_amount) from income_table where username="${user}") is null  then 0
when(select sum(income_amount) from income_table where username="${user}")!=0 then (select sum(income_amount) from income_table where username="${user}")
end)-(case
when(select sum(expense_amount) from expense_table where username="${user}") is null then 0
when(select sum(expense_amount) from expense_table where username="${user}")!=0 then (select sum(expense_amount) from expense_table where username="${user}")
end) where username="${user}"</sql:update>
<sql:query dataSource="${db}" var="rs">select total_amount from userdata where username = "${user}"</sql:query>
<div class="balance">
	<div class="total boom">
		your balance :
		<c:forEach var="row" items="${rs.rows}">
			<c:out value="${row.total_amount}"></c:out>
		</c:forEach>
	</div>
	<div class="today">
		<sql:query dataSource="${db}" var="rs3">select sum(income_amount) as amount from income_table where username="${user}" and income_date="<%=date%>"</sql:query>
		<p class="boom">
			today's income:
			<c:forEach var="row" items="${rs3.rows}">
				<c:out value="${row.amount}"></c:out>
			</c:forEach>
		</p>
		<sql:query dataSource="${db}" var="rs3">select sum(expense_amount) as amount from expense_table where username="${user}" and expense_date="<%=date%>"</sql:query>
		<p class="boom">
			today's expense:
			<c:forEach var="row" items="${rs3.rows}">
				<c:out value="${row.amount}"></c:out>
			</c:forEach>
		</p>
	</div>
</div>
<div class="main-container">
	<div class="container boom">
		<div class="text">Income</div>
		<f:form action="addincome" modelAttribute="income">
			<div class="form-row ">

				<div class="input-data">

					<input type="date" required name="date" id="myDate">
					<div class="underline"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input list="category" id="categorys" name="category">
					<datalist id="category">
						<sql:query dataSource="${db}" var="rs4">select * from income_category</sql:query>
						<c:forEach var="row" items="${rs4.rows}">
							<option value="<c:out value="${row.category}"></c:out>">
						</c:forEach>

					</datalist>
					<div class="underline"></div>
					<label for="">category</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" required name="description">
					<div class="underline"></div>
					<label for="">Description</label>
				</div>

			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="number" required name="amount">
					<div class="underline"></div>
					<label for="">Amount</label>
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
	<div class="container boom">
		<div class="text">Expense</div>
		<f:form action="addexpense" modelAttribute="expense">
			<div class="form-row ">
				<div class="input-data">
					<input type="date" required name="date" id="myDate2">
					<div class="underline"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input list="category2" id="categorys" name="category">
					<datalist id="category2">
						<sql:query dataSource="${db}" var="rs5">select * from expense_category</sql:query>
						<c:forEach var="row" items="${rs5.rows}">
							<option value="<c:out value="${row.category}"></c:out>">
						</c:forEach>

					</datalist>
					<div class="underline"></div>
					<label for="">category</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" required name="description">
					<div class="underline"></div>
					<label for="">Description</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="number" required name="amount">
					<div class="underline"></div>
					<label for="">Amount</label>
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
</div>
<div class="bottom">

	<div class="containers clearfix">
		<div class="income">
			<h2 class="icome__title">Income</h2>

			<div class="income__list">


				<sql:query dataSource="${db}" var="rs1">select income_description,income_amount,income_id from income_table where income_date = "<%=date%>" and username="${user}"
							</sql:query>
				<c:forEach var="row" items="${rs1.rows}">

					<div class="item clearfix" id="income-0">
						<div class="item__description">
							<c:out value="${row.income_description}" />
						</div>
						<div class="right clearfix">
							<div class="item__value">
								<c:out value="${row.income_amount}" />
							</div>
							<div class="item__delete">
								<a href="deleteincome?id=${row.income_id}"
									class="item__delete--btn"> <i class="ion-ios-close-outline"></i>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
		<div class="expenses">
			<h2 class="expenses__title">Expenses</h2>
			<div class="expenses__list">
				<sql:query dataSource="${db}" var="rs2">select expense_description,expense_amount,expense_id from expense_table where expense_date = "<%=date%>" and username="${user}"
					</sql:query>
				<c:forEach var="row" items="${rs2.rows}">
					<div class="item clearfix" id="income-0">
						<div class="item__description">
							<c:out value="${row.expense_description}" />
						</div>
						<div class="right clearfix">
							<div class="item__value">
								<c:out value="${row.expense_amount}" />
							</div>
							<div class="item__delete">
								<a href="deleteexpense?id=${row.expense_id }"
									class="item__delete--btn"> <i class="ion-ios-close-outline"></i>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


<script>
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //As January is 0.
	var yyyy = today.getFullYear();
	if (dd < 10)
		dd = '0' + dd;
	if (mm < 10)
		mm = '0' + mm;
	document.getElementById("myDate").value = yyyy + '-' + mm + '-' + dd;
	document.getElementById("myDate2").value = yyyy + '-' + mm + '-' + dd;
</script>
</body>
</html>
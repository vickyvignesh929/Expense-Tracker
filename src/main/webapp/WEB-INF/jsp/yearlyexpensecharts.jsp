<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Analysis-Expensa</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '${pageContext.request.contextPath}/yearlyexpensedata',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
					drawChart(result);
				});
			}
		});

		function drawChart(result) {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'category');
			data.addColumn('number', 'amount');
			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.category, obj.amount ]);
			});

			data.addRows(dataArray);

			var piechart_options = {
				width : 1920,
				height : 700,
				is3D: true
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('piechart_div'));
			piechart.draw(data, piechart_options);

			var barchart_options = {
				width : 400,
				height : 300,
				legend : 'none'
			};
			var barchart = new google.visualization.BarChart(document
					.getElementById('barchart_div'));
			barchart.draw(data, barchart_options);
		}

	});
</script>

</head>
<body>
<%@include file="header.jsp" %>
			<div class="thistext">THIS YEAR EXPENSE DATA</div>
			<div id="piechart_div" style="border: 1px solid #ccc"></div>
			<%--<div id="barchart_div" style="border: 1px solid #ccc"></div> --%>

</body>
</html>
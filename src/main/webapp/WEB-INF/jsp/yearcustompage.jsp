<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom search</title>
<link rel="icon"
	href="https://image.flaticon.com/icons/svg/845/845665.svg"
	type="image/x-icon">
<link rel="stylesheet" href="css/category.css">
<link>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	function searching() {

		var year = document.getElementById("year").value;
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '${pageContext.request.contextPath}/searchyeardata?year='
					+ year,
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
				is3D : true
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('piechart_div'));
			piechart.draw(data, piechart_options);S

			var options = {
				width : 800,
				legend : {
					position : 'none'
				},
				chart : {
					title : 'Chess opening moves',
					subtitle : 'popularity by percentage'
				},
				axes : {
					x : {
						0 : {
							side : 'top',
							label : 'White to move'
						}
					// Top x-axis.
					}
				},
				bar : {
					groupWidth : "90%"
				}
			};

			var linechart = new google.charts.Bar(document
					.getElementById('top_x_div'));
			// Convert the Classic options to Material options.
			linechart.draw(data, google.charts.Bar.convertOptions(options));

		}

	}
</script>
</head>
<body>

	<%@ include file="header.jsp"%>
	<div class="categorycontainer boom">
		<div class="text">custom search</div>
		<form onsubmit="return searching()" action="javascript:void(0);">
			<div class="form-row">

				<div class="input-data">
					<input type="text" id="year" required>
					<div class="underline"></div>
				</div>

			</div>
			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="search" id="search">
				</div>
			</div>

		</form>

	</div>

	<div class="piechart" id="piechart_div" style=""></div>

</body>
</html>
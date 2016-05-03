<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Random,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liberty 2016 standard page</title>

<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
	<div class="container-fluid">

		<h1>Hello JSP</h1>

		<%
			java.util.Date date = new java.util.Date();
		%>

		<h2>
			Now is
			<%=date%>
		</h2>

		<%
			Random random = new Random();

			// Trả về ngẫu nhiên (0, 1 hoặc 2).
			int randomInt = random.nextInt(3);

			if (randomInt == 0) {
		%>

		<h1>
			Random value =<%=randomInt%></h1>

		<%
			} else if (randomInt == 1) {
		%>

		<h2>
			Random value =<%=randomInt%></h2>

		<%
			} else {
		%>
		<h3>
			Random value =<%=randomInt%></h3>
		<%
			}
		%>

		<a href="<%=request.getRequestURI()%>">Try Again</a>

	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>
</html>
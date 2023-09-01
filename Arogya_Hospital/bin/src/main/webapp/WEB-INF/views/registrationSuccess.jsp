<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<style>
body {
	text-align: center;
	margin-top: 10%;
}

button {
	width: 90px;
	font-size: 16px;
	padding: 8px;
	border-radius: 14px;
	transition-duration: 0.4s;
}

button:hover {
	background-color: rgb(143, 143, 143);
	color: rgb(0, 0, 0);
	border: 2px solid rgb(0, 0, 0);
}
</style>
</head>
<body>
	<h2>Succesfully Registered</h2>
	<br>
	<%
	String contextPath = request.getContextPath();
	%>
	<button>
		<a href="<%=contextPath%>/redirectToLogin">Login</a>
	</button>
</body>
</html>
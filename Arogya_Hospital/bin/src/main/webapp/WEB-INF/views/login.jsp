<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<style>
body {
	margin-top: 12%;
}

td {
	font-size: 22px;
	padding: 8px;
	border-radius: 18px;
}

button {
	width: 90px;
	font-size: 16px;
	padding: 8px;
	border-radius: 14px;
	margin-left: 30%;
	transition-duration: 0.4s;
}

button:hover {
	background-color: rgb(143, 143, 143);
	color: rgb(0, 0, 0);
	border: 2px solid rgb(0, 0, 0);
}

input {
	font-size: 16px;
	border-radius: 13px;
	padding: 6px;
}

#spl {
	font-size: 20px;
	margin-left: 20%;
}
</style>
</head>

<body>
	<center>
		<form action="authenticate" method="POST">
			<h1>Login Page</h1>
			<table border="0" width="auto">
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName" value="" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="" required></td>
				</tr>
				<tr>
					<%
					// Get the servlet context
					String contextPath = request.getContextPath();
					%>
					<td><a
						href="<%= contextPath %>/redirectToRegistration"
						id="spl">Sign Up</a></td>
					<td><button type="submit" name="bname" value="submit">Sign In</button></td>
				</tr>
			</table>
		</form>
	</center>
</body>

</html>
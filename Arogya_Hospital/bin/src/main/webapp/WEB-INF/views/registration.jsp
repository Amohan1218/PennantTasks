<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
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
	margin-left: 30%;
}
</style>
</head>

<body>
	<center>
		<form action="createUser" method="POST" onsubmit="validate(event)">
			<h1>User Registration</h1>
			<table border="0" widtd="auto">
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName" id="username" value=""
						required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password"
						value="" required></td>
				</tr>
				<tr>
					<td>Confirm Pwd</td>
					<td><input type="password" name="cnfpassword" id="cnfpassword"
						value="" required></td>
				</tr>
				<tr>
					<%
					// Get the servlet context
					String contextPath = request.getContextPath();
					%>
					<td><a href="<%=contextPath%>/redirectToLogin" id="spl">Sign
							In</a></td>
					<td><button name="bname" id="bname" type="submit"
							value="submit">Sign Up</button></td>
				</tr>
			</table>
		</form>
	</center>
	<script>
		function validate(event) {
			event.preventDefault();
			var pwd = document.getElementById("password").value;
			var cnfpwd = document.getElementById("cnfpassword").value;

			if (pwd != cnfpwd) {
				window.alert("Confirm Password must be same as above password..!!");
			} else {
				event.target.submit();
			}
		}
	</script>
</body>

</html>
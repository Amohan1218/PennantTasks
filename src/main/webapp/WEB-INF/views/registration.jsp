<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>

    <!-- Include Bootstrap CSS (you may need to adjust the URL to your specific Bootstrap version) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body><br><br><br>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="createUser" method="POST" onsubmit="validate(event)">
                    <h1 class="text-center">User Registration</h1><br>
                    <table class="table">
                    	<tr>
                            <td><label for="accType" class="form-label">Account Type</label></td>
                            <td>
                            	<select id="accType" name="accType" class="form-control">
                            		<option value="XXXX">--Select Type--</option>
                            		<option value="ADMN">Administrator</option>
                            		<option value="CUST">Customer</option>
                            	</select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="username" class="form-label">Username</label></td>
                            <td><input type="text" class="form-control" id="username" name="userName" required></td>
                        </tr>
                        <tr>
                            <td><label for="password" class="form-label">Password</label></td>
                            <td><input type="password" class="form-control" id="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td><label for="cnfpassword" class="form-label">Confirm Password</label></td>
                            <td><input type="password" class="form-control" id="cnfpassword" name="cnfpassword" required></td>
                        </tr>
                        <tr>
                            <td><label for="email" class="form-label">Email</label></td>
                            <td><input type="email" class="form-control" id="emailId" name="emailId" required></td>
                        </tr>
                        <tr>
                            <td><label for="recEmailId" class="form-label">Recovery Email</label></td>
                            <td><input type="email" class="form-control" id="recEmailId" name="recEmailId" required></td>
                        </tr>
                        <tr>
                            <td><label for="phNum" class="form-label">Mobile Number</label></td>
                            <td><input type="tel" class="form-control" id="phNum" name="phNum" required></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                            <%
								// Get the servlet context
								String contextPath = request.getContextPath();
							%>
                                <a href="<%=contextPath%>/redirectToLogin" class="btn btn-primary">Sign In</a>
                                <button type="submit" class="btn btn-success" name="bname" id="bname" value="submit">Sign Up</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function validate(event) {
            event.preventDefault();
            var pwd = document.getElementById("password").value;
            var cnfpwd = document.getElementById("cnfpassword").value;

            if (pwd != cnfpwd) {
                window.alert("Confirm Password must be the same as the above password..!!");
            } else {
                event.target.submit();
            }
        }
    </script>
</body>

</html>

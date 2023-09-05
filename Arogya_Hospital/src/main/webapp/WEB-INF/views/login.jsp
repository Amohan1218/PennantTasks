<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body><br><br><br>
    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <form action="authenticate" method="POST">
                    <h1 class="text-center">Login Page</h1><br>
                    <table class="table table-bordered">
                        <tr>
                            <td>Username</td>
                            <td><input type="text" class="form-control" name="userName" value="" required></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" class="form-control" name="password" value="" required></td>
                        </tr>
                        <tr>
                       		 <%
									// Get the servlet context
									String contextPath = request.getContextPath();
							  %>
                            <td><a href="<%= contextPath %>/redirectToRegistration" class="btn btn-primary">Sign Up</a></td>
                            <td><button type="submit" class="btn btn-success" name="bname" value="submit">Sign In</button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>

</html>

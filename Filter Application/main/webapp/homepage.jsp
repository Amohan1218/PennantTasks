<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
    <style>
        body {
            margin-top: 90px;
        }

        button {
            border-radius: 20px;
            width: 25%;
            padding: 16px;
            font-size: 18px;
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
	<% System.out.print(request.getHeader("authKey")); %>>
    <center>
        <form action="getPage" method="post">
            <h1>Homepage</h1>
            <br><br>
            <button id="button1" type="submit" name="url" value="EME_Task">CRUD Employee</button><br> <br> <br>
            <!-- <button id="button1" type="submit" name="url" value="http://localhost:8080/TR_Task/">Train Reservation</button><br> <br> <br>
            <button id="button1" type="submit" name="url" value="http://localhost:8080/EMP_SelfSubmit_Task/">CRUD Self Submission</button> -->
        </form>
    </center>
</body>

</html>























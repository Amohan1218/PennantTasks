<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <!-- Include Bootstrap CSS from a CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .btn{
            width: 35%;
            padding: 25px;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div class="container text-center mt-5">
        <h1 class="display-4">Welcome to Loan Management</h1>
        <div class="keyBtns mt-5">
            <button class="btn btn-primary mt-3" onclick="window.location.href='getApplicationForm'">New Application</button><br><br>
            <button class="btn btn-info mt-3" onclick="window.location.href='getAllLoansStatus'">Application Status</button><br><br>
            <button class="btn btn-secondary mt-3" onclick="window.location.href='getAllAprvdAppts'">Repayment Schedule</button>
        </div>
    </div>

    <!-- Include Bootstrap JavaScript and jQuery (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
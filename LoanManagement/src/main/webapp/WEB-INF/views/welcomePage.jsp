<%@page import="com.folder.orm.model.LoanApplicant"%>
<%@page import="java.util.List, com.folder.orm.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Application</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Your App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Notifications</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Profile</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Content Section -->
    <div class="container mt-4">
        <h1>Welcome to Loan Management Application</h1>
        <!-- Application Cards will be displayed here -->
        <div class="row" id="application-cards">
            <% List<LoanApplicant> l = (List<LoanApplicant>) request.getAttribute("allApplicants"); %>
			<% for (LoanApplicant obj : l) { %>
			    <div class="col-md-4">
			        <div class="card mb-4">
			            <div class="card-body">
			                <h5 class="card-title">Loan Application ID: <%= obj.getId() %></h5>
			                <p class="card-text">Customer Name: <%= obj.getCustomer().getFirstName() %></p>
			                <p class="card-text">Date of Application: <%= obj.getApplicationDate() %></p>
			                <a href="#" class="btn btn-primary">View</a>
			            </div>
			        </div>
			    </div>
			<% } %>
        </div>
    </div>

    <!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

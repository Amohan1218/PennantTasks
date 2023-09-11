<%@page import="com.customer.orm.model.LoanApplicant"%>
<%@page import="java.util.List,com.customer.orm.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Application</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
    	th{
    		padding : 10px;
    	}
    	td{
    		text-align : center;
    	}
    </style>
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
        <div class="row mb-5">
        	<div  class="col">
        		<h1>Welcome Admin..!!</h1>
        	</div>
        	<div class="col col-md-2 mt-3">
        		<button class="btn btn-primary" onclick="window.location.href='downloadExcel'">Download Data⤵</button>
        	</div>
        </div>
        <form method="get" action="filterData">
        <div class="row mb-3">
            <div class="col-md-3">
                <label for="filterDate">Filter by Date:</label>
                <input type="date" class="form-control" id="filterDate" name="filterDate">
            </div>
            <div class="col-md-3">
                <label for="filterLoanAmountFrom">Loan Amount From:</label>
                <input type="number" class="form-control" id="filterLoanAmountFrom" name="filterLoanAmountFrom">
            </div>
            <div class="col-md-3">
                <label for="filterLoanAmountTo">Loan Amount To:</label>
                <input type="number" class="form-control" id="filterLoanAmountTo" name="filterLoanAmountTo">
            </div>
            <div class="col-md-3 mt-2">
                <button type="submit" class="btn btn-primary mt-4">Apply Filters</button>
                <button type="reset" class="btn btn-secondary mt-4">Clear Filters</button>
            </div>
        </div>
    </form>
        <!-- Application Cards will be displayed here -->
        <% List<LoanApplicant> l = (List<LoanApplicant>) request.getAttribute("allApplicants"); 
           HttpSession sess = request.getSession();
           sess.setAttribute("pageData", l);
        %>
		<table border="1">
			<thead>
				<tr>
					<th>Application Id</th>
					<th>Application Date</th>
					<th>Customer Id</th>
					<th>Loan Amount</th>
					<th>Months requested</th>
					<th>Annual Income</th>
					<th>Disposable Income</th>
					<th>Status</th>
					<th>Remarks</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
				<% for (LoanApplicant obj : l) { %>
		  		<tr>
					<td><%= obj.getId() %></td>
					<td><%= obj.getApplicationDate() %></td>
					<td><%= obj.getCustomerId() %></td>
					<td><%= obj.getLoanAmount() %></td>
					<td><%= obj.getNoOfMonthsRequested() %></td>
					<td><%= obj.getAnnualIncome() %></td>
					<td><%= obj.getDisposableIncome() %></td>
					<td><%= obj.getStatus() %></td>
					<td><%= obj.getConclusionRemarks() %></td>
					<td><button class="btn btn-primary">View Application</button></td>
				</tr>
				<% } %>
			</tbody>
		</table>
    </div>

    <!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

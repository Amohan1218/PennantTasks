<%@page import="com.customer.orm.model.LoanApplicant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Applications</title>
    
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <style>
        /* Custom CSS for alternating row colors */
        .table tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        /* Custom CSS for table headings */
        .table thead th {
            background-color: #007bff; /* Blue color for headings */
            color: white; /* Text color for headings */
        }
        td, th{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row mb-5">
        	<div  class="col">
        		<h1>Your Applications</h1>
        	</div>
        	<div class="col col-md-2 mt-3">
        		<button class="btn btn-primary" onclick="window.location.href='downloadExcel'">Download Data⤵</button>
        	</div>
        </div>
        <% List<LoanApplicant> l = (List<LoanApplicant>) request.getAttribute("allLApplicants"); 
           HttpSession sess = request.getSession();
           sess.setAttribute("pageData", l);
        %>
        <table class="table table-bordered mt-5">
            <thead>
                <tr>
                    <th>Application ID</th>
                    <th>Customer ID</th>
                    <th>Loan Amount</th>
                    <th>Get EMI Schedule</th>
                </tr>
            </thead>
            <tbody>
                <!-- Add your table rows with data here -->
                <% for (LoanApplicant obj : l) { %>
                <tr>
                    <td><%= obj.getId() %></td>
                    <td><%= obj.getCustomerId() %></td>
                    <td><%= obj.getLoanAmount() %></td>
                    <td><button onclick="window.location.href='getEMISchedule?appId='+`${obj.getId()}`">Get Schedule</button></td>
                </tr>
                <%} %>
            </tbody>
        </table>
    </div>

    <!-- Add Bootstrap JavaScript and jQuery (if needed) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

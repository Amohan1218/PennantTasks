<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Application Status</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function updateStatus(status) {
            document.getElementById("status").innerHTML = status;
        }
    </script>
</head>
<body class="text-center">
    <div class="container">
        <h1 class="mt-5">Welcome ${custName}..!</h1>
        <button class="btn btn-primary mt-3" onclick="updateStatus('Application Submitted')">View Application Status</button>
        <div class="mt-3">
            <strong>Status:</strong> <span id="status">Status will be displayed here.</span>
        </div>
    </div>

    <!-- Include Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>

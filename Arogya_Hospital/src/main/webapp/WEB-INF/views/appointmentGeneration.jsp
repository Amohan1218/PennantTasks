<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Confirmation</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="alert alert-success">
                    <h4 class="alert-heading">Your Appointment Successfully Registered</h4>
                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Appointment Details</h5>
                        <!-- Display appointment details here -->
                        <p><strong>Appointment ID:</strong> ${AppId}</p>
                        <p><strong>Appointment Date:</strong> ${date}</p>
                        <p><strong>Slot ID:</strong> ${slotId}</p>
                        <p><strong>Doctor ID:</strong> ${DocId}</p>
                        <p><strong>Patient ID:</strong> ${pid}</p>
                        <p><strong>Patient Full Name:</strong> ${fullName}</p>
                        <p><strong>Age:</strong> ${age}</p>
                        <p><strong>Gender:</strong> ${gender}</p>
                        <p><strong>Contact Number:</strong> ${ContactNumber}</p>
                        <p><strong>Slot Timings:</strong> ${SlotTimings}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Include Bootstrap JS (optional) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

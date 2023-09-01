<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Doctor Profile</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Add your custom CSS styles here -->
    <style>
        /* Customize your styles here */
        .card {
            width: 300px;
            margin: 20px;
        }
    	.vbtn{
    		margin-left: 28%;
    	}
    	.crd{
    		margin-left: 35%;
    		margin-top: 10%;
    	}
    </style>
</head>

<body>
    <div class="container">
        <!-- Card container -->
        <div class="card crd">
            <!-- Card image -->
            <img src="${DoctorInfo.imageUrl}" class="card-img-top" alt="Doctor's Photo">
            <div class="card-body">
                <!-- Full Name -->
                <h5 class="card-title">${DoctorInfo.fullName}</h5>
                <!-- Designation -->
                <p class="card-text">${DoctorInfo.designation}</p>
                <!-- Qualification -->
                <p class="card-text"><strong>Qualification:</strong> ${DoctorInfo.qualification}</p>
                <!-- Experience -->
                <p class="card-text"><strong>Experience: </strong>${DoctorInfo.experience} years</p>
                <!-- Book Slot Button -->
                <a href="#" class="btn btn-success vbtn">Book Slot</a>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
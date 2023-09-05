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
    		margin-left: 36%;
    		margin-top: 4%;
    	}
    	body{
    		background-color : #61677A;
    	}
    	h1{
    		color : #D8D9DA;
    		font-size : 40px;
    		text-align : center;
    	}
    </style>
</head>

<body>
	<h1 class="mt-4">Doctor Details</h1>
    <div class="container">
        <!-- Card container -->
        <div class="card crd shadow">
            <!-- Card image -->
            <img src="${DoctorInfo.img}" class="card-img-top" alt="Doctor's Photo" width="auto" height="300px">
            <div class="card-body">
                <!-- Full Name -->
                <h5 class="card-title">${DoctorInfo.docName}</h5>
                <!-- Designation -->
                <p class="card-text">${DoctorInfo.spec}</p>
                <!-- Qualification -->
                <p class="card-text"><strong>Qualification:</strong> ${DoctorInfo.qual}</p>
                <!-- Experience -->
                <p class="card-text"><strong>Experience: </strong>${DoctorInfo.exp} years</p>
                <!-- Book Slot Button -->
                <form action="getCalendar" method="POST">
					<input type="hidden" name="docId" value="${DoctorInfo.docId}">
 	                <button type="submit" class="btn btn-success vbtn">Book Slot</button>
				</form>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
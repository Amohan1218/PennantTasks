<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Doctor List</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	.vbtn{
    		margin-left: 26%;
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
    <div class="container">
        <h1 class="mt-4">Hospital's Doctors</h1><br>
        
        <!-- Search Box -->
        <div class="input-group mt-3 mb-3 shadow">
            <input type="text" class="form-control" id="searchInput" placeholder="Search by name or designation">
            <div class="input-group-append shadow">
                <button class="btn btn-primary" type="button" onclick="filterDoctors()">Search</button>
            </div>
        </div><br>
        
        <!-- Doctor Cards -->
        <div class="row" id="doctorCards">
            <c:forEach var="doctor" items="${DoctorList}">
                <div class="col-md-3" id="cardd">
                    <div class="card mb-4 shadow">
                        <!-- Doctor Image -->
                        <img src="${doctor.img}" class="card-img-top" alt="${doctor.docName}" width="auto" height="250px">
                        <div class="card-body">
                            <!-- Doctor Title -->
                            <h5 class="card-title">${doctor.docName}</h5>
                            <!-- Doctor Subtitle -->
                            <h6 class="card-subtitle mb-2 text-muted">${doctor.spec}</h6>
                            <!-- View Details Button -->
                            <form action="showDocInfo" method="POST">
                        		<input type="hidden" name="docId" value="${doctor.docId}">
 	                        	<button type="submit" class="btn btn-success vbtn">View Details</button>
                        	</form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script>
        // Function to filter doctors based on user input
        function filterDoctors() {
            var searchInput = document.getElementById('searchInput').value.toLowerCase();
            var doctorCards = document.getElementById('doctorCards').children;
            
            for (var i = 0; i < doctorCards.length; i++) {
                var card = doctorCards[i];
                var title = card.getElementsByClassName('card-title')[0].innerText.toLowerCase();
                var subtitle = card.getElementsByClassName('card-subtitle')[0].innerText.toLowerCase();
                
                if (title.includes(searchInput) || subtitle.includes(searchInput)) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            }
        }
    </script>
</body>
</html>


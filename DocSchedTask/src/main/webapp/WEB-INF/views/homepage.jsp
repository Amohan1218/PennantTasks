<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Profiles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
			background-color:grey;
            margin: 5%;
            padding: 0;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: flex-start;
            padding: 20px;
        }
        .doctor-card {
            width: 30%;
            margin: 10px;
            padding: 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        .doctor-img {
            width: 100%;
            max-width: 200px;
            height: auto;
            border-radius: 50%;
            margin-bottom: 10px;
        }
        .doctor-name {
            font-weight: bold;
        }
        .doctor-qualification {
            color: black;
			
        }
        .button-container {
            margin-top: 10px;
        }
        .profile-button {
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
  <h1>Welcome!</h1>
  <h4>DOCTORS IN OUR HOSPITAL</H4>
    <div class="container">
        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. Jane Doe" class="doctor-img">
            <div class="doctor-name">Dr. Jane Doe</div>
            <div class="doctor-qualification">MD Neurology</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(2)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. Michael Johnson" class="doctor-img">
            <div class="doctor-name">Dr. Michael Johnson</div>
            <div class="doctor-qualification">MD Orthopedics</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(3)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. David Brown" class="doctor-img">
            <div class="doctor-name">Dr. David Brown</div>
            <div class="doctor-qualification">MD Dermatology</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(5)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="femaledoc.jpg" alt="Dr. Sarah Johnson" class="doctor-img">
            <div class="doctor-name">Dr. Sarah Johnson</div>
            <div class="doctor-qualification">MD Gynecology</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(6)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. Mark Anderson" class="doctor-img">
            <div class="doctor-name">Dr. Mark Anderson</div>
            <div class="doctor-qualification">MD Pediatrics</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(7)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="femaledoc.jpg" alt="Dr. Jessica White" class="doctor-img">
            <div class="doctor-name">Dr. Jessica White</div>
            <div class="doctor-qualification">DDS Dentistry</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(8)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. Brian Miller" class="doctor-img">
            <div class="doctor-name">Dr. Brian Miller</div>
            <div class="doctor-qualification">MD ENT</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(9)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="femaledoc.jpg" alt="Dr. Samantha Brown" class="doctor-img">
            <div class="doctor-name">Dr. Samantha Brown</div>
            <div class="doctor-qualification">MD Internal Medicine</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(10)">View Profile</button>
            </div>
        </div>

         <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. Emil" class="doctor-img">
            <div class="doctor-name">Dr. Emil</div>
            <div class="doctor-qualification">MD Ophthalmology</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(4)">View Profile</button>
            </div>
        </div>

        <div class="doctor-card">
            <img src="maledoc.jpg" alt="Dr. John Smith" class="doctor-img">
            <div class="doctor-name">Dr. John Smith</div>
            <div class="doctor-qualification">MD Cardiology</div>
            <div class="button-container">
                <button class="profile-button" onclick="redirectToProfile(1)">View Profile</button>
            </div>
        </div>
    </div>

    <script>
        function redirectToProfile(doctorId) {
            window.location.href = `profile.html?id=${doctorId}`;
        }
    </script>
</body>
</html>

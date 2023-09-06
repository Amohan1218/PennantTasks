<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Schedule</title>
    
    <!-- Add Bootstrap CSS (from a CDN) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- Optional: Add Bootstrap JavaScript (from a CDN) if needed -->
    <!-- You can include this if you plan to use Bootstrap's JavaScript features -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
    	button{
    		margin-left: 48%;
    	}
    </style>
</head>
<body>
    <form action="" class="container mt-5">
        <h1 class="text-center">Manage Your Schedule</h1><br>
        <table class="table table-bordered">
            <tr>
                <td>Enter Your ID.:</td>
                <td><input type="text" class="form-control" id="docId" name="docId" value=""></td>
            </tr>
            <tr>
                <td>Select Your Available Days</td>
                <td>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="sun" name="slotTime" value="0">
                        <label class="form-check-label" for="sun">Sunday</label><br>
                        <input type="checkbox" class="form-check-input" id="mon" name="slotTime" value="1">
                        <label class="form-check-label" for="mon">Monday</label><br>
                        <input type="checkbox" class="form-check-input" id="tue" name="slotTime" value="2">
                        <label class="form-check-label" for="tue">Tuesday</label><br>
                        <input type="checkbox" class="form-check-input" id="wed" name="slotTime" value="3">
                        <label class="form-check-label" for="wed">Wednesday</label><br>
                        <input type="checkbox" class="form-check-input" id="thu" name="slotTime" value="4">
                        <label class="form-check-label" for="thu">Thursday</label><br>
                        <input type="checkbox" class="form-check-input" id="fri" name="slotTime" value="5">
                        <label class="form-check-label" for="fri">Friday</label><br>
                        <input type="checkbox" class="form-check-input" id="sat" name="slotTime" value="6">
                        <label class="form-check-label" for="sat">Saturday</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Select Shift</td>
                <td>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="mrng_slot" name="slotShift" value="mrng_slot">
                        <label class="form-check-label" for="mrng_slot">Morning</label>
                    </div>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="evng_slot" name="slotShift" value="evng_slot">
                        <label class="form-check-label" for="evng_slot">Evening</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Slot Duration (in minutes)</td>
                <td>
                    <input type="text" class="form-control" id="slot_dur" name="slotTime" value="">
                </td>
            </tr>
            <tr>
                <td>Range (in days)</td>
                <td>
                    <input type="text" class="form-control" id="slot_range" name="range" value="">
                </td>
            </tr>
        </table><br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</body>
</html>
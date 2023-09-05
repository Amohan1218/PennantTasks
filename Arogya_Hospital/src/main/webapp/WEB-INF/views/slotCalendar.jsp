<%@page import="com.model.SlotAvl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.js"></script>
    <title>Slot Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align:center;
            background-color : #61677A;
        }
        #calendar{
        	width : 42%;
            margin-left: 28%;
        }
        #proceed{
        	padding:8px;
        	font-size:16px;
        	border-radius: 10px;
        }
    	h1{
    		color : #D8D9DA;
    		font-size : 40px;
    		text-align : center;
    	}
    	#ASlot{
            width: 40%;
            font-size: 16px;
            padding: 2px;
        }
    </style>
</head>
<body>
	<h1>Book your slot</h1>
	
    <div id="calendar"></div><br>
	<div id="message"></div><br>
    <button id="proceed">Proceed</button>
    
    <script>
    	var date;
        $(document).ready(function () {
            // Calculate the date range: 30 days from tomorrow
            var tomorrow = moment().add(1, 'days').format('YYYY-MM-DD');
            var thirtyDaysLater = moment(tomorrow).add(${docRange}, 'days').format('YYYY-MM-DD');
            var availableDates = [];
            
            $('#calendar').fullCalendar({
                defaultView: 'month',
                selectable: true,
                selectHelper: true,
                select: function (start, end) {
                    // Handle date selection here
                    // You can fetch available slots from the database and display them on the right side
                    console.log('Selected date range:', start.format('YYYY-MM-DD'), 'to', end.format('YYYY-MM-DD'));
                    // Add your logic to fetch and display available slots
                    date = start.format('YYYY-MM-DD');
                    const isAvailable = availableDates.includes(start.format('YYYY-MM-DD'));
                    if(isAvailable){
                    	getSlots(start.format('YYYY-MM-DD'));
                    }else{
                    	notAvlMessage();
                    }
                },
                dayRender: function (date, cell) {
                    // Customize date cells based on availability
                    var dateString = date.format('YYYY-MM-DD');
                    
                    <c:forEach items="${AvlDates}" var="item">
                    	availableDates.push("${item.date}");
                    </c:forEach>
                    
                    if (date.isBetween(tomorrow, thirtyDaysLater, null, '[]')) {
                        if ($.inArray(dateString, availableDates) !== -1) {
                            cell.css('background-color', '#A4FF78'); // Date is available
                        } else {
                            cell.css('background-color', '#FF9078'); // Date is booked
                        }
                    } else {
                        cell.addClass('fc-disabled-day'); // Disable dates outside the 30-day span
                    }
                },
            });
        });
        var availableSlots = [];
        
		function getSlots(dt){
			
			var xhr = new XMLHttpRequest();
			var url = "/Arogya_Hospital/getAvlSlots?docId=" + ${DocId} + "&date=" + date;
			xhr.onload = function(){
				if(xhr.status === 200){
					//console.log(xhr.responseText);
					var data = JSON.parse(xhr.responseText);
					console.log(data);
					data.forEach(item => {
						
					});
				}
			}
			
			xhr.open("GET", url, true);
			xhr.send();
			
			/* var message = document.getElementById("message");

	        var select = document.createElement("select");
	        select.setAttribute("id", "ASlot");
	        select.setAttribute("name", "ASlot");

	        var option = document.createElement("option");
	        option.setAttribute("value", "Select");
	        option.innerText = "--Select Slot--";

	        select.appendChild(option);
	        message.appendChild(select); */
		}
		function notAvlMessage(){
			var message = document.getElementById("message");
			while (message.firstChild) {
			    message.removeChild(parent.firstChild);
			}
		}
    </script>
</body>
</html>
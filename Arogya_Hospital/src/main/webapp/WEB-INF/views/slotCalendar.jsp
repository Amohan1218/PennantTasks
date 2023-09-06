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
            margin-left: 29%;
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
    	#ASlott{
            width: 42%;
            font-size: 16px;
            padding: 2px;
        }
    </style>
</head>
<body>
	<h1>Book your slot</h1>
	
    <div id="calendar"></div><br>
	
    <form action="bookSlot">
    	<input type="hidden" name="docId" id="docId" value= "">
    	<input type="hidden" name="date" id="date" value="">
    	<div id="message"></div><br>
    	<button type="submit" id="proceed">Proceed</button>
    </form>
    
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
                    console.log('Selected date range:', start.format('YYYY-MM-DD'));
                 	
                    // passing docId to query parameter
                    date = start.format('YYYY-MM-DD');
                    document.getElementById("date").value = "" + date;
                    const isAvailable = availableDates.includes(start.format('YYYY-MM-DD'));
                    if(isAvailable){
                    	getSlots();
                    }else{
                    	notAvlMessage();
                    }
                },
                dayRender: function (date, cell) {
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
        
		function getSlots(){
			
			var xhr = new XMLHttpRequest();
			var url = "/Arogya_Hospital/getAvlSlots?docId=" + ${DocId} + "&date=" + date;
			xhr.onload = function(){
				if(xhr.status === 200){
					//console.log(xhr.responseText);
					var data = JSON.parse(xhr.responseText);
					console.log(data);
					
					var message = document.getElementById("message");
				    while (message.firstChild) {
				        message.removeChild(message.firstChild);
				    }
					
				    var selectVar = document.createElement("select");
				    selectVar.setAttribute("id", "ASlott");
				    selectVar.setAttribute("name", "slotId");
				    
				    var option = document.createElement("option");
			        option.setAttribute("value", "Select");
			        option.innerText = "--Select Slot--";
			        selectVar.appendChild(option);
			        
			        data.forEach(item => {
						var option = document.createElement("option");
				        option.setAttribute("value", item.slot_id);
				        option.innerText = "Book Slot From: " + item.slot_from + " to: " + item.slot_to + "";
				        selectVar.appendChild(option);
					});
			        message.appendChild(selectVar);
				}
			}
			
			xhr.open("GET", url, true);
			xhr.send();
		}
		function notAvlMessage() {
		    var message = document.getElementById("message");
		    while (message.firstChild) {
		        message.removeChild(message.firstChild);
		    }
		    
		    var h3 = document.createElement("H3");
		    h3.innerText = "No Slots Available on Selected Date";
		    
		    message.appendChild(h3);
		}
		// passing docId to query parameter
		document.getElementById("docId").value = "" + ${DocId};
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="blls.*, dals.*, models.*, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Confirmation Page</title>
<style>
body{
	font-size: 15px;
}
</style>
</head>

<%
Ticket T = (Ticket) request.getAttribute("data");
Train Tr = T.getT();
ArrayList<Passenger> P = T.getP();
%>

<body>
	<center>
		<h2>Congratulations..!!</h2>
		<h3>Ticket Booked Succesfully</h3>
		<table border="2" width="65%">
			<tr>
				<td><b>Ticket Details:</b></td>
			</tr>
			<tr>
				<td>PNR No:</td>
				<td><b><%=T.getPNR()%></b></td>
			</tr>
			<tr>
				<td>Train No.</td>
				<td>12345</td>
				<td>Train Name</td>
				<td><%=Tr.getTrainname()%></td>
			</tr>
			<tr>
				<td>Departure From</td>
				<td><%=Tr.getFrom()%></td>
				<td>To</td>
				<td><%=Tr.getTo()%></td>
			</tr>
			<tr>
				<td>Ticket Fare:</td>
				<td><%=T.getFare()%></td>
				<td>Journey Date:</td>
				<td><%=Tr.getDateOfDeparture()%></td>
			</tr>
		</table>
		<br> <br>
		<table border="2" width="65%">
			<tr>
				<td><b>Passenger Details:</b></td>
			</tr>
			<tr>
				<td><b>Passenger Name</b></td>
				<td><b>Age</b></td>
				<td><b>Gender</b></td>
				<td><b>Current Status</b></td>
				<td><b>Berth No.</b></td>
			</tr>

			<%
			for (Passenger p : P) {
			%>
			<tr>
				<td><%= p.getName() %></td>
				<td><%= p.getAge() %></td>
				<td><%= p.getGender() %></td>
				<td>CNF</td>
				<td>NA</td>
			</tr>

			<%
			}
			%>
		</table>
	</center>
</body>
</html>











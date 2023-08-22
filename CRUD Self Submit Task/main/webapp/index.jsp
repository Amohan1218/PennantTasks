<%@page import="java.awt.Window"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ page
	import="folder.*, java.util.*, java.sql.*, jakarta.servlet.*, jakarta.servlet.http.*, java.awt.*"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CRUD Self Submit</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<form action="index.jsp">
		<h1>Employee Master Entry</h1>
		<br>
		<table border="0" width="100%" height="100%">
			<tr>
				<td>Employee ID</td>
				<td><input type="text" class="inpt" id="empid" name="empid"
					value=""></td>
				<td>Mode</td>
				<td><select name="mode" id="mode">
						<option value="select">--Select--</option>
						<option value="read">Read</option>
						<option value="edit">Edit</option>
						<option value="new">New</option>
				</select></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" class="inpt" id="name" name="name"
					value=""></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" class="inpt" id="designation"
					name="designation" value=""></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" class="inpt" id="salary" name="salary"
					value=""></td>
				<td>Department</td>
				<td><input type="text" class="inpt" id="department"
					name="department" value=""></td>
			</tr>
		</table>
		<br> <br>
		<table border="0" height="100%">
			<tr>
				<td><button type="submit" id="first" name="bname" value="first">First</button></td>
				<td><button type="submit" id="next" name="bname" value="next">Next</button></td>
				<td><button type="submit" id="prev" name="bname" value="prev">Prev</button></td>
				<td><button type="submit" id="last" name="bname" value="last">Last</button></td>
			</tr>
			<tr>
				<td><button type="submit" id="add" name="bname" value="add">Add</button></td>
				<td><button type="submit" id="edit" name="bname" value="edit">Edit</button></td>
				<td><button type="submit" id="delete" name="bname"
						value="delete">Delete</button></td>
				<td><button type="submit" id="save" name="bname" value="save">Save</button></td>
			</tr>
			<tr>
				<td><button type="submit" id="search" name="bname"
						value="search">Search</button></td>
				<td><button type="submit" id="clear" name="bname" value="clear">Clear</button></td>
				<td><button type="submit" id="exit" name="bname" value="exit">Exit</button></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	<%
	String s = request.getParameter("bname");
	
	HttpSession sessionVar = request.getSession();
	
	// Initialize or retrieve session variable 'index'
	int index = 0;
	
	if (sessionVar.getAttribute("index") != null) {
	    index = (int) sessionVar.getAttribute("index");
	} else {
	    sessionVar.setAttribute("index", index);
	}
	
	
	// Initialize or retrieve session variable 'data'
	ArrayList<Employee> E = new ArrayList<>();
	
	if(sessionVar.getAttribute("data") != null){
		E = (ArrayList<Employee>) sessionVar.getAttribute("data");
	}else{
		sessionVar.setAttribute("data", EmpDAL.getData());
	}
	
	// Default Values
	String empID = Integer.toString(E.get(index).getEmpid());
	String ename = E.get(index).getEname();
	String designation = E.get(index).getJob();
	String sal = Double.toString(E.get(index).getSalary());
	String department = E.get(index).getDepartment();

	if (s != null && s.equals("first")) {
	    index = 0;
	    sessionVar.setAttribute("index", index);

	    empID = Integer.toString(E.get(index).getEmpid());
	    ename = E.get(index).getEname();
	    designation = E.get(index).getJob();
	    sal = Double.toString(E.get(index).getSalary());
	    department = E.get(index).getDepartment();
	}
	
	if (s != null && s.equals("next")) {
		index += 1;
		sessionVar.setAttribute("index", index);
		
		if(index < E.size()){
			empID = Integer.toString(E.get(index).getEmpid());
			ename = E.get(index).getEname();
			designation = E.get(index).getJob();
			sal = Double.toString(E.get(index).getSalary());
			department = E.get(index).getDepartment();
		}else{
			index -= 1;
			sessionVar.setAttribute("index", index);
		}
	}

	if (s != null && s.equals("prev")) {
		index -= 1;
		sessionVar.setAttribute("index", index);

		if(index >= 0){
			empID = Integer.toString(E.get(index).getEmpid());
			ename = E.get(index).getEname();
			designation = E.get(index).getJob();
			sal = Double.toString(E.get(index).getSalary());
			department = E.get(index).getDepartment();
		}else{
			index += 1;
			sessionVar.setAttribute("index", index);
		}
	}
	if (s != null && s.equals("last")) {
		index = E.size() - 1;
		sessionVar.setAttribute("index", index);

		empID = Integer.toString(E.get(index).getEmpid());
		ename = E.get(index).getEname();
		designation = E.get(index).getJob();
		sal = Double.toString(E.get(index).getSalary());
		department = E.get(index).getDepartment();
	}
	
	if (s != null && s.equals("add")) {
		ename = ""; designation = ""; department = ""; sal = ""; empID = "";
	}
	

	if (s != null && s.equals("edit")) {
		sessionVar.setAttribute("index", index);
	}
	

	if (s != null && s.equals("delete")) {
		empID = request.getParameter("empid");
		EmpDAL.deleteData(empID);
		
		//Updating Resultset
		sessionVar.setAttribute("data", EmpDAL.getData());
	}
	

	if (s != null && s.equals("save")) {
		
		empID = request.getParameter("empid");
		ename = request.getParameter("name");
		designation = request.getParameter("designation");
		sal = request.getParameter("salary");
		department = request.getParameter("department");
		
		int flag = 0;
		for(Employee e : E){
			if(e.getEmpid() == Integer.parseInt(empID)){
				flag += 1;
			}
		}
		if(flag == 0){
			// inserting Elements
			EmpDAL.insertData(empID, ename, designation, sal, department);
		}else{
			// updating Elements
			EmpDAL.updateData(empID, ename, designation, sal, department);
		}
		
		//Updating Resultset
		sessionVar.setAttribute("data", EmpDAL.getData());
	}

	if (s != null && s.equals("search")) {
		empID = request.getParameter("empid");
		
		for(Employee e : E){
			if(e.getEmpid() == Integer.parseInt(empID)){
				empID = Integer.toString(e.getEmpid());
				ename = e.getEname();
				designation = e.getJob();
				sal = Double.toString(e.getSalary());
				department = e.getDepartment();
			}
		}
	}

	if (s != null && s.equals("clear")) {
		ename = ""; designation = ""; department = ""; sal = ""; empID = "";
	}

	if (s != null && s.equals("exit")) {
		ename = ""; designation = ""; department = ""; sal = ""; empID = "";
	}

	%>
		document.getElementById("empid").value = "<%=empID%>";
	    document.getElementById("name").value = "<%=ename%>";
	    document.getElementById("designation").value = "<%=designation%>";
	    document.getElementById("salary").value = "<%=sal%>";
	    document.getElementById("department").value = "<%=department%>";
	</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ page
	import="folder.*, java.util.*, java.sql.*, jakarta.servlet.*, jakarta.servlet.http.*"%>

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
	
	HttpSession sessionVar = request.getSession();
	int i = -1;
	sessionVar.setAttribute("index", i);

	String s = request.getParameter("bname");

	ResultSet rs = null;

	try {
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "1128");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		rs = stmt.executeQuery("SELECT * FROM ms_emp_list");

		PreparedStatement insert = null, delete = null;

	} catch (Exception ae) {
		ae.printStackTrace();
	}

	ArrayList<Employee> E = new ArrayList<>();

	while (rs.next()) {
		E.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
	}

	String ename = "", designation = "", department = "", sal = "", empID = "";

	if (s != null && s.equals("first")) {

		int index = (int) sessionVar.getAttribute("index");
		index = 0;
		sessionVar.setAttribute("index", index);

		empID = Integer.toString(E.get(index).getEmpid());
		ename = E.get(index).getEname();
		designation = E.get(index).getJob();
		sal = Double.toString(E.get(index).getSalary());
		department = E.get(index).getDepartment();
	}
	if (s != null && s.equals("next")) {

		int index = (int) sessionVar.getAttribute("index");
		index += 1;
		sessionVar.setAttribute("index", index);
		
		if(index < E.size()){
			empID = Integer.toString(E.get(index).getEmpid());
			ename = E.get(index).getEname();
			designation = E.get(index).getJob();
			sal = Double.toString(E.get(index).getSalary());
			department = E.get(index).getDepartment();
		}else{
			int index1 = (int) sessionVar.getAttribute("index");
			index1 -= 1;
			sessionVar.setAttribute("index", index1);
		}
	}

	if (s != null && s.equals("prev")) {

		int index = (int) sessionVar.getAttribute("index");
		index -= 1;
		sessionVar.setAttribute("index", index);

		if(index >= 0){
			empID = Integer.toString(E.get(index).getEmpid());
			ename = E.get(index).getEname();
			designation = E.get(index).getJob();
			sal = Double.toString(E.get(index).getSalary());
			department = E.get(index).getDepartment();
		}else{
			int index1 = (int) sessionVar.getAttribute("index");
			index1 += 1;
			sessionVar.setAttribute("index", index1);
		}
	}
	if (s != null && s.equals("last")) {

		int index = (int) sessionVar.getAttribute("index");
		index = E.size() - 1;
		sessionVar.setAttribute("index", index);

		empID = Integer.toString(E.get(index).getEmpid());
		ename = E.get(index).getEname();
		designation = E.get(index).getJob();
		sal = Double.toString(E.get(index).getSalary());
		department = E.get(index).getDepartment();
	}
	
	if (s != null && s.equals("add")) {
		
	}
	

	if (s != null && s.equals("edit")) {
		
	}
	

	if (s != null && s.equals("delete")) {
		
	}
	

	if (s != null && s.equals("save")) {
		
	}
	

	if (s != null && s.equals("search")) {
		
	}
	

	if (s != null && s.equals("clear")) {
		ename = ""; designation = ""; department = ""; sal = ""; empID = "";
	}
	

	if (s != null && s.equals("exit")) {
		
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
package CRUD_EME_Package.folder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmpDAL {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement insert = null, delete = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
			stmt = con.createStatement();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}

	public static ArrayList<Employee> getData() throws SQLException {
		ArrayList<Employee> E = new ArrayList<>();
		rs = stmt.executeQuery("SELECT * FROM ms_emp_list");

		while (rs.next()) {
			E.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
		}
		return E;
	}

	public static JSONArray getJsonData() throws SQLException {

		ArrayList<Employee> AE = EmpDAL.getData();
		JSONArray jarray = new JSONArray(); // JSON Array

		for (Employee e : AE) {
			JSONObject jobj = new JSONObject(); // JSON Object
			jobj.put("empid", e.getEmpid());
			jobj.put("ename", e.getEname());
			jobj.put("job", e.getJob());
			jobj.put("salary", e.getSalary());
			jobj.put("dept", e.getDepartment());

			jarray.put(jobj);
		}

		return jarray;
	}

	public static String insertData(String a, String b, String c, String d, String e) {
		int n = 0, v1 = Integer.parseInt(a);
		String v2 = b, v3 = c, v5 = e;
		double v4 = Double.parseDouble(d);

		try {
			insert = con.prepareStatement("insert into ms_emp_list values(?, ?, ?, ?, ?)");
			insert.setInt(1, v1);
			insert.setString(2, v2);
			insert.setString(3, v3);
			insert.setDouble(4, v4);
			insert.setString(5, v5);
			n = insert.executeUpdate();
			if (n == 1)
				return n + " Row Inserted..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Row insertion Failed..!! EmpId Already Exist..";
		}
		return "Row insertion Failed..!!";
	}

	public static String deleteData(String a) {
		int n = 0, v = Integer.parseInt(a);
		try {
			delete = con.prepareStatement("delete from ms_emp_list where empid = ?");
			delete.setInt(1, v);
			n = delete.executeUpdate();
			if (n == 1)
				return n + " Row Deleted..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Row deletion Failed..!! may Item not found";
		}
		return "Row deletion Failed..!!";
	}

	public static String updateData(String a, String b, String c, String d, String e) {
		int n = 0, v1 = Integer.parseInt(a);
		String v2 = b, v3 = c, v5 = e;
		double v4 = Double.parseDouble(d);

		try {
			insert = con.prepareStatement("UPDATE ms_emp_list set name = ?, designation = ?, sal = ?, department = ? WHERE empid = ?");
			insert.setString(1, v2);
			insert.setString(2, v3);
			insert.setDouble(3, v4);
			insert.setString(4, v5);
			insert.setInt(5, v1);
			n = insert.executeUpdate();
			if (n == 1)
				return n + " Row Updated..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Row updation Failed..!!";
		}
		return "Row updation Failed..!!";
	}
//	public static void main(String[] args) throws SQLException {
//		System.out.println(getJsonData());
//	}
}

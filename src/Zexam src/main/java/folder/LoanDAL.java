package folder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoanDAL {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement insert = null, delete = null;
	
	// Creating a database connection
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			stmt = con.createStatement();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}
	
	// This function convert the database data into objects
	public static ArrayList<Loan> getData() throws SQLException {
		ArrayList<Loan> E = new ArrayList<>();
		rs = stmt.executeQuery("SELECT * FROM ms_loan");

		while (rs.next()) {
			java.sql.Date v4 = rs.getDate(4);
			java.sql.Date v5 = rs.getDate(5);
			java.sql.Date v6 = rs.getDate(6);
			E.add(new Loan(rs.getInt(1), rs.getInt(2), rs.getInt(3), v4.toLocalDate(),
					v5.toLocalDate(), v6.toLocalDate(), rs.getInt(7)));
		}
		return E;
	}

	public static JSONArray getJsonData() throws SQLException {

		ArrayList<Loan> AE = LoanDAL.getData();
		JSONArray jarray = new JSONArray(); // JSON Array

		for (Loan e : AE) {
			JSONObject jobj = new JSONObject(); // JSON Object
			jobj.put("loanId", e.getLoanId());
			jobj.put("bookId", e.getBookId());
			jobj.put("borrowerId", e.getBorrowerId());
			jobj.put("checkoutDate", e.getCheckoutDate());
			jobj.put("dueDate", e.getDueDate());
			jobj.put("returnDate", e.getReturnDate());
			jobj.put("fine", e.getFine());

			jarray.put(jobj);
		}

		return jarray;
	}

	// insert new record
	public static String insertData(String a, String b, String c, String d, String e, String f, String g) {
		int n = 0, v1 = Integer.parseInt(a), v2 = Integer.parseInt(b), v3 = Integer.parseInt(c),
				v7 = Integer.parseInt(g);
		LocalDate v4 = LocalDate.parse(d, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate v5 = LocalDate.parse(e, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate v6 = LocalDate.parse(f, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		try {
			insert = con.prepareStatement("insert into ms_loan values(?, ?, ?, ?, ?, ?, ?)");
			insert.setInt(1, v1);
			insert.setInt(2, v2);
			insert.setInt(3, v3);
			insert.setObject(4, v4);
			insert.setObject(5, v5);
			insert.setObject(6, v6);
			insert.setInt(7, v7);

			n = insert.executeUpdate();
			if (n == 1)
				return n + " Row Inserted..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Row insertion Failed..!! LoanId Already Exist..";
		}
		return "Row insertion Failed..!!";
	}

	// Delete record
	public static String deleteData(String a) {
		int n = 0, v = Integer.parseInt(a);
		try {
			delete = con.prepareStatement("delete from ms_loan where loanid = ?");
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

	// Update Record
	public static String updateData(String a, String b, String c, String d, String e, String f, String g) {
		int n = 0, v1 = Integer.parseInt(a), v2 = Integer.parseInt(b), v3 = Integer.parseInt(c),
				v7 = Integer.parseInt(g);
		LocalDate v4 = LocalDate.parse(d, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate v5 = LocalDate.parse(e, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate v6 = LocalDate.parse(f, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		try {
			insert = con.prepareStatement(
					"UPDATE ms_loan set bookid = ?, borrowerid = ?, checkoutdate = ?, duedate = ?, returndate = ?, fine = ? WHERE loanid = ?");
			insert.setInt(1, v1);
			insert.setInt(2, v2);
			insert.setInt(3, v3);
			insert.setObject(4, v4);
			insert.setObject(5, v5);
			insert.setObject(6, v6);
			insert.setInt(7, v7);
			
			n = insert.executeUpdate();
			if (n == 1)
				return n + " Row Updated..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Row updation Failed..!!";
		}
		return "Row updation Failed..!!";
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(getJsonData());
	}
}

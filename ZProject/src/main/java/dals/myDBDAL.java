package dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class myDBDAL {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement insert = null, delete = null, update = null;

	public static void callResultSet() {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = stmt.executeQuery("SELECT * FROM ms_mydb");

		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}
	public static String insertData(String a, String b) {
		int n = 0;
		String v1 = a, v2 = b;

		try {
			insert = con.prepareStatement("insert into ms_mydb values(?, ?)");
			insert.setString(1, v1);
			insert.setString(2, v2);
			n = insert.executeUpdate();
			if (n == 1)
				return n + " Row Inserted..!";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Username Already Exist..";
		}
		return "Account Creation Failed..!!";
	}
}

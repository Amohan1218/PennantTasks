package dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAL {
	
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
	public static String CheckCredentials() {
		
		return "";
	}
}

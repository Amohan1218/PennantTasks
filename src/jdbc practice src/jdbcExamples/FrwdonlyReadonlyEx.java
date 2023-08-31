package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FrwdonlyReadonlyEx {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
			Connection con = DriverManager.getConnection(url, "plf_training_admin", "pff123");

			// con.setAutoCommit(false);

			Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			ResultSet rst = stmt.executeQuery("Select * from ms_dept");

			while (rst.next()) {
				System.out.println(":: " + rst.getInt(1) + " :: " + rst.getString(2) + " :: " + rst.getString(3));
			}

			// con.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
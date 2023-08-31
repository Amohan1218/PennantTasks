package jdbcExamples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStmtEx {
	public static void main(String[] args) {
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");

			CallableStatement cstmt = con.prepareCall("CALL newdept(?, ?, ?)");
			cstmt.setInt(1, 506);
			cstmt.setString(2, "Dept506");
			cstmt.setString(3, "Loc506");
			cstmt.execute();

			cstmt.close();
			con.close();
			System.out.println("New row added!!");
		} catch (ClassNotFoundException cex) {
			System.out.println(cex.getMessage());
		} catch (SQLException sqex) {
			System.out.println(sqex.getMessage());
		}
	}
}

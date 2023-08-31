package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStmtEx {
	public static void main(String[] args) {
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");

			// CallableStatement cstmt = con.prepareCall("CALL newdept(?, ?, ?)");
			// cstmt.setInt(1, 506);
			// cstmt.setString(2, "Dept506");
			// cstmt.setString(3, "Loc506");
			// cstmt.execute();

			PreparedStatement p = con.prepareStatement("insert into ms_dept values(?,?,?)");
			p.setInt(1, 420);
			p.setString(2, "mohan");
			p.setString(3, "heart");
			int nr = p.executeUpdate();

			p.close();
			con.close();
			System.out.println(nr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

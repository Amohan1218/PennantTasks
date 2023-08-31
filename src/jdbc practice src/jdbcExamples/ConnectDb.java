package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDb {
	public static void main(String[] args) {
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");

			Statement stmt = con.createStatement();

			// String str = "INSERT INTO ms_dept VALUES(100, 'Dept100', 'Loc100'), (101, 'Dept101', 'Loc101')";
			String str = "Delete from ms_dept where deptno = 101"; // Action

			int n = stmt.executeUpdate(str);
			System.out.println("No. of rows effected: " + n);

			String nas = "Select * from ms_dept"; // Non Action
			ResultSet rs = stmt.executeQuery(nas);

			System.out.println(con + " ::::: " + rs);
			while (rs.next()) {
				int id = rs.getInt(1);
				String deptn = rs.getString("deptname");
				System.out.println("::" + id + ", " + deptn);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package jdbcExamples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataExample {
	public static void main(String[] args) {
		try {

			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
			Connection con = DriverManager.getConnection(url, "plf_training_admin", "pff123");

			DatabaseMetaData dmt = con.getMetaData();
			System.out.println(":" + dmt.getDatabaseProductName());
			System.out.println(":" + dmt.getDatabaseProductVersion());
			System.out.println(":" + dmt.getDriverName());
			System.out.println(":" + dmt.getDriverVersion());

			System.out.println("\n\n\n");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ms_emp");
			ResultSetMetaData rmt = rs.getMetaData();

			System.out.println(":" + rmt.getColumnCount());
			System.out.println(":" + rmt.getColumnType(5));
			System.out.println(":" + rmt.getColumnTypeName(5));
			System.out.println(":" + rmt.getColumnLabel(6));
			System.out.println(":" + rmt.getColumnName(6));

			// while (rs.next()) {
			// int id = rs.getInt(1);
			// System.out.println("::" + id);
			// }

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

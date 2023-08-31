package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollabaleUpdatableEx {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
			Connection con = DriverManager.getConnection(url, "plf_training_admin", "pff123");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rst = stmt.executeQuery("Select * from ms_dept");

			rst.next();

			// delete record
			rst.absolute(8);
			rst.deleteRow();
			System.out.println("Record has been deleted..!");

			// update row
			rst.absolute(7);
			rst.updateString("DLoc", "infinity");
			rst.updateRow();
			System.out.println("Record has been updated..!");

			// Insert row
			rst.moveToInsertRow();
			rst.updateInt("deptno", 150);
			rst.updateString("deptname", "Dept150");
			rst.updateString("DLoc", "Loc150");
			rst.insertRow();
			System.out.println("New record has been inserted..!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

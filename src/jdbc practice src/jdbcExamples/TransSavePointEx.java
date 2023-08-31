package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransSavePointEx {
	public static void main(String args[]) {
		Connection conn = null;
		Statement st = null;
		Savepoint sp;
		String cs;

		try {

			// register the driver
			Class.forName("org.postgresql.Driver");

			// connect to the database
			cs = "jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123";
			conn = DriverManager.getConnection(cs);

			// switch off auto commit feature
			conn.setAutoCommit(false);

			// create statement
			st = conn.createStatement();
			int nr1 = st.executeUpdate("update ms_emp set sal=sal+1000 where empno=7499");
			System.out.println("No of records updated " + nr1);

			sp = conn.setSavepoint("sp1");

			int nr2 = st.executeUpdate("update ms_emp set sal=sal+2000 where empno=7521");
			System.out.println("No of records updated " + nr2);

			// rollback till savepoint
			conn.rollback(sp);

			System.out.println("Last statement has been rolled_back :" + nr2 + " no of updations are reversed");

			// commit the transaction
			conn.commit();

			ResultSet rs = st.executeQuery("SELECT * FROM ms_emp");
			while (rs.next()) {
				int id = rs.getInt(1);
				int sal = rs.getInt(6);
				System.out.println("--> " + id + " ::: " + sal);
			}

			// close the connection
			rs.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
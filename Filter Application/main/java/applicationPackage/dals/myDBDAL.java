package applicationPackage.dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class myDBDAL {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement insert = null, select = null;

	public static void callConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}
	public static String insertData(String a, String b) {
		callConnection();
		
		int n = 0;
		String v1 = a, v2 = b;

		try {
			insert = con.prepareStatement("insert into ms_mydb values(?, ?)");
			insert.setString(1, v1);
			insert.setString(2, v2);
			n = insert.executeUpdate();
			if (n == 1)
				return "Your Account Succesfully Created";
		} catch (SQLException ae) {
			ae.printStackTrace();
			return "Username Already Exist..";
		}
		return "Account Creation Failed..!!";
	}
	
	public static JSONObject authenticateUser(String uname, String pwd) throws SQLException{
		callConnection();
		
		select = con.prepareStatement("SELECT * FROM ms_mydb WHERE username = ?");
		select.setString(1, uname);
		
		rs = select.executeQuery();

		String DBPwd = null;
		
		while(rs.next()) {
			DBPwd = rs.getString(2);
		}
		
		if(pwd.equals(DBPwd)) {
			JSONObject J = new JSONObject();
			J.put("message", "Successfully LoggedIn..!!");
			J.put("key", generateKey()+uname);
			return J;
		}else {
			JSONObject J = new JSONObject();
			J.put("message", "Wrong Password or Username..!!");
			J.put("key", " ");
			return J;
		}
	}
	
	private static String generateKey() {
		String authKey = "";
		
			Random r = new Random();
			for(int i = 1; i <= 6; i++) {
				int num = r.nextInt(9);
				authKey += num;
			}
		return authKey;
	}
	public static void main(String[] args) throws SQLException {
		callConnection();
		System.out.println(insertData("Amohan203611", "AmohaN.13"));
		System.out.println(authenticateUser("Amohan203611", "AmohaN.13"));
	}
}

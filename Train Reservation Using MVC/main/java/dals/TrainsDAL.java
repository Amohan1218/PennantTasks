package dals;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Trains;

public class TrainsDAL {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
			stmt = con.createStatement();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}

	public static ArrayList<Trains> getData() throws SQLException {
		ArrayList<Trains> S = new ArrayList<>();
		rs = stmt.executeQuery("SELECT * FROM ms_trainlist");

		while (rs.next()) {
			S.add(new Trains(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		return S;
	}

	public static JSONArray getJsonData() throws SQLException {

		ArrayList<Trains> AE = TrainsDAL.getData();
		JSONArray jarray = new JSONArray(); // JSON Array

		for (Trains s : AE) {
			JSONObject jobj = new JSONObject(); // JSON Object
			jobj.put("from_stn", s.getFrom_station());
			jobj.put("to_stn", s.getTo_station());
			jobj.put("trainName", s.getTrain_name());

			jarray.put(jobj);
		}

		return jarray;
	}

//	public static void main(String[] args) throws SQLException {
//		System.out.println(getJsonData());
//	}
}

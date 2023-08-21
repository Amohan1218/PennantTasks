package dals;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Stations;

public class StationsDAL {
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

	public static ArrayList<Stations> getData() throws SQLException {
		ArrayList<Stations> S = new ArrayList<>();
		rs = stmt.executeQuery("SELECT * FROM ms_stations");

		while (rs.next()) {
			S.add(new Stations(rs.getString(1), rs.getString(2)));
		}
		return S;
	}

	public static JSONArray getJsonData() throws SQLException {

		ArrayList<Stations> AE = StationsDAL.getData();
		JSONArray jarray = new JSONArray(); // JSON Array

		for (Stations s : AE) {
			JSONObject jobj = new JSONObject(); // JSON Object
			jobj.put("stn_code", s.getStn_code());
			jobj.put("stn_name", s.getStn_name());

			jarray.put(jobj);
		}

		return jarray;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getJsonData());
	}

}
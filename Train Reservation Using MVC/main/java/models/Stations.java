package models;

public class Stations {
	String stn_code, stn_name;

	public Stations(String stn_code, String stn_name) {
		super();
		this.stn_code = stn_code;
		this.stn_name = stn_name;
	}

	public String getStn_code() {
		return stn_code;
	}

	public void setStn_code(String stn_code) {
		this.stn_code = stn_code;
	}

	public String getStn_name() {
		return stn_name;
	}

	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
	}
}

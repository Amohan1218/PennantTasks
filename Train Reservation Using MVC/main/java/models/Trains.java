package models;

public class Trains {
	String from_station, to_station, train_name;

	public Trains(String from_station, String to_station, String train_name) {
		super();
		this.from_station = from_station;
		this.to_station = to_station;
		this.train_name = train_name;
	}

	public String getFrom_station() {
		return from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}

	public String getTo_station() {
		return to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
}

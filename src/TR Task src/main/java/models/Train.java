package models;


public class Train {
	String from, to, trainname, dateOfDeparture, tclass;

	public Train(String from, String to, String trainname, String dateOfDeparture, String tclass) {
		super();
		this.from = from;
		this.to = to;
		this.trainname = trainname;
		this.dateOfDeparture = dateOfDeparture;
		this.tclass = tclass;
	}
	
	public String toString() {
		return from + " -- " + to + " -- " + trainname + " -- " + dateOfDeparture + " -- " + tclass;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(String dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String getTclass() {
		return tclass;
	}

	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
}
package models;

import java.util.ArrayList;

public class Ticket {
	Train Tr; ArrayList<Passenger> P;
	double fare;
	String PNR;

	public Ticket(Train t, ArrayList<Passenger> p) {
		super();
		Tr = t;
		P = p;
	}
	
	public String toString() {
		return Tr + " \n " + P + " \n " + fare + " \n " + PNR;
	}

	public Train getT() {
		return Tr;
	}

	public void setT(Train t) {
		Tr = t;
	}

	public ArrayList<Passenger> getP() {
		return P;
	}

	public void setP(ArrayList<Passenger> p) {
		P = p;
	}	
	
	public String getPNR() {
		return PNR;
	}

	public void setPNR(String pNR) {
		PNR = pNR;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
}

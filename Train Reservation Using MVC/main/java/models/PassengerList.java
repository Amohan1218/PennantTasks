package models;

import java.util.ArrayList;

public class PassengerList{
	static ArrayList<Passenger> P = new ArrayList<>();
	
	public static ArrayList<Passenger> getData(){
		return P;
	}
	
	public static  void addPassenger(Passenger q){
		P.add(q);
	}
}

package blls;

import models.Ticket;

public class FareCalBLL {
	static double amount = 123;
	
	public static double calFare(Ticket t) {
		return amount*t.getP().size();
	}
}
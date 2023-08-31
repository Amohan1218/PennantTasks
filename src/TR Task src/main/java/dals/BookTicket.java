package dals;

import java.util.Random;

import blls.FareCalBLL;
import models.Ticket;

public class BookTicket {
	static String PNR = "";
	
	static {
		Random r = new Random();
		for(int i = 1; i <= 10; i++) {
			int num = r.nextInt(9);
			PNR += num;
		}
	}
	
	public static Ticket book(Ticket t) {
		
		double fare = FareCalBLL.calFare(t);
		
		t.setFare(fare);
		t.setPNR(PNR);
		
		return t;
	}
}
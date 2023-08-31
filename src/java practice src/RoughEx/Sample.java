package RoughEx;

import java.util.HashMap;
import java.util.Map;

public class Sample {
	public static void main(String[] args) {
		/*
		 * // // Creating date // Date d1 = new Date(2000, 11, 21); // Date d2 = new Date(); // Current date // Date d3
		 * = new Date(2024, 1, 3); // // Date d4 = new Date(2023, 7, 11); // boolean a = d3.after(d1); //
		 * System.out.println("Date d3 comes after " + "date d2: " + a); // // boolean b = d3.before(d2); //
		 * System.out.println("Date d3 comes before " + "date d2: " + b); // // int c = d3.compareTo(d4); //
		 * System.out.println(c); // // System.out.println("Miliseconds from Jan 1 " + "1970 to date d1 is " +
		 * d1.getTime()); // // System.out.println("Before setting " + d2); // d2.setTime(204587433443L); //
		 * System.out.println("After setting " + d2);
		 */

		// LocalDate ld = LocalDate.now();

		/*
		 * String s1 = "2023-03-28"; String s2 = "2023-08-28";
		 * 
		 * System.out.println(s1.compareTo(s2));
		 */

		Map<String, Integer> m = new HashMap<>();
		m.put("Mohan", 506);
		m.put("Jyothi", 513);

		System.out.println(m.keySet());
		System.out.println(m.values());
		System.out.println(Integer.valueOf(34) + Integer.valueOf("65"));
	}
}

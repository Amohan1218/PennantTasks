package collectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();

		l.add("Mohan");
		l.add("Sai");
		l.add("Chinnu");
		l.add("Jyothi");
		l.add("Chikdum");

		l.remove("Sai");

		for (String s : l) {
			System.out.println("Index of " + s + " is: " + l.indexOf(s));
		}

		Collections.sort(l);
		System.out.println();

		for (String s : l) {
			System.out.println("Index of " + s + " is: " + l.indexOf(s));
		}

		System.out.println("\nSize of ArrayList: " + l.size());
		l.add(3, "Manju");
		System.out.println("Get method: " + l.get(3));

		System.out.println();
		for (String s : l) {
			System.out.println(s);
		}

		// --------------------------------------------------------------------

		List<Integer> j = new LinkedList<>();
		j.add(506);
		j.add(513);
		j.add(235);

		j.set(2, 505);

		for (Integer i : j)
			System.out.println("Index of " + i + " is: " + j.indexOf(i));

		System.out.println(j);

		Iterator<String> i = l.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}

package collectionsAndGenerics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();

		// process of functions in LinkedHashSet, TreeSet is similar to Hashset

		s.add("Mohan");
		s.add("manju");
		s.add("Saii");

		s.add("Saii"); // it doesn't insert into the set

		s.remove("manju");

		Iterator<String> i = s.iterator();

		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("\n" + s.contains("MohanJ"));
	}
}

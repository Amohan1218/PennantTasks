package collectionsAndGenerics;

import java.util.Map;
import java.util.TreeMap;

public class MapExample {
	public static void main(String[] args) {
		// Step 1: Create a TreeMap
		Map<String, Integer> ageMap = new TreeMap<>();

		// Step 2: Add key-value pairs to the TreeMap
		ageMap.put("Alice", 25);
		ageMap.put("Bob", 30);
		ageMap.put("Charlie", 22);

		// Step 3: Get values from the TreeMap using keys
		int bobAge = ageMap.get("Bob");
		System.out.println("Bob's age: " + bobAge); // Output: Bob's age: 30

		// Step 4: Check if a key is present in the TreeMap
		boolean containsDavid = ageMap.containsKey("David");
		System.out.println("Contains David? " + containsDavid); // Output: Contains David? false

		// Step 5: Remove a key-value pair from the TreeMap
		int removedAge = ageMap.remove("Charlie");
		System.out.println("Removed Charlie's age: " + removedAge); // Output: Removed Charlie's age: 22

		// Step 6: Check the size of the TreeMap
		System.out.println("Size of TreeMap: " + ageMap.size()); // Output: Size of TreeMap: 2

		// Step 7: Check if the TreeMap is empty
		boolean isEmpty = ageMap.isEmpty();
		System.out.println("Is TreeMap empty? " + isEmpty); // Output: Is TreeMap empty? false
	}
}
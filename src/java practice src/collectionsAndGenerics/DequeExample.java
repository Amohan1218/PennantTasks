package collectionsAndGenerics;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
	public static void main(String[] args) {
		// Step 1: Create a Deque using ArrayDeque
		Deque<Integer> deque = new ArrayDeque<>();

		// Step 2: Add elements to the Deque
		deque.addFirst(10);
		deque.addLast(20);
		deque.offerFirst(5);
		deque.offerLast(30);

		System.out.println("Deque: " + deque); // Output: Deque: [5, 10, 20, 30]

		// Step 3: Remove and process elements from both ends
		int firstElement = deque.pollFirst();
		System.out.println("Removed first element: " + firstElement); // Output: Removed first element: 5

		int lastElement = deque.pollLast();
		System.out.println("Removed last element: " + lastElement); // Output: Removed last element: 30

		System.out.println("Deque after removal: " + deque); // Output: Deque after removal: [10, 20]

		// Step 4: Inspect elements without removing them
		int frontElement = deque.peekFirst();
		System.out.println("Front element: " + frontElement); // Output: Front element: 10

		int endElement = deque.peekLast();
		System.out.println("End element: " + endElement); // Output: End element: 20

		System.out.println("Deque size: " + deque.size());
	}
}

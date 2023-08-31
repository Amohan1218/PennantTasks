package collectionsAndGenerics;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();

		// It is similar to the Linked List but PriorityQueue is stored the values in a order

		queue.offer("Alice");
		queue.offer("Bob");
		queue.offer("Charlie");

		System.out.println("Queue: " + queue); // Output: Queue: [Alice, Bob, Charlie]

		String firstElement = queue.poll();
		System.out.println("Removed element: " + firstElement); // Output: Removed element: Alice

		System.out.println("Queue after removal: " + queue); // Output: Queue after removal: [Bob, Charlie]

		String frontElement = queue.peek();
		System.out.println("Front element: " + frontElement); // Output: Front element: Bob

		System.out.println("Queue size: " + queue.size()); // Output: Queue size: 2
	}
}

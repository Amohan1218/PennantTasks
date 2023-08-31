package collectionsAndGenerics;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		// Step 1: Create a Stack
		Stack<String> stack = new Stack<>();

		// Step 2: Push elements onto the Stack
		stack.push("Alice");
		stack.push("Bob");
		stack.push("Charlie");

		// Step 3: Check if the Stack is empty
		System.out.println("Is Stack empty? " + stack.empty()); // Output: Is Stack empty? false

		// Step 4: Peek at the top element without removing it
		System.out.println("Top element: " + stack.peek()); // Output: Top element: Charlie

		// Step 5: Pop the top element from the Stack
		String topElement = stack.pop();
		System.out.println("Popped element: " + topElement); // Output: Popped element: Charlie

		// Step 6: Check the Stack after popping
		System.out.println("Stack after popping: " + stack); // Output: Stack after popping: [Alice, Bob]

		// Step 7: Pop remaining elements
		while (!stack.empty()) {
			String element = stack.pop();
			System.out.println("Popped element: " + element);
		}
	}
}

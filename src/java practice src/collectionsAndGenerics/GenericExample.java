package collectionsAndGenerics;

// generic class
class Operation<t1 extends Number, t2 extends Number> {
	t1 a;
	t2 b;

	Operation(t1 a, t2 b) {
		this.a = a;
		this.b = b;
	}

	@SuppressWarnings("unchecked")
	t2 sum() {
		double result = a.doubleValue() + b.doubleValue();

		if (b instanceof Integer) {
			return (t2) Integer.valueOf((int) result);
		} else if (b instanceof Float) {
			return (t2) Float.valueOf((float) result);
		} else {
			throw new UnsupportedOperationException("Unsupported Numeric type..!");
		}
	}

	// Generic method
	public static <T extends Number, T3 extends Number> void display(T var, T3 vad) {
		System.out.println("Value: " + (var.doubleValue() + vad.doubleValue()));
	}
}

public class GenericExample {
	public static void main(String[] args) {
		Operation<Integer, Float> obj = new Operation<>(2, 3.6f);
		System.out.println(obj.sum());

		Operation.display(96, 78);
	}
}

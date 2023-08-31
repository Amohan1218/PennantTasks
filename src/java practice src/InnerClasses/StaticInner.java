package InnerClasses;

class Demom {
	static class Child {
		void magic() {
			System.out.println("Entry of magic method");
			int i = 20;
			class Dimple {
				void sync() {
					System.out.println("sync method: " + i);
				}
			}

			Dimple d = new Dimple();
			d.sync();
		}
	}

}

class Sample1 {
	public static void main(String[] args) {

		Demom.Child c = new Demom.Child();
		c.magic();
	}
}
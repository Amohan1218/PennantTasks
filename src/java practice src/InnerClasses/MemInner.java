package InnerClasses;

class Demo {
	class Child {
		void magic() {
			System.out.println("Entry of magic class");
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

class Sample {
	public static void main(String[] args) {
		Demo d = new Demo();
		Demo.Child c = d.new Child();
		c.magic();
	}
}
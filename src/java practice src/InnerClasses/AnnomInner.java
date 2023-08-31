package InnerClasses;

interface Dimple {
	void second();
}

abstract class Chinnu {
	abstract void donkey();

	void dingu() {
		System.out.println("dingu method");
	}
}

class Work {
	void perssure() {
	}
}

class AnnomInner {
	public static void main(String[] args) {
		Dimple d = new Dimple() {
			public void second() {
				System.out.println("Second method");
			}
		};
		Chinnu c = new Chinnu() {
			void donkey() {
				System.out.println("Donkey method");
			}

			void dingu() {
				System.out.println("dingu method");
			}
		};
		Work w = new Work() {
			void perssure() {
				System.out.println("Perssure method");
			}
		};
		d.second();
		c.donkey();
		c.dingu();
		w.perssure();
	}
}
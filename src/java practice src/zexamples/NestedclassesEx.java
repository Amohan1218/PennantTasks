package zexamples;

class Sample {
	void display() {
		System.out.println("Display method");
	}

	class Sample1 {
		void display1() {
			System.out.println("Display1 Method");
		}
	}

	static class Sample2 {
		void display2() {
			class Localclass {
				void methodw() {
					System.out.println("methodw..");
				}
			}
			Localclass l = new Localclass();
			l.methodw();
			System.out.println("Display2 Method");
		}
	}
}

class NestedclassesEx {
	public static void main(String[] args) {
		Sample s = new Sample() {
			int i = 404;

			void display() {
				System.out.println("Annonymous class ovveride function " + i);
			}
		};
		// calling annoymous class method
		s.display();

		// creating obj for nested inner class
		Sample s1 = new Sample();
		Sample.Sample1 iobj = s1.new Sample1();
		iobj.display1();

		// Creating obj for static inner class
		Sample.Sample2 d = new Sample.Sample2();
		d.display2();
	}
}

package zexamples;

class ThreadEx extends Thread {
	String name;

	ThreadEx(String s) {
		name = s;
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + "...." + i);
		}
	}
}

public class ThreadsEx {
	public static void main(String[] args) {
		ThreadEx t1 = new ThreadEx("T1");
		ThreadEx t2 = new ThreadEx("T2");

		t1.start();
		t2.start();
	}
}

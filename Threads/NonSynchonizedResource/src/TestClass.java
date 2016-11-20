public class TestClass {
	public static int counter = 0;
	static class RunnerDec implements Runnable {
		public void run() {
			for (int i = 0; i < 5000; i++) {
				counter--;
			}
		}
	}
	static class RunnerInc implements Runnable {
		public void run() {
			for (int i = 0; i < 5000; i++) {
				counter++;
			}
		}
	}
	public static void test() {
		RunnerDec dec = new RunnerDec();
		RunnerInc inc = new RunnerInc();
		Thread t1 = new Thread(dec);
		Thread t2 = new Thread(inc);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		System.out.println(counter);
	}
	public static void main(String...args) {
		for (int i = 0; i < 10; i++)
			test();
	}
}

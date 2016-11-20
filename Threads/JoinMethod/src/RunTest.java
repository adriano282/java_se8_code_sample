public class RunTest {
	public static volatile int counter = 0;
	public static Object obj = new Object();
	static class RunnerDec implements Runnable {
		public void run() {
			synchronized(obj) {
				for (int i = 0; i < 5000; i++) {
					counter++;
				}
			}
			
		}
	}

	static class RunnerInc implements Runnable {
		public void run() {
			synchronized(obj) {
				for (int i = 0; i < 5000; i++) {
					counter--;
				}
			}
		}
	}

	public static void main(String...args) {
		RunnerDec dec = new RunnerDec();
		RunnerInc inc = new RunnerInc();
		Thread t1 = new Thread(dec);
		Thread t2 = new Thread(inc);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {e.printStackTrace();}
		System.out.println(counter);
	}
}

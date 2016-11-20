public class TestLock {
	public void print() {
		System.out.println("OK");
	}

	public static void main(String... args) {
		TestLock a1 = new TestLock();
		
		MyRunnable r = new MyRunnable();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		
	}
}
class MyRunnable implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

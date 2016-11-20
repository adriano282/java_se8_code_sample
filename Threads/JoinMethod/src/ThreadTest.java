public class ThreadTest {
	class InnerRun implements Runnable {
		public void run() {
			for (int x = 0; x < 100; x++) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {e.printStackTrace();}
				System.out.println("Ren ");
			}
		}
	}
	class InnerRunTwo implements Runnable {
		Thread other;
		InnerRunTwo(Thread t) {other = t;}
		public void run() {
			try {
				other.join();
			} catch (Exception e) {e.printStackTrace();}
			System.out.println("Stimpy");
		}
	}
	void start() {
		InnerRun ir = new InnerRun();
		Thread t = new Thread(ir);
		InnerRunTwo irr = new InnerRunTwo(t);
		Thread u = new Thread(irr);
		t.start();
		u.start();
	}
	public static void main(String[] args) {
		ThreadTest tt = new ThreadTest();
		tt.start();
	}
}

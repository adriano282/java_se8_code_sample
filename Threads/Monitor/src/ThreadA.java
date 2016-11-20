public class ThreadA {
	public static void main(String... args) {
		ThreadB  b = new ThreadB();
		b.setDaemon(true);
		b.start();
		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total e igual a: " + b.total);
		}
	}
}

class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {

			for (int i = 0; i <= 10_000_000; i++) {
				total += i;
				i++;
				
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			notify();
		}
	}
}



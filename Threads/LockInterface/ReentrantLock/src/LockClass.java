import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class LockClass implements Runnable {
	public Lock l1 = new ReentrantLock();
	public boolean stop = false;

	public void run() {
		A: while(true) {
			try {
				boolean locked = l1.tryLock(10, TimeUnit.SECONDS);

				if (stop) break A;
				if (locked) {
					try {
						System.out.println("Thread " + Thread.currentThread().getName() + ": Lock acquired successfuly");
						if (Thread.currentThread().getName().equals("B")) {
							stop = true;
							break A;
						}
						Thread.sleep(10_000);

						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("Thread " +
							Thread.currentThread().getName() + ": Realease the lock");
						l1.unlock();
						try {
							Thread.sleep(5_000);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					System.out.println("Thread " + Thread.currentThread().getName() + ": Lock already was get. Try Again!!");
				}
			} catch( InterruptedException e) {}
		}
	}
	public static void main(String...args) {

		LockClass lc = new LockClass();

		Thread t1 = new Thread(lc);
		t1.setName("A");
		Thread t2 = new Thread(lc);
		t2.setName("B");

		t1.start();
		t2.start();
	}
}

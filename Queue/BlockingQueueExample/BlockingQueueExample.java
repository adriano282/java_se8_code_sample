import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
	public static void main(String... args) throws InterruptedException{
//		BlockingQueue bq = new ArrayBlockingQueue(1000);
		BlockingQueue bq = new ArrayBlockingQueue(1);
		System.out.println(bq.offer(2));
		System.out.println(bq.offer(3));
		System.out.println(bq.offer(2, 10, TimeUnit.SECONDS));
		
//		Producer producer = new Producer(bq);
//		Consumer consumer = new Consumer(bq);

//		new Thread(producer).start();
//		new Thread(consumer).start();

		//Thread.sleep(4000);
	}
}

class Producer implements Runnable {
	private BlockingQueue bq = null;

	Producer(BlockingQueue queue) {
		this.setBlockingQueue(queue);
	}

	public void run() {
		Random rand = new Random();
		int res = 0;
		try {

			for (int x = 1; x < 10; x++) {
				res = Addition(rand.nextInt(100), rand.nextInt(50));
				System.out.println("Produces: " + res);
				bq.put(res);
				//Thread.sleep(1000);	
			}
		} catch (InterruptedException e) {}
	}

	private int Addition(int v1, int v2) {
		return v1 + v2;
	}

	public void setBlockingQueue(BlockingQueue bq) {
		this.bq = bq;
	}
}

class Consumer implements Runnable {
	private BlockingQueue bq = null;

	Consumer(BlockingQueue queue) {
		this.setBlockingQueue(queue);
	}

	public void run() {
		try {
			for (int x = 1; x < 10; x++) {
				System.out.println("Consumed: " + bq.take());
			}
		} catch (InterruptedException ie) {}
	}

	public void setBlockingQueue(BlockingQueue bq) {
		this.bq = bq;
	}
}

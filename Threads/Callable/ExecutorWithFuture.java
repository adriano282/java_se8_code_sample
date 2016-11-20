import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() {
		// Obtain a random number from 1 to 10;
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for (int i = 1; i <= count; i++) {
			System.out.println("Running..." + i);
			try {
				Thread.sleep(10_000);	
			} catch (InterruptedException e) {}
			
		}
		return count;
	}
}

public class ExecutorWithFuture {
	public static void main(String... args) {
		Callable<Integer> c = new MyCallable();
		ExecutorService ex =
			Executors.newCachedThreadPool();

			ex.submit(new Runnable() {
				public void run() {
					try {
						Thread.sleep(10_000);
						System.out.println("From runnable");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			});
			System.out.println("Submited Runnable");


		Future<Integer> f = ex.submit(c);

		ex.shutdown();	// no more new tasks
						// but finish existings tasks
		
		/*try {
			if (!ex.awaitTermination(10, TimeUnit.SECONDS)) {
				ex.shutdownNow();
				if (!ex.awaitTermination(10, TimeUnit.SECONDS)) {
					System.out.println("ex did not terminate");
				}
			}
		}
		catch (InterruptedException e) {e.printStackTrace();}*/


		try {
			Integer v = f.get();
			System.out.println("Ran: " + v);
		} catch (InterruptedException | ExecutionException iex) {
			System.out.println("Failed");
		}
	}
}
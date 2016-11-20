
import java.util.concurrent.Executor;
import java.util.concurrent.*;

class InfoHardware implements Runnable {

	public void run() {
		Runtime rt = Runtime.getRuntime();
		int cpus = rt.availableProcessors();
		System.out.println("availableProcessors() - " + cpus);
	}

	public static void main(String... args) {
		InfoHardware r = new InfoHardware();
		ScheduledExecutorService ftses = 
			Executors.newScheduledThreadPool(4);

		ftses.scheduleAtFixedRate(r, 2, 5, TimeUnit.SECONDS);
	}
}
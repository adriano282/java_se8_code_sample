package factory.scheduledthreadpool;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ExecutionException;

public class BeeperControl {
	private final ScheduledExecutorService scheduler =
		Executors.newScheduledThreadPool(1);

	
	public void beepForAnHalfMinute() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("beep");
			}
		};
		
		final ScheduledFuture<?> beeperHandle =	
			scheduler.scheduleAtFixedRate(beeper, 2, 10, SECONDS);
			
		ScheduledFuture<?> sf =	scheduler.schedule(new Runnable() {
			public void run() {
                                System.out.println("Time raw out");
				beeperHandle.cancel(true);
			}
		}, 33, SECONDS);
		
		try {
			sf.get();
			System.out.println("Done!");
			return;
		} catch (InterruptedException | ExecutionException iex) {
			iex.printStackTrace();
		}
	}

	public static void main(String...args) {
		BeeperControl bc = new BeeperControl();
		Runnable r = new Runnable () {
			public void run() {
				BeeperControl bc = new BeeperControl();
				bc.beepForAnHalfMinute();
			}
		};
		new Thread(r).start();
		System.out.println("In main Method");

	}
}




import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

class RandomInitRecursiveAction extends RecursiveAction {
	private static final int THRESHOLD = 10_000;
	private int[] data;
	private int start;
	private int end;

	public RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) {	// is it a manageable amount of work?
			for (int i = start; i < end; i++) {
				data[i] = ThreadLocalRandom.current().nextInt();
			}
		} else {			// task too big, so split it
			int halfWay = ((end - start) / 2) + start;
			RandomInitRecursiveAction a1 = 
				new RandomInitRecursiveAction(data, start, halfWay);

			a1.fork();	// queue left half of task
			RandomInitRecursiveAction a2 =
				new RandomInitRecursiveAction(data, halfWay, end);

			a2.compute();// work on right half of task
			a1.join();		// wait for the queued task to be completed
//			invokeAll(a2, a1);

		}
	}
} 

class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 10_000;
	private int [] data;
	private int start;
	private int end;

	public FindMaxPositionRecursiveTask(int [] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	public  Integer compute() {
		if (end - start <= THRESHOLD) {
			int position = 0;
			for (int i = start; i < end; i++) {
				if (data[i] > data[position]) {
					position = i;
				}
			}
			return position;
		} else { // task too big, split it
			int halfWay = ((end - start) / 2) + start;
			FindMaxPositionRecursiveTask t1 = 
				new FindMaxPositionRecursiveTask(data, start, halfWay);

			t1.fork();		// queue left half of task
			FindMaxPositionRecursiveTask t2 = 
				new FindMaxPositionRecursiveTask(data, halfWay, end);

			int position2 = t2.compute();
			int position1 = t1.join();

			if (data[position1] > data[position2]) {
				return position1;
			} else if (data[position1] < data[position2]) {
				return position2;
			} else {
				return position1 < position2 ? position1 : position2;
			}
		}
	}
}

class ManualInit {
	private int [] data;
	
	ManualInit(int[] data) {
		this.data = data;
	}

	public void fillUp() {
		long start = System.currentTimeMillis();
		int x;
		for (x = 0; x < 10_000_000; x++) {
			data[x] = ThreadLocalRandom.current().nextInt();
		}
		System.out.println(x);
		long end = System.currentTimeMillis();
		System.out.println("Manual FillUP--> Time: " + (end - start));
	}

}

public class RecursiveActionTester {
	public static void main(String... args) {// throws InterruptedException{
		int [] data = new int[100_000_000];

		ManualInit manual = new ManualInit(data);
		manual.fillUp();

		data = new int[20_000];
		long init = System.currentTimeMillis();
		ForkJoinPool fjPool = new ForkJoinPool();

		RandomInitRecursiveAction action =
			new RandomInitRecursiveAction(data, 0, data.length);
		fjPool.invoke(action);
		long end = System.currentTimeMillis();
		System.out.println("Recursive Action--> Time: " + (end - init) + " msecs");



		FindMaxPositionRecursiveTask task = 
		new FindMaxPositionRecursiveTask(data, 0, data.length);
		Integer position = fjPool.invoke(task);
		System.out.println("Position: " + position + ", value: " + 
			data[position]);
	}
}

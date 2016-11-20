import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ComplicatedTask extends RecursiveTask<Integer> {
	int[] ia;
	int from;
	int to;
	static final int THRESHOLD = 3;
	public ComplicatedTask(int[] ia, int from, int to) {
		this.ia = ia;
		this.from = from;
		this.to = to;
	}

	public int transform(int i) {
		// This would be the hard and long process
		// but now just return t
		return i;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (from + THRESHOLD > to) {
			for (int i = from; i <= to; i++) {
				sum = sum + transform(ia[i]);
			}
		} 
		else {
			int mid = (from + to)/2;
			ComplicatedTask newTask1 = new ComplicatedTask(ia, from, mid);
			ComplicatedTask newTask2 = new ComplicatedTask(ia, mid + 1, to);

			
			newTask2.fork();
			
			int sum1 = newTask1.compute();
			int sum2 = newTask2.join();
			sum = sum1 + sum2;

			// Or:
			//sum = newTask1.compute() + newTask2.join();

		}
		return sum;
	}

	public static void main(String... args) {
		int ia[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ForkJoinPool fjp = new ForkJoinPool();

		ComplicatedTask st = new ComplicatedTask(ia, 0, 9);

		int sum = fjp.invoke(st);
		System.out.println("sum: " + sum);
	}
}
package core;

import java.util.concurrent.RecursiveTask;
import java.util.function.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.time.Instant;
import java.time.Duration;

public class ForkJoinSumCalculator extends RecursiveTask<Long>{
	private final long[] numbers;
	private final int start;
	private final int end;
	
	public static final long THRESHOLD = 10_000;
	
	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		int length = end -start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
		
		ForkJoinSumCalculator rightTask = 
				new ForkJoinSumCalculator(numbers, start + length/2, end);
		
		
		
		leftTask.fork();
		Long rightResult = rightTask.compute();
		Long leftResult = leftTask.join();		
	
		return leftResult + rightResult;
	}
	
	private long computeSequentially() {
		long sum = 0;
//		System.out.format("Thread Name %s%n", Thread.currentThread().getName());
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		Duration fastest = null;
		for (int i = 0; i < 10; i++) {
			Instant start = Instant.now();
			//long start = System.nanoTime();
			long sum = adder.apply(n);
			//long duration = (System.nanoTime() - start) /1_000_000;
			Instant end = Instant.now();
			Duration duration = Duration.between(start, end);
			System.out.println("Result: " + sum);
			if (fastest == null || duration.getSeconds() < fastest.getSeconds()) 
				fastest = duration;
		}
		return fastest.toMillis();
	}
	
	public static long forkJoinSum(long n) {
		long [] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}

	public static void main(String[] args) {
		/*System.out.println("Sequencial sum done in: " + 
				measureSumPerf(ParallelStreams::sequentialSum,  10_000_000) + " mscs\n");
		
		System.out.println("Iteration sum done in: " + 
				measureSumPerf(ParallelStreams::iterativeSum,  10_000_000) + " mscs\n");
		
		System.out.println("Parallel sum done in: " + 
				measureSumPerf(ParallelStreams::parallelSum,  10_000_000) + " mscs\n");
		
		System.out.println("Ranged sum done in: " + 
				measureSumPerf(ParallelStreams::rangedSum,  10_000_000) + " mscs\n");
		
		System.out.println("Ranged Parallel sum done in: " + 
				measureSumPerf(ParallelStreams::rangedParallelSum,  10_000_000) + " mscs\n");
		
		System.out.println("Ranged SideEffect sum done in: " + 
				measureSumPerf(ParallelStreams::sideEffectSum,  10_000_000) + " mscs\n");
		*/
		System.out.println("Fork JOin sum done in: " + 
				measureSumPerf(ForkJoinSumCalculator::forkJoinSum,  10_000_000) + " mscs\n");

		System.out.println("done");
		
	}
}


import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
	public static void main(String...args) {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		Stream<Integer> primeStream = primes.stream();

		Predicate<Integer> test1 = k -> k < 10;
/*		long count1 = primeStream.filter(test1).count();
		
		Predicate<Integer> test2 = k -> k > 10;
		long count2 = primeStream.filter(test2).count();

		System.out.println(count1 + " " + count2);
*/
		primeStream.collect(Collectors.partitioningBy(test1, Collectors.counting()))
		.values().forEach(System.out::print);
	}
}

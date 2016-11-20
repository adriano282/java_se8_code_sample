import java.util.*;
import java.util.function.Consumer;
import java.util.concurrent.ThreadLocalRandom;

public class TestClass {
	public static void main(String...args) {
		List<Integer> al = Arrays.asList(100, 200, 230, 291, 43);
		long result = al.stream().count();
		int max = al.stream().reduce(Integer::max).orElse(0);

		int maxWithMax = al.stream().max(Integer::compare).orElse(0);
		System.out.format("Max with Max: %s%n", maxWithMax);
		int sum = al.stream().mapToInt(e -> e).sum();
		System.out.println(result);
		System.out.println(sum);
		System.out.println(max);
		
		

		Consumer<String> c = (s) -> s = s;
		System.out.println(c);


		long r = ThreadLocalRandom.current().nextLong(1, 11);
		System.out.println(r);
	}
}

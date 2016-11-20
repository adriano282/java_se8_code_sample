import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class PeekMethod {
	public static void main(String... args) {
		List<Integer> numbers = Arrays.asList(2, 3, 4);
		List<Integer> result = numbers.stream()
			.peek(System.out::println)
			.map(x -> x + 1)
			.peek(System.out::println)
			.filter(x -> x % 2 == 0)
			.collect(toList());

		System.out.println(result);
	}
}

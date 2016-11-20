import java.util.stream.IntStream;

public class TestClass {
	public static void main(String...args) {
		Object v1 = IntStream.rangeClosed(10, 100_000_000)
				
				.filter(x -> x > 12)
				.parallel()
				.findAny();

		System.out.println(v1);
	}
}
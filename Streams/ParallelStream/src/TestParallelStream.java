import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class TestParallelStream {
	public static void main(String... args) {
/*		List<String> vals = Arrays.asList("a", "b");
		String join = vals.parallelStream()
				.reduce("_", (a, b)->a.concat(b));
		System.out.println(join);*/
		test();
	}
	public static void test() {
		List<String> vals = 
		Arrays.asList(	"a", "b", "c", "d", "e", "f", "g",
						"a", "b", "c", "d", "e", "f", "g", 
						"a", "b", "c", "d", "e", "f", "g", 
						"a", "b", "c", "d", "e", "f", "g");

		BiFunction<String,String,String> biF = 
		(a, b) ->  {
			System.out.println("reducing "+a+" and "+b+" Thread: " + Thread.currentThread().getName());
			return a.concat(b);
		};

		BinaryOperator<String> biO = 
		(a, b) ->  {
			System.out.println("combining "+a+" and "+b+" Thread: " + Thread.currentThread().getName());
			return a.concat(b);
		};

		String join = vals.parallelStream()
					.peek(System.out::println)
					.reduce("_", biF, biO);

		System.out.println(join);
	}
}
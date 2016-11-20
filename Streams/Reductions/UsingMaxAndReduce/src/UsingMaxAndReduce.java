import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Comparator;

public class UsingMaxAndReduce {
	public static void main(String... args) {
		List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
		System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b? a : b));
		System.out.println(ls.stream().reduce((a, b) -> a > b? a : b));
		System.out.println(ls.stream().reduce(Integer::max));
		System.out.println(ls.stream().max(Integer::compareTo));
		System.out.println(ls.stream().max((a, b) -> a > b? a : b));
		System.out.println(ls.stream().max((a, b) -> a.compareTo(b)));
		System.out.println(ls.stream().mapToInt((a)-> a).count());

		System.out.println();
		System.out.println("stream().count()");
		System.out.println(ls.stream().count());
		System.out.println("-----------------\n");

		System.out.println("stream().max(Integer::compare)");
		System.out.println(ls.stream().max(Integer::compare));
		System.out.println("-----------------\n");		

		System.out.println("stream().reduce(Integer::max)");
		System.out.println(ls.stream().reduce(Integer::max));
		System.out.println("-----------------\n");		

		System.out.println("stream().reduce(0, Integer::max)");
		System.out.println(ls.stream().reduce(0, Integer::max));
		System.out.println("-----------------\n");		

		System.out.println("stream().reduce(0, Integer::min)");
		System.out.println(ls.stream().reduce(0, Integer::min));
		System.out.println("-----------------\n");		

		System.out.println("stream().reduce(Collectors.comparing((a)-> a))");
		System.out.println(ls.stream().max(Comparator.comparing((a)->a)));
		System.out.println("-----------------\n");		


	}
}

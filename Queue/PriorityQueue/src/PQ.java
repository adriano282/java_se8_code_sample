import java.util.*;
import java.util.function.BinaryOperator;

public class PQ {
	public static void main(String...args) {
		Comparator<Integer> cmp = (a, b) -> b.compareTo(a);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(100, cmp);
		q.addAll(Arrays.asList(16, 8, 42, 15, 4, 23));
		System.out.println(q);
		System.out.println(q.poll());
	}
}

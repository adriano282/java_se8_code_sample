import java.util.*;

class SetIssue {
	public static void main(String ... args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add("2");
		set.add(3);
		set.add("1");

		Iterator it = set.iterator();

		while (it.hasNext())
			System.out.println(it.next() + " ");
	}
}
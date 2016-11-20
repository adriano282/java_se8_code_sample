import java.util.*;

public class Ferry {
	public static void main(String... args) {
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(2300);
		times.add(1505);
		times.add(1545);
		times.add(1600);
		times.add(1830);
		times.add(2010);
		times.add(2100);

		TreeSet<Integer> subset = new TreeSet<Integer>();
		System.out.println("before time: " + times);
		//subset = (TreeSet) times.headSet(1600);
		//System.out.println("J5 - last before 4pm is: " + subset.last());

		subset = (TreeSet) times.headSet(2000);
		System.out.println(times);
		System.out.println(subset);
		times.pollFirst();
		System.out.println(times);
		System.out.println(subset);

		/*TreeSet<Integer> sub2 = new TreeSet<Integer>();
		sub2 = (TreeSet) times.tailSet(2000);
		System.out.println("J5 - first after 8pm is: " + sub2.first());

		System.out.println("J6 - last before 4pm is: " + times.lower(1600));
		System.out.println("J6 - last before 4pm is: " + times.higher(2000));

		System.out.println("J6 - last before 4pm is: " + times.floor(1600));
		System.out.println("J6 - last before 4pm is: " + times.ceiling(2000));

		System.out.println(times);

		System.out.println("J6 - last before 4pm is: " + times.pollFirst());
		System.out.println("J6 - last before 4pm is: " + times.pollLast());
		System.out.println(times);

		System.out.println(times.descendingSet());
		*/
	}
}
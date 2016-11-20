import java.util.*;

class TreeSetTest {
	public static void main(String... args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(5);

		TreeSet<Integer> subset;
		//subset = (TreeSet) set.subSet(2, false, 4, true); / Exclusive both start and end
		//subset = (TreeSet) set.headSet(3); // Exclusive End
		//subset = (TreeSet) set.headSet(3, true); // Inclusive End
		subset = (TreeSet) set.tailSet(3); 
		System.out.println(subset);
	}
}
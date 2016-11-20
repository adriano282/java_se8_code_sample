import java.util.*;

public class TreeSetValues {
    /**
	        A TreeSet can maintain a list sorted
	        by natural order, or using some Comparator.
	        The TreeSet doesn't accept duplicates values
	**/

	public static final TreeSet<Integer> treeSet = new TreeSet<>();
	public static void init() {
                System.out.println("Initializing TreeSet<Integer> ");
                treeSet.add(1000);
                System.out.println("Adicioned value " + 1000);
                treeSet.add(500);
                System.out.println("Adicioned value " + 500);
                treeSet.add(5000);
                System.out.println("Adicioned value " + 5000);
                treeSet.add(500);
                System.out.println("Adicioned value " + 500);
	}
	public static void main(String ... args) {}
}

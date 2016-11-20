import java.util.TreeSet;
import java.util.TreeSet;

public class CeilingHigherMethodsExample {
	public static void main(String... args) {

		TreeSetValues.init();

		System.out.println("\nResult");
		System.out.println(TreeSetValues.treeSet);
		
		System.out.println("\nTesting ceiling and higher method");
		System.out.println("method ceiling(1000) return min value >= 1000");
		System.out.println(TreeSetValues.treeSet.ceiling(1000));

		System.out.println("method higher(1000) return min value > 1000");
		System.out.println(TreeSetValues.treeSet.higher(1000));
	}
}

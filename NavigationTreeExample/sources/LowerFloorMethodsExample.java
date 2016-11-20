import java.util.TreeSet;
import java.util.TreeSet;

public class LowerFloorMethodsExample {
        public static void main(String... args) {
		
		// Sorted by natural order
		TreeSetValues.init();
                System.out.println(TreeSetValues.treeSet);
		System.out.println();
		System.out.println("Testing the lower and floor method");
                System.out.println("lower(1000) return max value < 1000:");
                System.out.println(TreeSetValues.treeSet.lower(1000));

                System.out.println("method floor(1000) return max value <= 1000:");
                System.out.println(TreeSetValues.treeSet.floor(1000));

        }
}




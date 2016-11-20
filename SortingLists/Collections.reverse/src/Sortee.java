import java.util.*;
import static java.util.Collections.sort;
import static java.util.Collections.reverse;
import static java.util.Collections.reverseOrder;

class Sortee {
	public static void main(String... args) {
		List x = new ArrayList();
		x.add(5);
		x.add(new Integer(42));
		x.add(new Integer("17"));
		x.add(Integer.parseInt("812"));
		
//		sort(x, new Comparator<Integer>() {
//			public int compare(Integer i1, Integer i2) {
//				int r = i2.compareTo(i1);
//				System.out.println("i1: " + i1 + "\ni2: " + i2 + "\nResult: " + r + "\n\n");
//				return 	r;
//			}
//		});

		reverse(x);

		System.out.println(x);
	}
}

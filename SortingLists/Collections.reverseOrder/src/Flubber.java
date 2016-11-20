import java.util.*;

public class Flubber {
	public static void main(String... args) {
		List<String> x = new ArrayList<String>();
		x.add(" x");
		x.add("xx");
		x.add("Xx");
		
		System.out.println("sorted normal:");
		Collections.sort(x);
		x.stream().forEach(System.out::println);
		
		System.out.println("sorted reverse");
		Comparator c = Collections.reverseOrder();
		Collections.sort(x, c);		
		
		x.stream().forEach(System.out::println);
	}
}

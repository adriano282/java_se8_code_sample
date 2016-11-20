import java.util.*;
public class TestClass {
	public static void main(String...args) {

		String[] sa = {" aA", " Aa", "1a", "a", "A"};

		System.out.println("Before sort: ");
		Arrays.asList(sa).stream().forEach((s) -> System.out.print(s + ","));

	
		Arrays.sort(sa, null);

		System.out.println("\nAfter sort: ");
		Arrays.asList(sa).forEach((s) -> System.out.print(s + ","));
	}
}
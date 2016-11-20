import java.util.*;

public class TestClass {
	public static void main(String...args) {
		List<Double> ls = Arrays.asList(10.0, 12.0);
		
		ls.stream().forEach(x -> {x = x + 10;});
		ls.stream().forEach(System.out::print);
	}
}

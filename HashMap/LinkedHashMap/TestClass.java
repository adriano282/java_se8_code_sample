import java.util.*;
import java.util.stream.IntStream;
import java.util.function.IntConsumer;

public class TestClass {
	public static void main(String...args) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		IntConsumer consumer = (e) -> map.put("" + e, e);
		IntStream.rangeClosed(1, 10).forEach(consumer);

		System.out.println(map);

		Integer r = map.remove("9");
		map.put("9", r);
		System.out.format("map.remove(9): %s%n", r);
		System.out.format("map.get(8): %s%n", map.get("8"));

		System.out.println(map);
	}
}
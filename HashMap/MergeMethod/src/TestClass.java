import java.util.*;

public class TestClass {
	public static void main(String...args) {
		Map<String, Integer> map = new HashMap<>();
		System.out.println(map.put("a", null));
		System.out.println(map.put("b", 2));
		System.out.println(map.put("b", 3));

		System.out.println(map.merge("b", 1, (a1, a2) -> a1 + a2));
		System.out.println(map.merge("c", 3, (a1, a2) -> a1 + a1));
		System.out.println(map.merge("a", 3, (a1, a2) -> a1 + a2));

		System.out.println(map);		
		
	}
}

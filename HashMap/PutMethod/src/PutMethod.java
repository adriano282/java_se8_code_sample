import java.util.*;

public class PutMethod {
	public static void main(String...args) {
		HashMap<String, Integer> map = new HashMap<>();
		System.out.println(map.put("a", 1));
		System.out.println(map.put("b", 2));
		System.out.println(map.put("c", 3));
		
		map.forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println(map.put("b", 5));
		map.forEach((k, v) -> System.out.println(k + ":" + v));
		
	
	}
}

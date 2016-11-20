import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class ConcurrentCollection {
	public static void main(String ... args) {
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("A", 2);
		System.out.println(map);

		System.out.println(	map.putIfAbsent("V", 1));
		System.out.println(map);
	}
}
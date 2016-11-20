import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;

@interface Pong { Ping value(); }
@interface Ping { Pong value(); }
class HashMapTest  {
	public static void main(String... args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		Optional<Integer> maxValue = Optional.of(map.reduceValues(1, Integer::max));
		maxValue.ifPresent(System.out::println);
	}
}
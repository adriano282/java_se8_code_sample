import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class UsingConcurrentHashMap {
	public static void main(String ... args) {
		Map chm = new ConcurrentHashMap();
		// Concurrent Collections don't accept null values and null keys
//		chm.put(null, "asdf");
//		chm.put("aaa", null);
	}
}

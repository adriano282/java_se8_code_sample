import java.util.*;

class BackedCollection {
	public static void main(String... args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant");
		map.put("d", "dog");
		map.put("h", "horse");
		map.put("g", "horse");
		map.put("m", "horse");


		SortedMap<String, String> submap;
		submap = map.subMap("b", "g");

		System.out.println(map + "   " + submap);

		map.put("b", "bat");
		submap.put("f", "fish");

		map.put("r", "raccoon");
		//throws IllegalArgumentException here 
		// becaurse p is out from range b and g
		//submap.put("g", "pig");
		System.out.println(map + "   " + submap);
	}
}

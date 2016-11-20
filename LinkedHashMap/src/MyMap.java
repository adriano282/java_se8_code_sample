import java.util.*;
import java.util.function.BiConsumer;

public class MyMap {
	String name;
	MyMap(String s) { name = s; }
	public static void  main(String...args) {
		Map<MyMap, String> maps = new LinkedHashMap<>();
		maps.put(new MyMap("Redwood"), "XL ");
		maps.put(new MyMap("Oak"), "S ");
		maps.put(new MyMap("Redwood"), "M ");
		maps.put(new MyMap("Redwood"), "XL ");
		maps.put(new MyMap("Oak"), "M ");
		
		BiConsumer<MyMap, String> biConsumer = 
			(a, b) -> System.out.println(a.name + " " + b);
		maps
		.forEach(biConsumer);

	}
}

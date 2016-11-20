import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class RemoveMethodConcurrent<K, V> {
	private ConcurrentHashMap chm;
	private boolean isInitied = false;

	public void init() {
			chm = new ConcurrentHashMap<>();
			addValue("A", new Integer(1));
			addValue("B", new Integer(2));
			addValue("C", new Integer(3));
			addValue("C", new Integer(4));

			// Does NOT Accept null keys and not null values
//			addValue(null, new Integer(4));
			print("The hash has been initied successufully!");
			isInitied = true;
	}

	public void addValue(String k,Integer v) {
		System.out.format("put( %s, %s ), return %s%n", k, v, chm.put(k, v));
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public void remove(String s) {
		System.out.format("remove(%s)%n", s);
		System.out.format("return: %s%n", chm.remove(s));
	}

	public void removeIfContains(String k, Integer v) {
		
		print("remove(" + k + ", " + v + ")");
		System.out.format("Return: %s%n", chm.remove(k, v));
	}

	public void show() {
		Iterator it = chm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			print(pairs.getKey() + " = " + pairs.getValue());
		}
	}

	public static void main(String... args) {
		RemoveMethodConcurrent<String, Integer> r = new RemoveMethodConcurrent<String, Integer>();
		r.init();
		r.show();
		r.removeIfContains("A", 1);
		r.show();
		r.removeIfContains("B", 5);
		r.show();
		r.remove("B");
		r.show();
	}
}
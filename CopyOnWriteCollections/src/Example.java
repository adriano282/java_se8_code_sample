import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
	public static void main(String...args) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("Java");
		list.add("Java Standard Edition");
		list.add("Java Enterprise Edition");
		
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			list.add("J");
		}

		System.out.println("\n");
		it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			list.add("J");
		}
		
	}
}

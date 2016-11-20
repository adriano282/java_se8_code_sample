import java.util.*;

public class HardQuestion {
	public static void main(String... args) {
		Queue<String> q = new LinkedList<String>();
		q.add("Adriano");
		q.add("Gabriel");
		q.add("Maria");
		showAll(q);
	}
	public static void showAll(Queue q) {
		q.add(new Integer(42));
		while (!q.isEmpty())
			System.out.println(q.remove() + " ");
	}
}


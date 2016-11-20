
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class CopyOnWriteExample {
	public static void main(String ... args) {
		CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<Integer>();
		System.out.format("cowList.add(%s), return: %s%n", 4, cowList.add(4));
		System.out.format("cowList.add(%s), return: %s%n", 2, cowList.add(2));
		System.out.format("cowList.add(%s), return: %s%n", 6, cowList.add(6));

		System.out.format("Start List: %s%n", cowList);

		System.out.format("%ncowList.iterator()%n");
		Iterator<Integer> it = cowList.iterator();

		System.out.format("cowList.remove(%s), return: %s%n", 2, cowList.remove(2));

		System.out.format("Iterating throug%n");
		while(it.hasNext()) {
			System.out.println(it.next() + " ");
		}

		// throws UnsupportOperationExceptions
		// it.remove();
	}
}
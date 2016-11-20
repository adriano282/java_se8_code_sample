import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();

		System.out.println("\nDifference: " + (measureTimeMethod(arrayList, "add") - measureTimeMethod(linkedList, "add")));

		System.out.println("\nDifference: " + (measureTimeMethod(arrayList, "get") - measureTimeMethod(linkedList, "get")));
		
		System.out.println("\nDifference: " + (measureTimeMethod(arrayList, "remove") - measureTimeMethod(linkedList, "remove")));
    	}
	
	public static long measureTimeMethod(List<Integer> l, String operation) {
		long startTime = System.nanoTime();
		
		switch(operation) {
			case "add":
				for (int i = 0; i < 10_000; i++) {
					l.add(i);
				}
				break;
			case "get":
		                for (int i = 0; i < 10_000; i++) {
					l.get(i);
				}
				break;
			case "remove":
		                for (int i = 9_999; i >= 0; i--) {
					l.remove(i);
				}
				break;
			default:
				new IllegalArgumentException("Invalid Operation");
		}
		
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		
		System.out.println(l.getClass() + " " + operation + " " + duration);
		return duration;
	}
}

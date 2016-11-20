import java.util.*;

class TrickyIssue {

	public static void main(String... args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("2");
		pq.add("4");
		System.out.println("1 - " + pq);
		System.out.println(pq.peek() + " ");
		pq.add("1");
		System.out.println("2 - " + pq);
		pq.add("3");
		System.out.println("3 - " + pq);
		pq.remove("1");
		System.out.print(pq.poll() + " ");

		System.out.println(pq);
		if(pq.remove("2")) System.out.print(pq.poll() + " ");
		System.out.println( po(pq) + " " + pe(pq));
	}

	public static String po (PriorityQueue<String> pq) {
		System.out.println("first here");
		return pq.poll();
	}

	public static String pe (PriorityQueue<String> pq) {
		System.out.println("second here");
		return pq.peek(); }
}
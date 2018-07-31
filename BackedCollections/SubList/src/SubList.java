import java.util.*;
import java.util.function.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SubList {

	public static void print(List<? extends Object> list) {
		
		System.out.println(list.getClass());
		System.out.print("Content: ");
		for (int i = 0 ; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i < list.size() -1)
				System.out.print(", ");
			else
				System.out.println("\n");
		}
	}

	public static void main(String...args) {

		List<String> vowels = new ArrayList<String>();
		vowels.add("a"); 
		vowels.add("e"); 
		vowels.add("i"); 
		vowels.add("o"); 
		vowels.add("u"); 

		System.out.println("Main list (vowels):");
		print(vowels);

// 		This would resolve the ConcurrentModificationException, but it would not be a backed list.
//		List<String> subList = new CopyOnWriteArrayList<String>(vowels.subList(2, 4)); 

		List<String> subList = vowels.subList(2, 4);
		System.out.println("List subList = vowels.subList(2, 4)");

		subList.add("B");
		System.out.println("subList.add(\"B\")");
		
		System.out.println("SubList: ");
		print(subList);

		System.out.println("Main list (vowels):");	
		print(vowels);
		
		vowels.add("L");
		System.out.println("vowels.add(\"L\")");

		System.out.println("Main list (vowels):");
		print(vowels);

		// Starting to this point, is not possible to access the subList, 
		// because its originator, vowels, was altered (vowels.add("L")), so, 
		// if we attempt to access the subList, it will throw a ConcurrentModificationException
//		System.out.println("Sublist: ");
//		print(subList);
	}
}

import java.util.*;
import java.util.function.*;

public class SubList {
	public static void main(String...args) {
		List<String> vowels = new ArrayList<String>();
		vowels.add("a"); 
		vowels.add("e"); 
		vowels.add("i"); 
		vowels.add("o"); 
		vowels.add("u"); 
		Function<List<String>, List<String>> f = list->list.subList(2, 4); 
		List<String> subList = f.apply(vowels); 
		subList.add("B");

		subList.forEach(System.out::print);
		System.out.println();
		vowels.forEach(System.out::print);
		System.out.println("\n");

		vowels.add("L");

		// This wont compile bacause it isnt a CopyOnWriteArrayList
		// and forEach uses Iterator
		//subList.forEach(System.out::print);
		//for (int i = 0; i < subList.size(); i++)
		//System.out.print(subList.get(i));
		
		System.out.println();
		vowels.forEach(System.out::print);


	}
}
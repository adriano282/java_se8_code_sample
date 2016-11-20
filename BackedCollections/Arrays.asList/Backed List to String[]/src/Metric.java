import java.util.*;

public class Metric {
	public static void main(String... args) {
		String[] s = {"inch", "foot", "yard", "rod", "meteor"};
		List list = Arrays.asList(s);
		
		System.out.print("Origin String[]: ");
		showAll(s);
		

		System.out.println("List list = Arrays.asList(s)");
		System.out.print("Origin List: 	   " + list + "\n\n");

		System.out.println("list.set(4, 'chain')");		
		list.set(4, "chain");
	
		System.out.println(" String[]:  ");
		showAll(s);
		

		System.out.println(" List:      " + list);

		s[2] = "meteor";
		System.out.println("s[2] = 'meteor'");

		System.out.println("String[] : ");
		showAll(s);
		System.out.println("List:      " + list);
		
		
	}
	public static void showAll(String[] s) {
		for (String i : s)
			System.out.print(i + " ");
		System.out.println();
	}
	
}


import java.util.function.*;
import java.nio.file.*;
import java.util.*;

public class TestClass {
	public static void show(String[] sa, List<String> back) {
		System.out.print("\n(String[]) sa: ");
		Arrays.asList(sa).forEach(System.out::print);
		System.out.println("\n(List) back: " + back);
	}

	public static void main(String... args) {
		Path p1 = Paths.get("/home/documents/test.txt");
		System.out.println(p1.subpath(0,2));

		Path sub = p1.subpath(0,2);
		System.out.println(sub);

		String[] sa = {"1", "2", "3"};
		System.out.println("\nDeclaration: String[] sa = {\"1\", \"2\", \"3\"};");


		List<String> back = Arrays.asList(sa);
		System.out.println("\nDeclaration: List<String> back = Arrays.asList(sa);");
		show(sa, back);

		back.set(2, "6"); System.out.println("back.set(2, \"6\")");

		show(sa, back);
		
		sa[2] = "4";System.out.println("sa[2] = \"4\"");

		show(sa, back);

       	String[] array = {"1", "2", "3"};
       	System.out.println("\nDeclaration: String[] array = {\"1\", \"2\", \"3\"};");
       	List<String> stringList = new ArrayList<>(Arrays.asList(array));
       	System.out.println("\nDeclaration: List<String> stringList = new ArrayList<>(Arrays.asList(array));");

		System.out.print("\n(String[]) array: ");
		Arrays.asList(array).forEach(System.out::print);
		System.out.println("\n(List) stringList: " + stringList);
		
       	stringList.add("7"); System.out.println("stringList.add(\"7\");");

		System.out.print("\n(String[]) array: ");
		Arrays.asList(array).forEach(System.out::print);
		System.out.println("\n(List) stringList: " + stringList);
    }
}

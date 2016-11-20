import java.nio.file.*;
public class TestClass {
	public static void main(String...args) {
		//Path p1 = Paths.get("/home/adriano/documents/file.txt");
		Path p1 = Paths.get("c:\main\project\Starter.java");
		Path root = p1.getRoot();
		System.out.format("getRoot(): %s%n", root);

		Path zero = p1.getName(0);
		System.out.format("getName(0): %s%n", zero);

		Path one = p1.getName(1);
		System.out.format("getName(1) %s%n", one);

		Path two = p1.getName(2);
		System.out.format("getName(2) %s%n", two);

		Path three = p1.getName(3);
		System.out.format("getName(3) %s%n", three);

		Path four = p1.getName(-4);
		System.out.format("getName(4) %s%n", four);



	}	
}
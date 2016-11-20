import java.nio.file.*;
public class TestClass {
	public static void main(String...args) {
		Path p1 = Paths.get("/personal/./photos/../readme.txt");
		Path p2 = Paths.get("personal/index.html");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2 + "\n");
		System.out.println("p1.relativize(p2):");
//		System.out.println(p1.relativize(p2));
		

                System.out.println("\n\np1.resolve(p2)");
                System.out.println(p2.resolve(p2));
		System.out.println("\n\np2.resolve(p2)");
		System.out.println(p2.resolve(p2));
                System.out.println("\n\np2.resolve(p1)");
		System.out.println(p2.resolve(p1));

		System.out.println("\n\np1.normalize()");
		System.out.println(p1.normalize());

		boolean b = p1.relativize(p1.resolve(p2)).equals(p2);
		System.out.println(b);

	}
}

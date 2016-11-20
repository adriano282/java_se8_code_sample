import java.nio.file.*;

public class TestClass {
	public static void main(String...args) {
		Path p1 = Paths.get("photos/../beaches/./calangute/a.txt");

		System.out.println(p1.relativize(Paths.get("photos/teste.txt")));
		Path p2 = p1.normalize();
		Path p3 = p1.relativize(p2);
		Path p4 = p2.relativize(p1);

		System.out.format("p1: %s, p1.getNameCount(): %s%n", p1, p1.getNameCount());
		System.out.format("p2: %s, p2.getNameCount(): %s%n", p2, p2.getNameCount());
		System.out.format("p3: %s, p3.getNameCount(): %s%n", p3, p3.getNameCount());
		System.out.format("p4: %s, p4.getNameCount(): %s%n", p4, p4.getNameCount());


		Path pat = Paths.get("/A/B/D");
		Path pat2 = Paths.get("E/R");

		// pat.resolve(pat2): /A/B/D/E/R
		System.out.format("pat.resolve(pat2): %s%n", pat.resolve(pat2));

		// pat.relativize(Paths.get("/A/B/D/E/R")):
		System.out.format("pat.relativize(Paths.get('/A/B/D/E/R')): %s%n", pat.relativize(pat.resolve(pat2))) ;

		boolean equal = pat.relativize(pat.resolve(pat2)).equals(pat2);
		System.out.println(equal);

	}
}

import java.nio.file.*;

public class Relativize {
	public static void main(String...args) {
		Path p1 = Paths.get("/Home/adriano");
		Path p2 = Paths.get("/documents/executeJava");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
		System.out.println(p1.resolve(p1));

	}
}

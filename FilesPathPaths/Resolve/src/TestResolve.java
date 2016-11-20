import java.nio.file.Paths;
import java.nio.file.Path;

public class TestResolve {
	public static void main(String...args) {

		// When one of paths is root, then the second is just
		// appended
		Path p1 = Paths.get("/Home/adriano/file.txt");
		Path p2 = Paths.get("report.pdf");
		System.out.println(p1.resolve(p2));


		Path p3 = Paths.get("/Home/adriano/file.txt");
		Path p4 = Paths.get("/Home/adriano/documents/report.pdf");
		System.out.println("Resolve: " + p3.resolve(p4));
		System.out.println("Relativize: " + p3.relativize(p4));
	}
}
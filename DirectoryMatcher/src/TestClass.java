import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.PathMatcher;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.Path;

public class TestClass {
	public static void main(String...args) {
		Pattern p = Pattern.compile(".?pdf");
		Matcher m = p.matcher("pdf");

		System.out.println(m.matches());

		m = p.matcher(".pdf");
		System.out.println(m.matches());

		
		Path path = Paths.get("/a/a/a/pdf");
		PathMatcher matcher = FileSystems
					.getDefault()
					.getPathMatcher("glob:/**/.?pdf");

		System.out.println(matcher.matches(path));

		
		
	}
}

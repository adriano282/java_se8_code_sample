import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.FileSystems;

public class PathsPointGetExamples {
	public static Path path;
	public static void createAbsolutePath() {
		Path fileRelativeExample = Paths.get("../content/file.txt");

		Path absolutePath = fileRelativeExample.toAbsolutePath();
		System.out.println("Is Absolute?: " + absolutePath.isAbsolute());
		System.out.println("Absolute Path: ");
		System.out.println(absolutePath);
	}
	public static void createRelativePath() {
		path = Paths.get("../content/file.txt");
                System.out.println("\n\nIs Absolute?: " + path.isAbsolute());
                System.out.println("RelativePath: ");
                System.out.println(path);
	}
	public static void getShortPathFileSystem() {
		Path shortP = Paths.get("/home", "/Development");
		System.out.println(shortP);
		
	}
	public static void getLongPathFileSystem() {
		Path longer = FileSystems.getDefault().getPath("/home", "Development");
		System.out.println(longer);
	}
	public static void main(String... args) {
		createAbsolutePath();
		createRelativePath();
		getShortPathFileSystem();
		getLongPathFileSystem();
	}
}

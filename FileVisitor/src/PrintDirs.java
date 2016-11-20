import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class PrintDirs extends SimpleFileVisitor<Path> {
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		print("pre: " + dir);
		if (dir.getFileName().toString().equals("src")) {
			//return FileVisitResult.SKIP_SIBLINGS;
			//return FileVisitResult.TERMINATE;
			return FileVisitResult.SKIP_SUBTREE;

		}
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		print("file: " + file);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		print("occur exception");
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		print("post: " + dir);
		return FileVisitResult.CONTINUE;
	}

	public static void print(String text) {System.out.println(text);}

	public static void main(String... args) {
		PrintDirs dirs = new PrintDirs();
		try {
			Path path = Paths.get("../FileVisitor");
			System.out.println(path);
			System.out.println(path.toFile().getAbsoluteFile());
			String absolute = "" + path.toFile().getAbsoluteFile();
			
			Files.walkFileTree(path, dirs);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

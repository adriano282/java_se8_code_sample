import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

class RemoveClassFiles extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(
		Path file, BasicFileAttributes attrs) throws IOException {
		
		if (!file.getFileName().toString().endsWith(".class") &&
			!file.getFileName().toString().endsWith(".java")) {
			System.out.println(file.getFileName());
		}
			
		return FileVisitResult.CONTINUE;
	}

	public static void main(String... args) throws IOException {
		RemoveClassFiles dirs = new RemoveClassFiles();
		Files.walkFileTree(Paths.get("./"), dirs);
	}
}

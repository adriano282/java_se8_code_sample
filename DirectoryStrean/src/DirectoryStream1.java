import java.nio.file.*;
import java.io.*;

class DirectoryStream1 {
	public static void main(String... args) throws IOException {
		Path dir = Paths.get("/");
		try (DirectoryStream<Path> stream =	Files.newDirectoryStream(dir)) {
			for (Path path : stream)
				System.out.println(path.getFileName());
		}
	}
}

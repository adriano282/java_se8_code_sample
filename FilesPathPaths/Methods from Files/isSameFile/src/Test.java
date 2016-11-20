import java.nio.file.*;
import java.io.*;

public class Test {
	public static void main(String...args) {
		Path dir = Paths.get("resources");
		try {		
			if (!Files.exists(dir))
				Files.createDirectory(dir);
		
			Path file1 = Paths.get("resources", "file.txt");
			Path file2 = Paths.get("resources", "A", "file.txt");

//			if (!Files.exists(file1))
//				Files.createFile(file1);

//			if (!Files.exists(file2))
//				Files.createFile(file2);
	
			boolean equals = Files.isSameFile(file1, file2);
			System.out.println(equals);
		} catch (IOException e) {throw new RuntimeException(e);}


	}
}

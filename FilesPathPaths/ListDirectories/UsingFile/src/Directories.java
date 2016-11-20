import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

class Directories {
	static String[] dirs = {"dir1", "dir2"};
	public static void main(String[] args) {
		Path p = Paths.get("file.txt");
		System.out.println(Files.exists(p));
		try {
			Files.list(p)
				.forEach(System.out::println);
		} catch (IOException e) {e.printStackTrace();}
	}
}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TestClass {
	public static void main(String...args) throws IOException {
		Stream<Path> s = Files.list(Paths.get("../../../"));
		s.forEach(System.out::println);
	}
}

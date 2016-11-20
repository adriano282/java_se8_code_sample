import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

public class TestClass {
	public static void main(String...args) {
		Predicate<Path> name = p -> p.toString().toUpperCase().contains("GROUP");
		Predicate<Path> isFile = p -> p.toFile().isFile();

		ToLongFunction<Path> toLongFunction = p -> {
				try { Files.copy(p, Paths.get("files/", p.getFileName().toString()), REPLACE_EXISTING);} 
				catch (IOException e) {e.printStackTrace();}
                                return 1L;};
		try {
			long count = Files.walk(Paths.get("../../../"))
				.filter(name)
				.filter(isFile)
				.peek(System.out::println)
				.mapToLong(toLongFunction)
				.count();

			System.out.println("Were find " + count + " files.");
		} catch (IOException e) {e.printStackTrace();}
	}
}

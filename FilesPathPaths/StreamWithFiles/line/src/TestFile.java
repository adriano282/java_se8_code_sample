import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.io.IOException;

class TestFile {
	public static void main(String... args) {
		try (Stream<String> lines = 
				Files.lines(Paths.get("bin/arquivo.txt"))) {

				long count = lines
					.flatMap(line -> Arrays.stream(line.split(" ")))
					.filter(s -> !s.isEmpty())
					.count();

				System.out.println(count);
					



		} catch (IOException e) {e.printStackTrace();}
	}
}
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

public class TestClass {
	public static void main(String...args) {
		try {
//			Path p = Paths.get("files/file.txt");
//			Files.createFile(p);
			List<String> data = Files.readAllLines(Paths.get("files/file.txt"));
			data.stream().forEach(line -> {
				try {
					Files.write(Paths.get("files/file2.txt"),
						line.concat("\n").getBytes(), new OpenOption[] {
							StandardOpenOption.CREATE , StandardOpenOption.APPEND
						});
				}
				catch (IOException e) {e.printStackTrace();}
			});
		}
		catch (IOException e) {e.printStackTrace();}
	}
}

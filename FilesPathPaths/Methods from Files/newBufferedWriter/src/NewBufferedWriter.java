import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;

public class NewBufferedWriter {
	public static void main(String...args) {
		Path file1 = Paths.get("../Files Resources", "Teste.txt");

		try (BufferedWriter bw = Files.newBufferedWriter(file1)) {
			bw.write("Adriano Adriano Adriano ");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

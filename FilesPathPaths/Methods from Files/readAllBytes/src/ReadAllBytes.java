import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class ReadAllBytes {
	public static void main(String ...args) {
		Path filePath = Paths.get("files", "a.txt");
		if (Files.exists(filePath)) {
			try {
				byte[] bytes = Files.readAllBytes(filePath);
				String text = new String(bytes, StandardCharsets.UTF_8);

				System.out.println(text);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
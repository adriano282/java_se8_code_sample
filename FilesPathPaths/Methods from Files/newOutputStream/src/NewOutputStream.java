import java.nio.file.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class NewOutputStream {
	public static void main(String...args) {
		Path filePath1 = Paths.get("../Files Resources", "c.txt");
		Path filePath2 = Paths.get("../Files Resources", "b.txt");

		try (OutputStream os = Files.newOutputStream(filePath1);
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);) {

			bw.write("Using BufferedWriter from outputStream");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}
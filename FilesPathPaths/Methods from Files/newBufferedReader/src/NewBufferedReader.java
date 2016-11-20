import java.nio.file.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class NewBufferedReader {
	public static void main(String...args) {
		Path filePath1 = Paths.get("../Files Resources", "a.txt");
		Path filePath2 = Paths.get("../Files Resources", "y.txt");

		try (BufferedReader br = Files.newBufferedReader(filePath2);) {
			String line;
			//throws IOException
			while((line = br.readLine()) != null)
				System.out.println(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}

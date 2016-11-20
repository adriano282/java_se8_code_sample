import java.nio.file.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class NewInputStream {
	public static void main(String...args) {
		Path filePath1 = Paths.get("../Files Resources", "a.txt");
		Path filePath2 = Paths.get("../Files Resources", "b.txt");

		try (InputStream is = Files.newInputStream(filePath1);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr)) {

			String line;

			//throws IOException
			while((line = br.readLine()) != null)
				System.out.println(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}
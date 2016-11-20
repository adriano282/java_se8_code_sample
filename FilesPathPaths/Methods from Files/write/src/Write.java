import java.nio.file.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Write {
	public static void main(String...args) {
		Path filePath1 = Paths.get("../Files Resources", "a.txt");
/*		byte[] bytes = new byte[] {0x48, 0x65, 0x6c, 0x6c, 
			0x6f, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};

		try {
			Files.write(filePath1, bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
*/
		List<String> lines = new ArrayList<>();

		for (int i = 0; i < 20; i++)
			lines.add("Adrino de Jesus" + (i + 1));

		try {
			Files.write(filePath1, lines, 
				StandardCharsets.UTF_8,
				new OpenOption[]{StandardOpenOption.WRITE,
				StandardOpenOption.CREATE_NEW});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
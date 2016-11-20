import java.io.*;
import java.io.IOException;
import java.nio.file.*;

public class TestClass {
	public static void main(String...args) {
		Path p1 = Paths.get("files/a.txt");
		createIfNotExists(p1);
		Path absolute = Paths.get(p1.toFile().getAbsolutePath());

		Path p2 = absolute.resolveSibling("b.txt");
		System.out.println(p2);
		
		try (BufferedReader br = new BufferedReader(new FileReader(p1.toFile()));
			BufferedWriter bw = new BufferedWriter(new FileWriter(p2.toFile()));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		
		} catch (IOException e) {e.printStackTrace();}
	}

	public static void  createIfNotExists(Path p) {
		if (Files.exists(p))
			return;
		try {Files.createFile(p);} catch (IOException e) {e.printStackTrace();}
	}
}

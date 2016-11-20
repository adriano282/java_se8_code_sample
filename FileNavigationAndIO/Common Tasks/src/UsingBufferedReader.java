import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class UsingBufferedReader {
	public static void readFile() throws IOException {
		
		if (!CreatorAFile.existsFile()) {
			System.out.println("Doesn't exist a file!");
			return;
		}

		BufferedReader br = new BufferedReader(UsingFileReader.fr);
		
		String line = "";
		
	 	// throws IOException
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		// throws IOException
		br.close();
	}
	public static void main(String...args) throws IOException {
		readFile();
	}
}

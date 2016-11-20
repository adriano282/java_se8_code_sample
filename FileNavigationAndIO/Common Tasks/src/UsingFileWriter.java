import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class UsingFileWriter {
	public static FileWriter fileWriter;
	static {
		try {
			fileWriter = new FileWriter("FILE.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeOnFile(String[] texts)  throws IOException {

		int lengthLine = 0;
		for (int i = 0; i < texts.length; i++) {
			fileWriter.write(texts[i] + " ");
			lengthLine += texts[i].length();

			if (lengthLine == 100) {
				fileWriter.write("\n");
				lengthLine = 0;
			}
		}

		fileWriter.close();
		
	}
	public static void main(String... args) throws IOException {
		
		if (args.length != 0)
			writeOnFile(args);

	}
}

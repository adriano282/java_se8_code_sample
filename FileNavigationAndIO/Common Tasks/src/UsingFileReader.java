import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class UsingFileReader {
	private static char[] in = new char[100];
	public static FileReader fr;
	static {
		// throws FileNotFoundException
		try {
			fr = new FileReader(CreatorAFile.myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileLine() throws IOException {
		int size = fr.read(in);

		System.out.println("Size from file: " + size);

		for (char c : in) {
			System.out.print(c);
		}	

		fr.close();
	}

	public static void main(String... args)throws  IOException {
		readFileLine();		
	}
}

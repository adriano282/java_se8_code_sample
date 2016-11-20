import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class UsingPrintWriter {
	public static void write(String... args) throws IOException {
		
		if (!CreatorAFile.existsFile()) {
			System.out.println("Doesn't exist a file");
			return;
		}
		//throws FileNotFoundException
		// This constructor is for do not erase the content
		// of already created file
		PrintWriter pw = 
			new PrintWriter(
				new BufferedWriter(
					UsingFileWriter.fileWriter));
		
		for (String s : args) {
			pw.println(s);
		}
		
		if (args.length > 0) {
			System.out.println("File writen successufuly");
		}

		pw.flush();
		pw.close();
	}
	
	public static void main(String... args) throws IOException {
		write(args);
	}
}

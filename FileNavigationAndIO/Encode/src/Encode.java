import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;

public class Encode {
	public static void main(String...args) {

		Path myDir = Paths.get("content");
		try {
			//throws IO Exception here:

			if (!Files.exists(myDir))
				Files.createDirectory(myDir);	
		
		

			Path file = Paths.get("content/utf8.txt");

			//throws IO Exception here:
			if (!Files.exists(file))
				Files.createFile(file);

			//throws FileNotFoundException here
			FileOutputStream fos = new FileOutputStream(file.toFile());
			OutputStreamWriter osw 
				= new OutputStreamWriter(fos, Charset.forName("UTF-8").newEncoder());
			BufferedWriter bw = new BufferedWriter(osw);

			//throws IO Exception here:
			bw.newLine();
			//throws IO Exception here:
			bw.write("Você ira realizar um çççççççãããããããã~aããã");

			//throws IO Exception here:
			bw.flush();
			//throws IO Exception here:
			bw.close();

		} catch (IOException e) { e.printStackTrace();}
	}
}

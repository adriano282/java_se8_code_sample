import java.io.*;
import java.nio.file.*;

public class TestClass {
	public static void main(String...args) {

		Path f = Paths.get("file.txt");
		
		try (BufferedWriter bw = Files.newBufferedWriter(f)) {
			for (char c = 'A'; c <= 'Z'; c++) {
				bw.write(c);
				bw.newLine();
			}
			

		} catch (IOException e) {e.printStackTrace();}

		try (Reader r = new BufferedReader(new FileReader("file.txt"))) {
			if (r.markSupported()) {
				BufferedReader in = (BufferedReader) r;
								System.out.println(in.readLine());
				in.mark(2);
				in.reset();
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				in.reset();
				System.out.println(in.readLine());
				in.reset();
				System.out.println(in.readLine());
				in.reset();
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				String s = "";
				while ((s = in.readLine()) != null) {
					if (s.equals("V")) in.reset();
					System.out.println(s);	
				}

			}
		} catch (IOException e) {e.printStackTrace();}
	}
}
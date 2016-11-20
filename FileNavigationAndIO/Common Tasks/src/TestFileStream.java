import java.io.*;

public class TestFileStream {
	public static void main(String... args) {
		try (FileInputStream fis = new FileInputStream("content/file.txt");
			InputStreamReader isr = new InputStreamReader(fis)) {

			while(isr.ready()) {
				//isr.skip(1);
				char[] res = new char[100];
				int i = isr.read(res, 1, 4);
				System.out.println(i);
				System.out.println(res);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
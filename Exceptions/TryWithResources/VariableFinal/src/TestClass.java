import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestClass {
	public static void copy(String record1, String record2) {

		try (InputStream is = new FileInputStream(record1);
		OutputStream os = new FileOutputStream(record2);) {
		//	os = new FileOutputStream("default.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String...args) {
		
	}
}

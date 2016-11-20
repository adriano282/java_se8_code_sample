import java.nio.file.*;
import java.io.File;

public class ListD {
	public static void main(String... args) {
		File[] roots = File.listRoots();
		
		for (File f : roots) {
			System.out.println(f);
		}
	}
}

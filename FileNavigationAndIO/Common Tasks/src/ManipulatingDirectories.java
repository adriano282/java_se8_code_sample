import java.io.IOException;
import java.io.File;

public class ManipulatingDirectories {
	public static File myDir;
	static {
		//Create a object for a directory
		myDir = new File("content/myDirA/A/B/C/D");
	}
	
	public static void mkdir() {
		System.out.println("Creating a directory myDirA");
		myDir.mkdirs();
		System.out.println("directory created");
	}
	public static void mkdirs(String s) {
		System.out.format("Creating directories: %s%n", s);
		myDir.mkdirs();
		System.out.println("directories created");
	}


	public static void listDirectory(String path) {
		File search = new File(path);
		String[] files = new String[100];
		
		files = search.list();

		for (String s : files) {
			System.out.println("found " + s);
		}

		File[] fs = search.listFiles();

		for (File f : fs) {
			System.out.println("founf " + f);
		}
	}
	
	

	public static void main(String...args) {
		mkdirs("content/myDirA/A/B/C/D");
		listDirectory("bin/");
	}
}

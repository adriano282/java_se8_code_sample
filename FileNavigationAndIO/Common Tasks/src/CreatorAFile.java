import java.io.File;
import java.io.IOException;

public class CreatorAFile {
	public static File myFile = new File("content/file.txt");

	public static boolean createFile() throws IOException {		
		myFile = new File("content/fileA.txt");

		if (existsFile())
			deleteFile();

	        System.out.println("Creating a new file: file.createNewFile()");
		
		if (!myFile.createNewFile()) {
			System.out.println("Ought! Got a fucking error!");
			return false;
		}

		System.out.println("File has been created successufuly");
		return true;
	}

	public static boolean existsFile() {
                if (myFile.exists()) {
                        System.out.println("The file 'file.txt' already exist");
			return true;
                }
		return false;
	}

	public  static boolean deleteFile() {
		System.out.println("Trying removing file: file.delete()");
                
		if (!myFile.delete()) {
			System.out.println("Ought!! Got a error!");
			return false;
		}
				
                System.out.println("File has been deleted");
		return true;
	}
	
	public static void main(String... args) throws IOException {
		createFile();
	}

}

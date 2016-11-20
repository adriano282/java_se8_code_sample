import java.io.Console;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class FindFile {
	public static int totalFound = 0;
	public static void main(String...args) {
		String fileName;

		// Getting the console by System.console();
		// Does not throw any exception
		Console console = System.console();

		while(true) {
			fileName = console.readLine("%s", "Digite o nome do arquivo ou zero para cancelar. ");
			if (fileName != null & !fileName.equals("")) break;
			if (fileName != null & fileName.equals("0")) getOut();
		}
		
		Visitor finder = new Visitor(fileName);
		try {
			Files.walkFileTree(Paths.get("../"), finder);
		} catch (IOException e) {e.printStackTrace();}
		System.out.println("Were find " + totalFound + " files.");
	}

	private static class Visitor extends SimpleFileVisitor<Path> {
		private String nameToFind;
		public Visitor(String nameToFind) {this.nameToFind = nameToFind;}

		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			if (file.toString().toUpperCase().contains(nameToFind.toUpperCase()) && !file.toString().endsWith(".class")) {
				found(file);
				copy(file);
			}
			return FileVisitResult.CONTINUE;
		}

		private void found(Path file) {
			System.out.println("file found at" + file);
			totalFound++;
		}
		
		private void copy(Path file) {
			Path dir = createDirectory();

//			System.out.println("copying file found to " + dir);
			
			try {
				Files.copy(file, Paths.get("Files Found/" + file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}


			System.out.println("file has been copied successufuly");
		}

		private Path createDirectory() {
			Path directory = Paths.get("Files Found");
			
			try {
	
				if (!Files.exists(directory))
					Files.createDirectory(directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return directory;
		}


	}
		
	static	private void  getOut() { 
		System.out.println("\nOperation canceled!");
		System.out.println("Get out of the program");
		System.exit(-1);
	}
}

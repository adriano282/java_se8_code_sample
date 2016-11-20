import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;

public class MovingPaths {
	public static void main(String... args) {
		Path source = Paths.get("content/A.txt");
		Path target = Paths.get("content"); // Doesn't Exist yet
		
//		if (!createIfDoesntExist(source))
//			System.exit(-1);

		showPath(target);
		verifyExists(target);

		copyPath(source, target);
		verifyExists(target);
		
//		isSameFile(source, target);

		showDetailsPath(source);
		showDetailsPath(target);
		
	}
	public static void isSameFile(Path from, Path to) {
		write("Is same file?: " + from + " == " + to);
		try {
			write("Resul: " + Files.isSameFile(from, to));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static boolean createIfDoesntExist(Path path) {
		boolean isFile = !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS);
		if (!verifyExists(path))
			return justCreate(path, isFile);
		
		return true;		
	}

	public static boolean justCreate(Path path, boolean isFile) {
			
		try {
			if (isFile) {
				write("Creating the file...");
				// trhows checked Exception
				Files.createFile(path);
				write("File has been created!!\n");
				return true;
			}

			write("Creating the folder...");
		
			// throws checked Exception
			Files.createDirectory(path);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		write("Folder has been created !!!!\n");
		return true;
	}

	public static boolean  verifyExists(Path path) {
		boolean exist = Files.exists(path);
                write(path + " exists?: " + exist + "\n");
		return exist;
	}

	public static void showPath(Path path) {
		write("Show Path: " + path + "\n");
	}
	public static void showDetailsPath(Path path) {
		write("\nShowing the details from path: " + path);
		write("getFileName: " + path.getFileName());
		write("getName(1): " + path.getName(1));
		write("getNameCount: " + path.getNameCount());
		write("getParent: " + path.getParent());
		write("getRoot: " + path.getRoot());
		write("subpath(0, 2): " + path.subpath(0, 2));
		write("soString: " + path.toString());
		
		try {
			BasicFileAttributes basic = Files.readAttributes(path,
				BasicFileAttributes.class);
			write("create: " + basic.creationTime());
			write("access: " + basic.lastAccessTime());
			write("modify: " + basic.lastModifiedTime());
			write("directory: " + basic.isDirectory());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		write("-----------------------------------------");
	}

	public static void copyPath(Path from, Path to) {
		write("Copying path from " + from + " to " + to);
			
		//throws Checked Exception IO Exception
		try {
			Files.copy(from, to);
//			StandardCopyOption.REPLACE_EXISTING, 				StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		write("Done!\n");
		
	}

	public static void movePath(Path from, Path to) {
		write("moving path from " + from + " to " + to);
			
		//throws Checked Exception IO Exception
		try {
			Files.move(from, to, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		write("Done!\n");
		
	}

	public static void write(String message) {
		System.out.println(message);
	}
}

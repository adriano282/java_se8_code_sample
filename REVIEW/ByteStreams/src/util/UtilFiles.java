package util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class UtilFiles {
	public static boolean createIfNotExists(String fileName) {
		return createIfNotExists(Paths.get(fileName));
	}
	public static boolean createIfNotExists(Path path) {
		if (Files.exists(path))
			return false;

		try {
			Files.createFile(path);
			return true;
		}
		catch (IOException e) {
			System.err.println("Creation file failed.\n StackTrace: " + e.toString());
			return false;
		}
	}

	public static void getFileName(Path path) {
		System.out.format("getFileName: %s%n", path.getFileName());
	}	

	public static void normalize(Path path) {
		System.out.format("normalize: %s%n", path.normalize());
	}

	public static void toRealPath(Path path) {
		System.out.format("%s: toRealPath.%n", path);
                if (!fileExist(path))
                        System.out.format("Therefore, it will throw a Checked Exception:%n");

                try {System.out.format("After: %s%n", path.toRealPath());}
                catch (IOException e) {System.err.format("%s: %s%n", path, e);}
	}

	public static void toAbsolutePath(Path path) {
		System.out.format("Before: %s%n", path);
		System.out.format("Absolute: %s%n", path.toAbsolutePath());
	}

	public static boolean fileExist(Path path) {
		boolean exist = Files.exists(path);
		System.out.format("Does file %s exist? %s%n", path, exist);
		return exist;
	}
	
	public static void relativize(Path from, Path to) {
		System.out.format("%nRelativise Method: from.relativize(to)%nFrom: %s%nTo: %s%n%n", from, to);
		System.out.format("@@@Warnig:%n ---> If one them is a root path, it will throw a Unchecked Exception IllegalArgumentException%n");
		System.out.format(" ---> Both root OK, but only one NOT%n");
		System.out.format("Result: %s%n", from.relativize(to));
	}
}


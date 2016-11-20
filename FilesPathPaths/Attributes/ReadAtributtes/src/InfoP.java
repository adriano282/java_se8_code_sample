import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import static java.time.ZoneId.SHORT_IDS;

class InfoP {
	public static void main(String... args) throws IOException {

		
		Path path = Paths.get("files/file.txt");
		System.out.println("Path: " + path + "\n");
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("getName(1): " + path.getName(1));
		System.out.println("getNameCount: " + path.getNameCount());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getRoot: " + path.getRoot());
		System.out.println("subpath(0, 2): " + path.subpath(0, 2));
		System.out.println("toString: " + path.toString());

		System.out.println("\n\nFrom BasicFileAttribures:\n");
		BasicFileAttributes basic = Files.readAttributes(path,
			BasicFileAttributes.class);
		System.out.println("create: " + basic.creationTime());
		System.out.println("fileKey(): " + basic.fileKey());
		System.out.println("access: " + 
		Instant.parse(basic.lastAccessTime().toString()).atZone(ZoneId.of("BET", SHORT_IDS)));
		System.out.println("modify: " + basic.lastModifiedTime());
		System.out.println("directory: " + basic.isDirectory());
		System.out.println("isOther(): " + basic.isOther());
		System.out.println("isRegularFile(): " + basic.isRegularFile());
		System.out.println("isSymbolicLink(): " + basic.isSymbolicLink());
		System.out.println("size(): " + basic.size());

		System.out.println("\n\nFrom PosixFileAttributes:\n");
		PosixFileAttributes attrs = 
			Files.getFileAttributeView(path, PosixFileAttributeView.class)
				.readAttributes();

		System.out.println("owner().getName(): " + attrs.owner().getName());
		System.out.println("group().getName(): " + attrs.group().getName());
		System.out.println("permissions(): ");
		attrs.permissions().forEach(System.out::println);

	}
}

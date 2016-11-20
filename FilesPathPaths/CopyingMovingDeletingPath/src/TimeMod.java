import java.time.LocalDate;
import java.nio.file.*;
import java.time.Month;
import java.nio.file.attribute.FileTime;
import java.io.*;

class TimeMod {
	public static void main(String...args) throws IOException {
		LocalDate date = LocalDate.of(2013, Month.JANUARY, 1);
		
		Path path = Paths.get("./fileWrite1.txt");
		Files.createFile(path);
		FileTime fileTime = FileTime.fromMillis(date);
		Files.setLastModifiedTime(path, fileTime);
		System.out.println(Files.getLastModifiedTime(path));
		Files.delete(path);
		
	}
}


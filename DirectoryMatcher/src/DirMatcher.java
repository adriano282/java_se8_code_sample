import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

class DirMatcher {
	public static void main(String... args) {
		Path path1 = Paths.get("0*b/test/1");
		Path path2 = Paths.get("9*b/test/1");
		System.out.println(path2.toString());
		Path path3 = Paths.get("19*Adriano/test/1");
		Path path4 = Paths.get("0*b/1");

		String glob = "glob:[0-9]\\*{A*,b}/**/1";
		System.out.format("format: %s%n%n", glob);
		matches(path1, glob);
		matches(path2, glob);
		matches(path3, glob);
		matches(path4, glob);
	}

	public static void matches(Path path, String glob) {
		PathMatcher m = FileSystems.getDefault().getPathMatcher(glob);

		System.out.format("(%s)%n(%s) %n%s%n%n", path, glob, m.matches(path));
	}
}

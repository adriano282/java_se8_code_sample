import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.net.URI;

class Directory {
	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault().getPath("/.");
		Iterable<Path> roots = fs.getRootDirectories();
		
		for (Path p : roots) {
			System.out.println(p);
		}

	}
}

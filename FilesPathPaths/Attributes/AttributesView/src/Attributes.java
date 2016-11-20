import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.io.IOException;

public class Attributes {
	public static void main(String...args) throws IOException {
		Path path = Paths.get("../Files Resources");
		Files.createFile(path);
		Files.setAttribute(path, "dos:hidden", true);
		Files.setAttribute(path, "dos:readonly", true);
		DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);

		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		Files.setAttribute(path, "dos:hidden", false);
		Files.setAttribute(path, "dos:readonly", false);

		dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		Files.delete(path);
	}
}
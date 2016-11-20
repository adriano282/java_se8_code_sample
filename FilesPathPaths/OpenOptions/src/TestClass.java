import java.nio.file.attribute.UserPrincipal;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import static java.nio.file.StandardOpenOption.*;

public class TestClass {
	public static void main(String...args) {
		
			Path file = Paths.get("files/file.txt");
			triesWrite(file);
			triesRead(file);
	}

	public static void triesRead(Path file) {
		try {
			BufferedReader br = Files.newBufferedReader(file, 
				Charset.forName("UTF-8"));

			String line;

			while ((line = br.readLine()) != null) {
				write(line);
			}
			br.close();
			write("done");
		} catch (IOException e) {e.printStackTrace();}

	}
	public static void triesWrite(Path file) {
		try {
//                    try {createIfNotExists(file, true);}
//                      catch (IOException e) {throw new RuntimeException(e);}

                        //throws IOException
//                      UserPrincipal up = file.getFileSystem()
//                                              .getUserPrincipalLookupService()
//                                              .lookupPrincipalByName("adriano");
                        //throws IOException
//                      Files.setOwner(file, up);

                        //throws IOException
                        BufferedWriter br = Files.newBufferedWriter(file,
                                        Charset.forName("UTF-8"),
                                        new OpenOption[] { 
// It does not compile: will throw a IllegalArgumentException
//                                         			CREATE, READ
// If file already exists, it will throw a java.nio.file.FileAlreadyExistsException:                                        	
//                                                TRUNCATE_EXISTING, CREATE_NEW 
// Even so the file already exists, it will compile:
//                                                TRUNCATE_EXISTING, CREATE // Compile


                                        });

                        //throws IOException
                        br.write("This text file is created using Path API");
                        br.close();



                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                write("done");


	}

	public static void createIfNotExists(Path path, boolean isFile) throws IOException {
		if (Files.exists(path))
			return;
		
		if (isFile) {
			Files.createFile(path);
			write("File created");
			checkFile(path);
			return;
		}

		write(path.toFile().isFile());
		Files.createDirectory(path);
		write("Directory created");
	}

	public static boolean checkFile(Path path) {
		if (!Files.isRegularFile(path))
			return false;
		write("It is a regular File");

		if (Files.isReadable(path))
			return false;
		write("It is readable file");

		if (Files.isExecutable(path))
			return false;
		write("It is executable file");

		if (Files.isWritable(path))
			return false;
		write("It is a writable file");

		return true;
	}

	public static void write(String txt) {
		System.out.println(txt);
	}

	public static void write(Object obj) {
		System.out.println(obj.toString());
	}
}

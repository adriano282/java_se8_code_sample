import java.nio.file.*;
import java.nio.*;
import java.io.*;
class FooRunnable implements Runnable  {

	public void run() {

		try {
			Path file = Paths.get("secondThread.txt");

			if (!Files.exists(file))
				Files.createFile(file);

			PrintWriter pw = new PrintWriter(new FileWriter(file.toFile()));
			for (int x = 1; x < 1000000; x++) {
				pw.println("Runnable running---------------");	
			}
			pw.close();	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

public class TestThread {
	public static void main(String... args) throws IOException {
		FooRunnable r = new FooRunnable();
		Thread t = new Thread(r);
		t.start();
		Path file = Paths.get("secondThread.txt");
		
		if (!Files.exists(file))
				Files.createFile(file);

		PrintWriter pw = new PrintWriter(new FileWriter(file.toFile()));

		for (int x = 0; x < 1000000; x++) {
			pw.println("Main thread running");
		}
		pw.close();
	}
}
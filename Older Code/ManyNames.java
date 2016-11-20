import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.PrintWriter;
import java.io.IOException;

class NameRunnable implements Runnable {
	public void run() {

		try {
			Path file = Paths.get("manyNames.txt");

			PrintWriter pw = new PrintWriter(file.toFile());

			for (int x = 0; x < 400; x++) {
				pw.println("Run by " 
				+ Thread.currentThread().getName()
				+ ", x is " + x);	
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("handled exception");
			
		}

		
	}
}

public class ManyNames {
	public static void main(String... args) throws IOException {

		Path file = Paths.get("manyNames.txt");

		if (Files.exists(file))
			Files.delete(file);

		Files.createFile(file);
		System.out.println("File has been created few secs ago.");
		
		NameRunnable nr = new NameRunnable();
		Thread one = new Thread(nr);
		Thread two = new Thread(nr);
		Thread three = new Thread(nr);

		one.setName("Gabriel--------------------------------->");
		two.setName("Carmelita###############################>");
		three.setName("Adriano de Jesus@@@@@@@@@@@@@@@@@@@@@@>");
		one.start();
		two.start();
		three.start();


	}
}
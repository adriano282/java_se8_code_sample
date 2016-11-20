import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.nio.file.attribute.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

class WatchService1 {
	public static String currentAction;
	public static String currentItem;

	public static boolean  write(Path file, String message) {
		try (FileWriter fw = new FileWriter(file.toString(), true); PrintWriter pw = new PrintWriter(fw)) {
                	pw.println(message);
			System.out.println("Escreveu no arquivo");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String...args) throws IOException  {
		Path dir = Paths.get("./searchThis");
		WatchService watcher = FileSystems.getDefault()
			.newWatchService();
		dir.register(watcher, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);
		Path file = Paths.get("log.txt");

		if (!Files.exists(file))
			Files.createFile(file);


		while (true) {
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name());
				System.out.println(kind.type());
				System.out.println(event.context());
				String name = event.context().toString();

				currentItem = name;
				currentAction = kind.name().toString();

				if (currentAction.equals("ENTRY_DELETE")) {
				        write(Paths.get("log.txt"), 
					(file.toFile().isFile() ? "The file " : "The Folder") + 
					name + " was deleted at " + LocalDateTime.now());
				}

			        if (currentAction.equals("ENTRY_CREATE")) {
			                write(Paths.get("log.txt"), 
					(file.toFile().isFile() ? "The file " : "The Folder") + 
					name + " was created at " + LocalDateTime.now());
				}

				System.out.println(file);
			        if (currentAction.equals("ENTRY_MODIFY")) {
			                write(Paths.get("log.txt"), 
					(file.toFile().isFile() ? "The file " : "The Folder") + 
					name + " was modified at " + LocalDateTime.now());
				}

				if (Files.list(dir).toArray().length == 0) {
					System.out.println("Directory empty");
					return;
				}
			}
			key.reset();
		}
	}
}

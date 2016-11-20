import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.nio.file.attribute.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

class WatchService1 extends SimpleFileVisitor<Path> {
	private static String currentItem;
	private static String currentAction;

	        public FileVisitResult postVisitDirectory(Path file,
                        BasicFileAttributes attrs) throws IOException {

                if (file.getFileName().toString().equals(currentItem)) {
                        if (currentAction.equals("ENTRY_DELETE")) {
                                write(Paths.get("log.txt"),
                                (file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was deleted at " + LocalDateTime.now());
                                return FileVisitResult.TERMINATE;
                        }


                        if (currentAction.equals("ENTRY_CREATE")) {
                                write(Paths.get("log.txt"), 
                                (file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was created at " + LocalDateTime.now());
                                return FileVisitResult.TERMINATE;
                        }



                        if (currentAction.equals("ENTRY_MODIFY")) {
                                write(Paths.get("log.txt"), 
                                (file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was modified at " + LocalDateTime.now());
                                return FileVisitResult.TERMINATE;
                        }

                }
                return FileVisitResult.CONTINUE;

        }

	public FileVisitResult preVisitDirectory(Path file,
			BasicFileAttributes attrs) throws IOException {

                if (file.getFileName().toString().equals(currentItem)) {
                        if (currentAction.equals("ENTRY_DELETE")) {
	                        write(Paths.get("log.txt"),
   				(file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was deleted at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}


                        if (currentAction.equals("ENTRY_CREATE")) {
                                write(Paths.get("log.txt"), 
                                (file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was created at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}



                        if (currentAction.equals("ENTRY_MODIFY")) {
                                write(Paths.get("log.txt"), 
                                (file.toFile().isFile() ? "The file " : "The Folder") + 
                                currentItem + " was modified at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}

                }
                return FileVisitResult.CONTINUE;

	}

	public FileVisitResult visitFile(
		Path file, BasicFileAttributes attrs) throws IOException {
		if (file.getFileName().toString().equals(currentItem)) {
				System.out.println("found folder");

	                if (currentAction.equals("ENTRY_DELETE")) {
        	                write(Paths.get("log.txt"), 
				(file.toFile().isFile() ? "The file " : "The Folder") + 
				currentItem + " was deleted at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}

                        if (currentAction.equals("ENTRY_CREATE")) {
                                write(Paths.get("log.txt"), 
				(file.toFile().isFile() ? "The file " : "The Folder") + 
				currentItem + " was created at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}

                        if (currentAction.equals("ENTRY_MODIFY")) {
                                write(Paths.get("log.txt"), 
				(file.toFile().isFile() ? "The file " : "The Folder") + 
				currentItem + " was modified at " + LocalDateTime.now());
				return FileVisitResult.TERMINATE;
			}
		}
		return FileVisitResult.CONTINUE;
	}

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
		Path dir = Paths.get("../searchThis/");
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
				System.out.println(currentAction);

				WatchService1 ws = new WatchService1();
				Files.walkFileTree(dir, ws);

				if (Files.list(dir).toArray().length == 0) {
					System.out.println("Directory empty");
					return;
				}
			}
			key.reset();
		}
	}
}

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;
import java.util.function.BiPredicate;
import java.util.Optional;
import java.io.IOException;
import java.io.Console;

public class TestClass {
	public static void main(String...args) throws IOException {
		Console c = System.console();
		Optional<String> name = Optional.ofNullable(c.readLine("%s", "Digite o nome do arquivo: (ou 0 para cancelar):"));

		if (name.orElseThrow(RuntimeException::new).equals("0")) {
			System.out.println("Operacao cancelada");
			System.exit(0);
		}
		System.out.println(name.get());
		Path path = Paths.get("../../../");
		BiPredicate<Path, BasicFileAttributes> matcher =
			(p, a) -> p.toString().toUpperCase().contains(name.get().toUpperCase()) && a.isRegularFile();
		Stream<Path> s = Files.find(path, Integer.MAX_VALUE, matcher);

		s.forEach(System.out::println);
	}
}

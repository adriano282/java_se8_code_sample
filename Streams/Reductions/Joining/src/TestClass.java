import java.util.stream.Stream;
import java.util.stream.Collectors;
public class TestClass {
	public static void main(String...args) {
		Stream<String> ss = Stream.of("a", "b", "c", "d");
		String str = ss.collect(Collectors.joining(",", "-", "+"));
		System.out.println(str);
	}
}

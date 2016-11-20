import java.util.*;
import java.util.stream.Stream;

public class TestClass {
	public static void main(String...args) {
		String sentence1 = "The beulty from day";
		String sentence2 = "ABSC GSFGf, GSGF kalfdsjf";
		
		List<String> sentences = Arrays.asList(sentence1, sentence2);

		sentences.stream()
			.flatMap(str -> Stream.of(str.split("[ ,.!?\r\n\t]")))
			.filter( s-> s.length() > 0)
			.distinct()
			.forEach(System.out::println);
	}
}

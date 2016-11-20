import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
class TestStream {
	public static void main(String... args) {
		//Stream.iterate(0, n -> n)
			//.limit(10)
		//	.forEach(System.out::println);

		/*List<Integer> list = Stream.iterate(	new int[] {0, 1}, 
						n -> {
							return new int[] {n[0] + n[1], n[1] + n[0] + n[1]};
						})
				.flatMap(t -> Stream.of(t[0], t[1]))
				.			
				.collect(toList());

		System.out.println(list);
		*/

		getFibonacci();


	}

	public static void getFibonacci() {
		IntStream.generate(new IntSupplier() {
			int previous = 0;
			int current = 1;
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		}).limit(10).forEach(System.out::println);
	}
}
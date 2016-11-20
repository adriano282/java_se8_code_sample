import java.util.*;
import static java.util.stream.Collectors.toList;

class Book implements Comparable<Book> {
	private String title;
	private String genre;

	public Book(String title, String genre) {
		this.title = title; this.genre = genre;
	}
	public int compareTo(Book book) {return title.compareTo(book.getTitle());}
	public String getTitle() {return title;}
	public String getGenre() {return genre;}
	public String toString() {return title + ":" + genre;}
}

public class TestClass {
	public static void main(String...args) {
		List<Book> books = Arrays.asList(
			new Book("TA", "GB"),
			new Book("TA", "GC"),
			new Book("TW", "GR"),
			new Book("TD", "GS"),
			new Book("TD", "GA"));

		Comparator<Book> c1 = (b1, b2) -> b1.getTitle().compareTo(b2.getTitle());

		books.stream()
				.sorted()
				.collect(toList())
				.forEach(System.out::println);
				
		//books = books.stream().sorted(c1.thenComparing(Book::getTitle)).collect(toList());

		//books.forEach(System.out::println);
	}
}

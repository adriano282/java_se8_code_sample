import java.util.function.*;
import java.util.*;

class Book {
	private String title;
	private double price;
	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}
	public double getPrice() {return price;}
	public String getTitle() {return title;}
}

public class OptionalTest {
	public static void main(String...args) {
		List<Book> books = 
				Arrays.asList(	new Book("Thinking inJava", 30.0),
								new Book("Java in 24 hrs", 20.0),
								new Book("Java Recipies", 10.0));

		Predicate<Book> filter = b -> b.getPrice() > 50;

		double averagePrice = 
			books.stream()
					.filter(filter)
					.mapToDouble(Book::getPrice)
					.average().getAsDouble();
					

		System.out.println(averagePrice);
	}
}	
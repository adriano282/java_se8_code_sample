import java.text.*;
import java.util.*;

public class FormatterTest {
	public static void main(String...args) {
		Date d = new Date();
		//throw new NumberFormatException();
		System.out.println("DateFormat: LONG");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(df.format(d));
		System.out.println("-----------------\n\n");

		System.out.println("DateFormat: FULL");
		df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("jp", "CA"));
		System.out.println(df.format(d));
		System.out.println("-----------------\n\n");

		System.out.println("DateFormat: MEDIUM");
		df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(df.format(d));
		System.out.println("-----------------\n\n");

		System.out.println("DateFormat: DEFAULT");
		df = DateFormat.getDateInstance(DateFormat.DEFAULT);
		System.out.println(df.format(d));
		System.out.println("-----------------\n\n");

		System.out.println("DateFormat: SHORT");
		df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("en", "US"));
		System.out.println(df.format(d));
		System.out.println("-----------------\n\n");		

	}


}

import static java.time.temporal.TemporalAdjusters.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class TestClass {
	public static void main(String...args) {
		LocalDate date1 = LocalDate.of(2015, 12, 8);
		LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
		LocalDate date3 = date1.with(lastDayOfMonth());

		System.out.println("Today: ");
		System.out.println(date1);

		System.out.println("\n\nNext Sunday");
		System.out.println(date2);

		System.out.println("\n\nLast Day Of Month");
		System.out.println(date3);
	}
}

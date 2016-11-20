import java.time.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SecondExample {
	public static void main(String...args) {
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.MARCH, 8, 2, 0);
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		System.out.println("Time 1: " + zd1);

		LocalDateTime ld2 = LocalDateTime.of(2015, Month.MARCH, 8, 3, 0);
		ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
		System.out.println("Time 2: " + zd2);

		long x = ChronoUnit.HOURS.between(zd1, zd2);
		System.out.println(x);
	}
}

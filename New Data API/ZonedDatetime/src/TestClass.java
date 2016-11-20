import java.time.*;
import java.time.temporal.ChronoUnit;

public class TestClass {
	public static void main(String...args) {
		//Given: Daylight Savings Time ends on Nov 1 at 2 AM in 
		// US/Eastern time zone. As a result, 2 AM becomes 1 AM.
		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Duration.ofDays(1));
		System.out.println(date);

		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Period.ofDays(1));
		System.out.println(date);


		//Given that daylight Savings Time ends on Nov 1 at 2 AM in US/Eastern time zone. 
		//(As a result, 2 AM becomes 1 AM.), what will the following code 
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		System.out.format("Date: %s%n", ld1);
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		System.out.format("Zoned Date: %s%n%n", zd1);

		LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		System.out.format("Date: %s%n%n", ld2);
		ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
		System.out.format("Zoned Date: %s%n", zd1);

		long x = ChronoUnit.HOURS.between(zd1, zd2);
		System.out.println(x);

	}
	
}
import java.time.temporal.ChronoUnit;
import java.time.Instant;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TestClass {
	public static void main(String...args) {
		Instant start = Instant.parse("2015-06-25T16:13:30.00z");
		start.plus(10, ChronoUnit.HOURS);
		
		System.out.println(start);

		Duration timeToCook = Duration.ofHours(1);
		Instant readyTime = start.plus(timeToCook);
		System.out.println(readyTime);

		LocalDateTime ltd = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));

		System.out.println(ltd);
		
		System.out.println("\n\nInstant.ofEpochSecond(3)");
		System.out.println(Instant.ofEpochSecond(3));

                System.out.println("\n\nInstant.ofEpochSecond(3)");
		System.out.println(Instant.ofEpochSecond(3, 0));
		
                System.out.println("\n\nInstant.ofEpochSecond(2, 1_000_000_000)");
                System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));

		
                System.out.println("\n\nInstant.ofEpochSecond(4,-1_000_000_000)");
                System.out.println(Instant.ofEpochSecond(4, -1_000_000_000));

		


		
	}
}

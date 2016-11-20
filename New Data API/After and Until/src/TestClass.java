import java.time.*;
import java.time.temporal.ChronoUnit;
public class TestClass {
	public static void main(String...args) {
		LocalTime now = LocalTime.now();
		LocalTime gameStart = LocalTime.now().plus(Duration.ofMinutes(45));
		System.out.println(gameStart);
		long timeConsumed = 0;
		long timeToStart = 0;
		if (now.isAfter(gameStart)) {
			timeConsumed = gameStart.until(now, ChronoUnit.HOURS);
		} else {
			timeToStart = now.until(gameStart, ChronoUnit.HOURS);
		}
		System.out.println(ChronoUnit.MINUTES.between(now, gameStart));

		System.out.format("timeConsume: %s, timeToStart: %s", timeConsumed, timeToStart);
	}
}
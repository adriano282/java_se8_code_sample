import java.time.*;
import java.time.format.*;
import java.util.Locale;
import java.time.temporal.ChronoField;

public class TestClass {
	public static void main(String...args) {
		Locale localeBrazil = new Locale("pt", "BR");
		LocalDate date = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
			"dd/MM/yyyy", localeBrazil);

		String s1 = date.format(formatter);
		String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.format("BASIC_ISO_DATE: %s%n", s1);
		System.out.format("ISO_LOCAL_DATE: %s%n", s2);
		

		/**
			Taking zone for Brazil
		**/
		LocalDateTime dateTime = LocalDateTime.now();
		ZoneId spZone = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime zdt = dateTime.atZone(spZone);

		System.out.format("%n%nWithout zone: %s%n", dateTime);
		System.out.format("With zone: %s%n", zdt);
		


		/**
			Building a DateTimeFormatter:
		**/
		DateTimeFormatter fmt = new DateTimeFormatterBuilder()
			.appendText(ChronoField.DAY_OF_MONTH)
			.appendLiteral("/")
			.appendText(ChronoField.MONTH_OF_YEAR)
			.appendLiteral("/")
			.appendText(ChronoField.YEAR)
			.parseCaseInsensitive()
			.toFormatter(new Locale("pt", "br"));
		
		System.out.format("%n%nDate: %s%n", date.format(fmt));
		
	}
}

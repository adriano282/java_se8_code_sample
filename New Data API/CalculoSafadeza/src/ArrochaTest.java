// JAVA 8
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class ArrochaTest {
	public static void main(String...args) {
		LocalDate bornDate = LocalDate.of(1994, Month.FEBRUARY, 25);
		wesleySafadao(bornDate);
	}

	private static void wesleySafadao(LocalDate bornDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int sum = sumMonths(bornDate.getMonth().getValue());

 		double safadeza = (sum + bornDate.getYear()q1 * (50 - bornDate.getDayOfMonth()))/100;
 		System.out.print(safadeza);
		double anger = 100 - safadeza;

		System.out.println("Resultado");
		System.out.println("---------");

		System.out.println("Date Nascimento: " + bornDate.format(formatter));
		System.out.printf("Safadeza: %1$.2f%%\n", safadeza);
		System.out.printf("Anjo: %1$.2f%%\n", anger);
	}

	private static int sumMonths(int n) {
		return IntStream.rangeClosed(0, n)
				.reduce(Integer::sum).orElse(0);
	}
}

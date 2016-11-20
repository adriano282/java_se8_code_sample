import java.time.*;

public class TestClass {
	public static void main(String...args) {
		Duration d = 
			Duration.between(LocalDateTime.now(), 
				LocalDateTime.now().minus(Period.ofDays(1)));
		System.out.println(d);
//		System.out.format("Seconds: %s", d.toMillis());

		d = Duration.between(LocalDateTime.now().minus(Period.ofDays(1)),
					LocalDateTime.now());
		System.out.println(d);
		
		System.out.println("between(maior, menor):");
		Period p = Period.between(LocalDate.now(),
		                 LocalDate.now().minus(Period.ofDays(1)));
                System.out.println(p);

		System.out.println("between(menor, maior):");
		p = Period.between(LocalDate.now().minus(Period.ofDays(1)),
				LocalDate.now());

		System.out.println(p);

		
	}
}

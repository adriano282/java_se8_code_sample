import java.util.ResourceBundle;
import java.util.Locale;

class InheritLocale {
	public static void main(String... args) {
		Locale locale = new Locale("en", "UK");
		ResourceBundle rb = ResourceBundle.getBundle("TESTE", locale);
		System.out.println(rb.getString("ride.in") + 
			rb.getString("elevator"));
	}
}

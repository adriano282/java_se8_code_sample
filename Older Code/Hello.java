import java.util.Locale;
import java.util.ResourceBundle;

class Hello {
	public static void main(String ... args) {
		Locale locale = new Locale("CA");
		ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
		System.out.println(rb.getObject(args[0]));
	}
}

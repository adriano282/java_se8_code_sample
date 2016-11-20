import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
public class Labels_en_CA extends ListResourceBundle{
	protected Object[] [] getContents() {
		return new Object[][] {
			{"hello", new StringBuilder("from java").toString()} ,
			{"hello2", new StringBuilder("from java2").toString()}
		};
	}

	public static void main(String...args) {
		Locale locale = new Locale("en", "CA");
		ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
		System. out.println(rb.getString("hello"));
	}
}

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Enumeration;
public class TestClass {
	public static void main(String...args) {
		//Locale.setDefault(new Locale("fr", "CA"));
		Locale l = new Locale("jp", "JP");
		ResourceBundle rb = ResourceBundle.getBundle("messages", l);
		//String msg = rb.getString("greetings");
		//System.out.println(msg);

		Enumeration<String> en = rb.getKeys();
                while(en.hasMoreElements()) {
                        String key = en.nextElement().toString();
                        String val = rb.getObject(key).toString();
                        System.out.println(key + "=" + val);
        }
	}
}
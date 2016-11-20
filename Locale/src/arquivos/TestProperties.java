import java.util.*;

public class TestProperties {
	public static void main(String...args) {
		Locale.setDefault(new Locale("en", "CA"));
		printAllContent(new Locale("pt", "CA"));

	/*	Locale myLoc = new Locale.Builder()
					.setLanguage("pt")
					.setRegion("IN").build();
		printAllContent(myLoc);
	*/
	}

	public static void printAllContent(Locale loc) {
		System.out.println("Default Locale: " + Locale.getDefault());
		System.out.println("Using locale: " + loc + "\n\n");
                ResourceBundle msgs = ResourceBundle.getBundle("messages", loc);
               /* Enumeration<String> en = msgs.getKeys();
                while(en.hasMoreElements()) {
                        String key = en.nextElement().toString();
                        String val = msgs.getObject(key).toString();
                        System.out.println(key + "=" + val);
                }*/
                System.out.println(msgs.getString("test"));
                //System.out.println(msgs.getString("#Comentario"));
	}
}

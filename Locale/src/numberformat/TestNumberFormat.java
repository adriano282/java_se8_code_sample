package numberformat;

import java.util.Locale;
import java.text.NumberFormat;

public class TestNumberFormat {
	public static void main(String...args) {
		float f1 = 123.4567f;
		Locale locFR = new Locale("fr");
		Locale locBR = new Locale("br");
		NumberFormat[] nfa = new NumberFormat[6];
	
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(locFR);
		nfa[2] = NumberFormat.getInstance(locBR);
		nfa[3] = NumberFormat.getCurrencyInstance();
		nfa[4] = NumberFormat.getCurrencyInstance(locFR);
		nfa[5] = NumberFormat.getCurrencyInstance(locBR);
		
		for (NumberFormat nf : nfa)
			System.out.println(nf.format(f1));

		
	}
}

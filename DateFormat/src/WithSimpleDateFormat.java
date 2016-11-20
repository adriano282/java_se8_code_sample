import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithSimpleDateFormat {
	public static void main(String...args) {
		SimpleDateFormat sdf = new SimpleDateFormat("G E  D MM/yy", Locale.US);
		System.out.println(sdf.format(new Date()));

	}
}

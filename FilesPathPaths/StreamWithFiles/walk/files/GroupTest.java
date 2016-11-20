import java.util.regex.*;
import static java.lang.System.*;

class GroupTest {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		
		out.println(m.matches());
		
		out.println("\nsource: " + args[1]);
		out.println(" index:  + 0123456789012345678\n");
		out.println("pattern: " + m.pattern());
		
		while (m.find()) {
			out.println(m.start() + " " + m.group() + " " + m.end());
		}
		out.println("");
	}
}

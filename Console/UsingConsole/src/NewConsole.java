
import java.io.Console;

public class NewConsole {
	public static void main(String... args) {
		String name = "";
		Console c = System.console();
		name = c.readLine("%s", "input?:");
		System.out.println(name);
		
		/*
		int[] Integer = {1, 4, 4};
		System.out.println(Integer);		
		System.out.println("ints " + Integer); */


		char[] pw = c.readPassword("%s", "pw: ");
		System.out.println("password" + pw);
		System.out.println(pw);

		char[] chars = {'a', 'b', 'c'};

		System.out.println(chars);
		System.out.println("chars" + chars);

//		for (char ch : pw) {
//			c.format("%c", ch);
//		}
//		System.out.println(pw);
		
		c.format("\n");
		
		while(true) {
			name = c.readLine("%s", "input?:");
			c.format("output %s \n ", name);
		}

	}
}

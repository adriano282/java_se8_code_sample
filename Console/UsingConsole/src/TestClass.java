import java.io.Console;
public class TestClass {
	public static void main(String...args) {
		Console c = System.console();
		String id = c.readLine("%s", "Enter UserId:");
		System.out.println("user is " + id);
		char[]  pwd = c.readPassword("%s", "Enter Password :");
		System.out.println("password is " + pwd);
	}
}

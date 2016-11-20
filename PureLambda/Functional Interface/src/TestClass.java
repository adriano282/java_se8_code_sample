interface Test {
	static void read() {};
	void unread();
}
interface Abs {
	void read();
}

public class TestClass {
	public static void main(String...args) {
		Test t = () -> System.out.println("WORKS");

		t.read();
	}
	
}
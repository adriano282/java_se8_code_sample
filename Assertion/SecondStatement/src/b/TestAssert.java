package b;

public class TestAssert {
	public static void assertTest(Object obj) {
		assert isEmpty() : new NullPointerException();
	}
	public static void main(String...args) {
		assertTest(null);
	}
	public static boolean isEmpty() {return false;}
}


import b.TestAssert;

public class SecondArg {
	private static void assertTest(Object obj) {
		assert isEmpty() : new NullPointerException();
	}
	public static void main(String...args) {
//		assertTest(null);
//		TestAssert.assertTest(null);
		A.assertTest();

	}
	public static boolean isEmpty() {return false;}
}
class A {
	public static void assertTest() {
		assert false : null;
	}
}

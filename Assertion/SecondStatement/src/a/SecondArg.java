
package a;
import b.TestAssert;

public class SecondArg extends A {
	public void Test() throws Error {

	}
	private static void assertTest(Object obj) {
		try {
			assert isEmpty() : new NullPointerException();
		} catch (AssertionError e) {
			System.out.println("catch");
		}
		
	}
	public static void main(String...args) {
		assertTest(null);
		TestAssert.assertTest(null);
		A.assertTest();

	}
	public static boolean isEmpty() {return false;}
}
class A {
	public void Test() throws AssertionError {

	}
	public static void assertTest() {
		assert false : null;
	}
}

public class TestClass {
	public static void main(String...args) {
		try {
			throw new RuntimeException("from try catch block")
		} catch (RuntimeException e) {
			throw e;
		} finally {
			throw new RuntimeException("from finally block");
		}
	}
}
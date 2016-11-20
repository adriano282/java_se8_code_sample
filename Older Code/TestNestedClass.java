public class TestNestedClass {
	private String x = "outer";
	class MyInner {
		final static String s = "Adriano";
		final public void seeInner() {
			System.out.println(s);
		}
	}

	public static void main(String... args) {
		TestNestedClass.MyInner myInner = new TestNestedClass().new MyInner();
		myInner.seeInner();
		
	}
}

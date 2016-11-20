class ClassTest {
	void print(double x) {
		System.out.println("in double");
	}
	
//	void print(Object x) {
//		System.out.println("In Object");
//	}
	void print(Number x) {
		System.out.println("In Number");
	}
	public static void main(String... args) {
		Double d = 10.0;
		new ClassTest().print(d);
	}
}

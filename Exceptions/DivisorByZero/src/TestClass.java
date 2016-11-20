class TestClass {
	int i = 0;
	public void run() {
		while(true) {
			if (i%0 == 0) System.out.println("Hello World");
		}
	}
	public static void main(String...args) {
		TestClass tc = new TestClass();
		tc.run();
	}
}

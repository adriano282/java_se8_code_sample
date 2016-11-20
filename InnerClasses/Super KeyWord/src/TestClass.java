class A {
	int i = 100;
}
public class TestClass extends A {
	int i =10;
	class A extends TestClass {
		public void print() {
			System.out.println(super.i);
		}
	}

	public void print() {
		System.out.println(super.i);
	}

	public static void main(String...args) {
		new TestClass().new A().print();
		new TestClass().print();
	}
}
public class TestClass {
	public class A {void print() {System.out.println("A");}}
	public static class B {void print() {System.out.println("B");}}
	public void useInstanceClass() {
		A a = new TestClass().new A();
		a.print();

		A a1 = new A();
		a1.print();

		A a2 = new TestClass.A();
		a2.print();

		TestClass.A a3 = new TestClass().new A();
		a3.print();
		
	}
	public void useStaticClass() {
		B b = new B();
		b.print();
		
		B b2 = new TestClass.B();
		b2.print();
		
	}

	
	public static void fromStatic() {
		A a = new TestClass().new A();
		a.print();
		
		TestClass tc = new TestClass();

		A a2 = tc.new A();
		a2.print();
	}
	public static void main(String...args) {
		new TestClass().useInstanceClass();
		new TestClass().useStaticClass();

		fromStatic();

	}
}

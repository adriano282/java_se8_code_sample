interface A {
	public static void print() {
		System.out.println("From interface A");
	}
}
abstract class B {
	public static void print() {
		System.out.println("From abstract class B");
	}
}
class C extends B implements A{
	public static void print() {
		System.out.println("From concrete class C");
	}
}
public class TestClass {
	
	public static void main(String...args) {
		A a = new C();
		B b = new C();
		C c = new C();

		A.print();
		b.print();
		c.print();
	}
}

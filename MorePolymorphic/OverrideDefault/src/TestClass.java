interface A {
	public default void print() {
	}
	public static void print2(){System.out.println("from A");}
}
interface B extends A {
	public default void print2() {System.out.println("from b");}
}
public abstract class TestClass implements A, B {
	public static void main(String...args) {
		System.out.println("OK");
		TestClass tc = new TestClass() {};
//		tc.print2();
		A.print2();
	}
}

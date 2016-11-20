interface A {
//	int types = 10;
	public static void print() {System.out.println("from interface");}
}
abstract class B implements A {
	public static int types = 20;
//	public static void print() {System.out.println("from abstract");}
}
public class TestClass extends B implements A{
	public static void main(String...args) {
		TestClass tc = new TestClass();
		tc.types = 30;
		System.out.println(tc.types);
		A.print();
	}
}

import java.util.function.*;

public class TestClass {
	TestClass() {}
	TestClass(Integer i) {
			System.out.println("from integer");
	}
	TestClass(Number n) {
		System.out.println("from number");
	}
	public void print() {
		System.out.print("Object builded!");
	}
	public static void main(String...args) {

		Supplier<TestClass> s = TestClass::new;
		Function<? super Number, TestClass> f = TestClass::new;

		f.apply(10.0).print();
		f.apply(10).print();
		f.apply(10L).print();
		Short sh = 10;
		f.apply(sh).print();
	}
}


interface A {
	public static void print() {
		System.out.println("from A");
	}
	public default void defaultMethod() {

	}
}

interface B extends A { 
	// Its Ok shadown a static method from a super interface:
	public default void print() {
		System.out.println("from B");
	}

	// But it is not OK, it isnot allowed
/*	public static void defaultMethod() {

	}
*/
	
}

interface C {
	
}


class DefaultMethodTest implements C, A {
	public static void main(String... args) {
		DefaultMethodTest t = new DefaultMethodTest();

		t.print();
	}
}

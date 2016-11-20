class TestClass extends Concrete implements I1{
	static void staticMethodConcreteClass() {
		System.out.println("static method from TestClass class");
	}	

	public static void main(String...args)	{
		TestClass tc = new TestClass();

		/**
			It does NOT compile, because this method,
			is a static method from a interface:
		**/
//		tc.print();	

		/**
			Is DOES COMPILE, because the access is by 
			Interface's name, so it is OK;
		**/
		I1.print();

		/**
			Variable from interface and default method, 
			is OK to access them by objet's reference
		**/
		System.out.println(tc.VALUE); // Its`s OK - DOES COMPILE
		tc.defaultMethod(); // Its`s OK - DOES COMPILE

		/**
		@Observations:
		All methods (static methods and instance methods) from CLASSES 
		are accessible by object's reference.

		For Interfaces, only default methods is possible access by
		object's reference
		**/

		tc.staticMethodConcreteClass();
	}
}
class Concrete {
	static int valor = 5;
	static void staticMethodConcreteClass() {
		System.out.println("static method from concrete class");
	}

}
abstract class A1 {
	static int VALUE = 10;
	protected static void staticM() {
		System.out.println("From abstract static method ");

	}
	private void write() {
		System.out.println("teste");
	}
	protected void write2() {

	}
}
interface I1 {
	int VALUE = 1;
	static void print() {
		System.out.println("@from interface static method");
	}

	default void defaultMethod() {
		System.out.println("@from interface default method");
	}
	// Does NOT compile, already exist such method (void print());
	//default void print() 
	//	System.out.println("@from interface default method");
	//}
}

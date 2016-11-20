import java.util.*;

class A {public String toString() {return "from A";}}
class A1 extends A {public String toString() {return "from A1";}}
class A2 extends A1 {public String toString() {return "from A2";}}
public class TestClass {

	// Accepts only T <= A1
	// So, only the types: A1, A2
	public static <T extends A1> T method(T t) {
		System.out.println("OK");
		return t;
	}	

	static public <T extends A1> List<T> list(List<T> list) {
		for (T t: list) {
			System.out.println(t);
		}

		System.out.println();

		return list;
	}

	public static void main(String...args) {

		Object o = method(new A1());
		A a = method(new A1());
		A1 a1 =	method(new A1());
		// Is this case it is ok so sign the variable A2 because
		// of inference that realize by argument passed
		A2 a2 =	method(new A2());


		List<A> listA = new ArrayList<>(Arrays.asList(new A(), new A()));
		List<A1> listA1 = new ArrayList<>(Arrays.asList(new A2(), new A2()));
		List<A2> listA2 = new ArrayList<>(Arrays.asList(new A2(), new A2()));

		List<A1> listRetrievedA1 = list(listA1);	
		List<A2> listRetrievedA2 = list(listA2);	
	}
}

import java.util.*;
enum Test {
// It does not compile:
/*	public void print() {
		System.out.println("Declation enum ALWAYS came at begin of class;")
	}
*/
	A, B, C {
		public void run() {System.out.println("Fast Speed");}
	}, D;
	
	public void run() {System.out.println("Normal Speed");}

	static String nonFinalStaticField = "non final static field";
	final static String staticFinalField = "static final Field";
	Test() {

		// It does NOT COMPILE:
		// Initilizer blocks (Like Constructor)
		// cannot reference to field non final static
		// System.out.println(nonFinalStaticField);


		// Is is OK, because this field is a final static
		System.out.println(staticFinalField);

		// It does not compile
		// A enum cannot reference itself in 
		// initializer (Constructors, instance block initializer)
		//System.out.println(B);
	}
	

	void print() {
		System.out.println(B);
	}
}

public class ImportantPoints {
	public static void main(String...args) {
		for (Test e : Test.values())
			e.run();
	}	
}


import java.util.*;

class A {public String toString() {return "Object of A";}}
class A1 extends A {public String toString() {return "Object of A1";}}
class A2 extends A1 {public String toString() {return "Object of A2";}}

public class TestClass {
	A a = new A();
	A1 a1 = new A1();
	A2 a2 = new A2();
	/*
		Hierarchy of classes:
		A:
		|--- A1:
			  | ---- A2
	*/

	// Where List<E>: E >= A1;
	// So, this method only accepts lists of objects of type: 
	//		-> List<Object>
	// 		-> List<A>
	//		-> List<A1> 
	public void addData1(List<? super A1> dataList) {

		// Here, you can add any object that is a A1;
		// So, you cannot add a object that is a superclass of A1
		// ONLY objects that ARE A1;

		// It will compile because a2 is a 
		// reference to object of subtype A1
		dataList.add(a2);


		// It's OK to because a1 is a reference to object
		// of type A1
		dataList.add(a1);

		// It wont compile because a is a reference
		// to object of superType A1
		// System.out.println(dataList.add(a));


		// Using List<? super A1> you cannot get nothing
		// beyond literaly Objects, because the compile does not know
		// what is in fact these objects, only knows that are
		// superTypes of A1 type;

		// Does NOT COMPILE
		// because you can retrieve only objects of type Object
		// A1 aa1 = dataList.get(0);


		// Does NOT COMPILE
		// because you can retrieve only objects of type Object
		// A aa = dataList.get(0);

		// It's OK, does COMPILE
		Object ob1 = dataList.get(0);
	}

	// Where List<E>: E <= A1;
	// So, this method only accepts lists of objects of type: 
	//		-> List<A1> 
	// 		-> List<A2>
	public void addData2(List<? extends A1> dataList) {

		// You cannot add nothing in the dataList
		// So none of these attemps to add objects in the list will compile:

		// dataList.add(a1);
		// dataList.add(a2);
		// dataList.add(a);
		// dataList.add(new Object());


		// You can retrieve objects and asign they to 
		// reference to object of type A1 or SuperType A1:
		// T >= A1
		a = dataList.get(0);
		System.out.println(a);

		a1 = dataList.get(0);
		System.out.println(a1);

		// It wont compile
		//a2 = dataList.get(0);
		//System.out.println(a2);
	}	
	public static void main(String...args) {
		TestClass tc = new TestClass();

		List<Object> listObject = new ArrayList<>();
		listObject.add(new Object());	// Only for avoid NullpointerException

		List<A1> listA1 = new ArrayList<>();
		listA1.add(new A1());			// Only for avoid NullpointerException

		List<A2> listA2 = new ArrayList<>();
		listA2.add(new A2());			// Only for avoid NullpointerException

		List<A> listA = new ArrayList<>();
		listA.add(new A());				// Only for avoid NullpointerException


		// @@@@@@ Passing argument to Method 
		//		addData1(List<? super A1> dataList):

		// It's ok because this method accept classes
		// that are A1 or superClasses from A1
		tc.addData1(listA1);

		// It's ok because this method accept classes
		// that are A1 or superClasses from A1
		tc.addData1(listA);

		// It's OK too, because Object is a indirectly superclass
		// from A1
		tc.addData1(listObject);

		// It's won't compile because A2 is a subclass from A1
		//tc.addData1(listA2);



		// @@@@@@ Passing argument to Method 
		// 		addData2(List< ? extends A1> dataList):

		// It's OK because, accepts list of 
		// objects of type A1 or subtypes A1
		tc.addData2(listA1);


		// It's OK too, because A2 is a subtype of A1
		tc.addData2(listA2);


		// It's won't compile because A is super type of A1
		// tc.addData2(listA);


		// It's won't compile because object is a 
		// indirectly super type of A1
		//tc.addData2(listObject);
	}
}

/*	@@@@@@@ -- About List<? super A1> -- @@@@@@@@

	As Argument to Method - > Only List of  E >= A1 (Classes or SuperClasses)
	To add in List        - > Only objects that are E <= A1 (Classes Or SubClasses)
	To retrieve from list - > Only objects of type Object

	@@@@@@@ -- About List<? extends A1> -- @@@@@@@@

	As argument to method - > Only List of E <= A1 (Classes or SubClasses)
	To add in List        - > It isn't possible to add nothing
	To retrieve from list - > Only Objects of Type A1;
*/

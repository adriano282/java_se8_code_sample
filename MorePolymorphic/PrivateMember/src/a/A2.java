package a;

public class A2 {
	
	public static void main(String...args) {
		A a = new A();
		System.out.println(a.i);
		a.modifyOther(a);
		System.out.println(a.i);
	}
}

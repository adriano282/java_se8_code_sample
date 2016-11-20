package a;

public class A {
	private int i;
	public void modifyOther(A a1) {
		a1.i = 20;
	}
	public static void main(String...args) {
		A a = new A();
		System.out.println(a.i);
		a.modifyOther(a);
		System.out.println(a.i);
	}
}

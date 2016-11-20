package p2;

import p1.A;

public class B extends p1.A {
	public void process(B b) {
		b.i = b.i * 2;
	}

	public static void main(String...args) {
		A a = new B();
		B b = new B();
		b.process(b);
		System.out.println(a.getId());
	}
}

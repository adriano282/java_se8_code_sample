class Boo {
	Boo(String s) { }
	Boo() { }
}
public class Bar extends Boo {
	Bar() { }
	Bar(String s) {super(s);}
	void zoo() {
		Boo b = new Boo("123") {};
	}


	public static void main(String ... args) {
		new Bar().zoo();
	}
}
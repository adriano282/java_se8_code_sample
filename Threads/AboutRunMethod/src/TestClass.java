class Threader extends Thread {
	public void run() {
		System.out.println("In Threader");
	}
}

class Pooler extends Thread {
	public Pooler() {}
	public Pooler(Runnable r) {
		super(r);
	}

	public void run() {
		System.out.println("In pooler");
	}
}

public class TestClass {
	public static void main(String...args) {
		Threader t = new Threader();
		Thread h = new Pooler(t);
		h.start();
	}
}
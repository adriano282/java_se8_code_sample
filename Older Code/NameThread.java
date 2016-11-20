class NameRunnable implements Runnable {
	public void run() {
		System.out.println("NameRunnable running");
		System.out.println("Run by " 
			+ Thread.currentThread().getName());
	}
}

public class NameThread {
	public static void main(String... args) {
		NameRunnable nr = new NameRunnable();
		Thread t = new Thread(nr);
		t.setName("Fred");
		t.start();
	}
}
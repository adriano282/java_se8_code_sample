class TestThread3 implements Runnable {
	private int a, b;
	static int A = 0;
	static int B = 0;
	static int C = 0;

	public synchronized int read() {
		if (Thread.currentThread().getName().equals("A")) {
			System.out.print("A");
			A++;
		} else if (Thread.currentThread().getName().equals("B")) {
			System.out.print("B");
			B++;
		} else {
			System.out.print("C");
			C++;
		}
		return a + b;
	}

	public synchronized void set() {
		this.a = 1;
		this.b=3;

		if (Thread.currentThread().getName().equals("A")) {
			System.out.print("A");
		} else if (Thread.currentThread().getName().equals("B")) {
			System.out.print("B");
		} else {
			System.out.print("C");
		}
	}
	public static void main(String... args) {

		TestThread3 work = new TestThread3();
		Thread one = new Thread(work);
		Thread two = new Thread(work);
		Thread three = new Thread(work);

		one.setName("A");
		two.setName("B");
		three.setName("C");

		one.start();
		two.start();
		three.start();
		
		while (one.isAlive() || two.isAlive() || three.isAlive()) {
			if (!one.isAlive() && !two.isAlive() && !three.isAlive()) {
				System.out.println("A --- " + A);
				System.out.println("B --- " + B);
				System.out.println("C --- " + C);
			}	
		}		
	}

	public void run() {
		for (int x = 0; x < 100; x++) {
			set();
			read();
		}
	}
}
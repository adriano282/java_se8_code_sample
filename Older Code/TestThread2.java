class TestThread2 {
	private int a, b;

	public void set() {
		synchronized (a) {
			a = 1;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		printAll(args);
	}

	public static void printAll(String[] lines) throws InterruptedException {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
			Thread.sleep(1000);
		}
	}
}
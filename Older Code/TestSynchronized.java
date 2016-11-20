class TestSynchronized implements Runnable {
	private StringBuffer sb;
	private char c = 'A';
	
	public void run() {
		for (int x = 1; x <= 300; x++) {
			System.out.println(sb.ap
		}
				
	}
	TestSynchronized() {}

	TestSynchronized (StringBuffer sb) {
		this.sb = sb;
	}


	public static void main(String ... args) {
		char c = 'A';
		TestSynchronized ts = new TestSynchronized(new StringBuffer("A"));

		Thread one = new Thread(ts);
		Thread two = new Thread(ts);
		Thread three = new Thread(ts);

		one.start();
		two.start();
		three.start();


	}
}
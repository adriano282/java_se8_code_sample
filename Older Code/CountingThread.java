class CountingThread {
	class Work implements Runnable {
		public void run() {
			for (int x = 1; x <= 300; x++) {
				System.out.println(Thread.currentThread().getName()
					+ " is running");
			}
		}
	}
	public static void main(String... args) throws InterruptedException {
		CountingThread c = new CountingThread();
		Work work = c.new Work();
		
		Thread t1 = new Thread(work);
		t1.setName("A");
		
		Thread t2 = new Thread(work);
		t2.setName("B");
		
		t1.start();
		t2.start();

		t2.join();


	}
}
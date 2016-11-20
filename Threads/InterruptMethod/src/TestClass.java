public class TestClass implements Runnable {
	Thread t;

	TestClass() {
		t = new Thread(this);
	}
	public void setDaemon() {
		System.out.println("Setting thread daemon");
		t.setDaemon(true);
	}
	public void start() {t.start();}
	public void interrupt() {
		t.interrupt();
	}
	public void run() {
		while(!t.isInterrupted()) {
			/*try {
				Thread.sleep(15_000);				
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}*/
			
		}
	}

	public static void main(String...args) {
		TestClass work = new TestClass();

		work.setDaemon();
		work.start();
		TestClass work2 = new TestClass();
		work2.start();


		/*try {
			System.out.println(Thread.currentThread().getName() + " sleep");
			Thread.sleep(10_000);	
		} catch (InterruptedException e) {

		}
		System.out.println("Interrupt the other Thread");
		work.interrupt();
		*/
		
	}
}
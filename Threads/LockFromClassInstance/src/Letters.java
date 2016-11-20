public class Letters extends Thread {
	private String name;
	public Letters(String name) { this.name = name; }
	public void write() {
		System.out.print(name);
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

		
		System.out.print(name);
	}
	public void run() {
		synchronized(Letters.class) {
			write();
		}
		
	}
	public static void main(String[] args) {
		new Letters("X").start();
		new Letters("Y").start();
		System.out.println();
	}
}


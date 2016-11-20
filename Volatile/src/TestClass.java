public class TestClass {
	public static final int MAX = 100_000;
	public static volatile int i = 0, j = 0;
	public static Object ob = new Object();
	public static void one() {
		synchronized(ob) {i++; j++;}
		
	}
	public static void two() {
		//System.out.println("i: " + i + ";j: " + j);
		synchronized(ob) {
			if (j != i) System.out.println("i: " + i + ";j: " + j);
		}
	}

	public static void main(String...args) {

		new Thread(new Runnable() {
			public void run() {
				for (int n = 0; n < MAX; n++)
					one();
			}
		}).start();
		

		new Thread(new Runnable() {
			public void run() {
				for (int n = 0; n < MAX; n++)
					two();	
			}
		}).start();
	}
}
public class MyThread implements Runnable {
	String msg = "default";
	public MyThread(String s) {msg = s;}
	public void run() {System.out.println(msg);}

	public static void main(String...args) {
		// The lesson here is that none new thread
		// will be used because the method run
		// doesnot trigger the call for a new thread
		// althoug the method run from our MyThread will
		// be called
		new Thread(new MyThread("String1")).run();
		new Thread(new MyThread("String2")).run();
		System.out.println("end");
	}
}

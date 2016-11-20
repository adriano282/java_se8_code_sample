interface Boiler {
	public void boil();
	public static void shutdown() {
		System.out.println("shutting down");
	}
}

interface Vaporizer extends Boiler {
	public default void vaporize() {
		boil();
		System.out.println("vaporized");
	}
	public default void shutdown() {System.out.println("shut down vaporizer");}
}
public class AbstractIn implements Vaporizer {
	public void boil() {
		System.out.println("Boiling...");
	}
	public static void main(String[] args) {
		Vaporizer v = new AbstractIn();
		v.vaporize();
		Boiler.shutdown();
		v.shutdown();
	}
}

public class Device implements AutoCloseable {
	public int id;
	public Device(int id) {
		this.id = id;
		System.out.println("Device n. " + id + " opened;");
	}
	
	public void use() {
		System.out.println("Device n. " + id + " used;");
	}	
	public void close() {
		System.out.println("Device n. " + id + " closed;");
	}
	public static void main(String... args) {
		
		try (Device d1 = new Device(1);
			Device d2 = new Device(2)) {
			d1.use();
			d2.use();
		}
	}
	
	
}

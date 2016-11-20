import java.io.IOException;

public class Device implements AutoCloseable {
	String header = null;
	public Device(String name) throws IOException {
		header = name;
		if ("D2".equals(name)) throw new IOException("Unknow");
		System.out.println(header + " Opened");
	}
	
	public String read() throws IOException {
		return "";
	}
		
	public void close() {
		System.out.println("Closing device");
		header = null;
		throw new RuntimeException("rtw");
	}

	public static void main(String...args) {
		try (Device d = new Device("D1");
			Device d2 = new Device("D2")) {
			throw new Exception("test");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

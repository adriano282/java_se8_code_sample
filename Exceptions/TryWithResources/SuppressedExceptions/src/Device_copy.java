import java.io.IOException;

public class Device_copy implements AutoCloseable {
	String header = null;
	public void open() throws IOException {
		header = "OPENED";
		System.out.println(header + " Opened");
		throw new IOException("Unknow");
	}
	
	public String read() throws IOException {
		return "";
	}
		
	public void close() throws IOException {
		System.out.println("Closing device");
		header = null;
		throw new IOException("rtw");
	}

	public static Device_copy get() {return new Device_copy();}
	public static void main(String...args) {
		
		try (Device_copy d = get()) {
			throw new Exception("test");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

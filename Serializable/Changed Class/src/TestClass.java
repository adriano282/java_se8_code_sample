import java.io.*;

public class TestClass implements Serializable {
//	public static final long serialVersionUID = 3;
	public String name;
//	public String age;
	public String toString() {return name;} // + " : " + age;}
	public static void main(String...args) throws IOException {
		TestClass tc = null;
		tc = new TestClass();
		tc.name = "Adriano";

		serialize(tc);
		showObject(tc);
		
		tc = null;
		tc = deserialize(tc);
		showObject(tc);


		
	}
	public static void showObject(TestClass tc) {
		System.out.println(tc);
	}
	public static void serialize(TestClass tc) throws IOException {
		FileOutputStream fos = new FileOutputStream("dado.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);

		os.writeObject(tc);
		os.close();
	}
	public static TestClass deserialize(TestClass tc) throws IOException {
		FileInputStream fis = new FileInputStream("dado.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println(ois.readClassDescriptor());

		try {tc = (TestClass) ois.readObject();}
		catch (ClassNotFoundException e) {e.printStackTrace();}	

		ois.close();
		return tc;
	}
	
}

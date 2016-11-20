import java.io.*;

abstract class A implements Serializable {
	public int i;

}
public class B extends A {
	public String toString() {return " " + i;}
	public static void main(String...args) {

		B[] array = new B[2];
		array[0] = new B();
		array[0].i = 2;
		array[1] = new B();
		array[1].i = 3;


		System.out.println("before: " + array[0] + ":" + array[1]);
		try (FileOutputStream fos = new FileOutputStream("testSer.data");
		ObjectOutputStream os = new ObjectOutputStream(fos);) {

			os.writeObject(array);
			array = null;
		} catch (IOException e) {e.printStackTrace();}

		try (FileInputStream fis = new FileInputStream("testSer.data");
			ObjectInputStream oi = new ObjectInputStream(fis)) {
			array = (B[]) oi.readObject();
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}

		System.out.println("after: " + array[0] + ":" + array[1]);
	}

}
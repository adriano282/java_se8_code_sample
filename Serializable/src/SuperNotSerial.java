import java.io.*;

public class SuperNotSerial {
	public static void main(String... args) {

		Collar c = new Collar(15);
		Dog d = new Dog(35, "Fido", c);

		System.out.println("before: " + d.getName() + " "
							+ d.weight + " size collar: " 
							+ d.getCollar().getSize());

		try (FileOutputStream fos = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fos)) {
			os.writeObject(d);
		} catch (Exception e) {e.printStackTrace();}

		try (FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			d = (Dog) ois.readObject();
		} catch (Exception e) {e.printStackTrace();}

		System.out.println("after: " + d.getName() + " "
							+ d.weight + " size collar: " 
							+ d.getCollar().getSize());
		System.out.println(d);
		System.out.println(d.getCollar());
	}
}

class Dog extends Animal implements Serializable {
	private String name;
	private transient Collar c;

	Dog(int w, String n, Collar c) {
		System.out.println("Dog's constructor used");
		this.c = c;
		this.weight = w;			// inhetited
		this.name = n;			// not inherited
	}

	private void writeObject(ObjectOutputStream os) {
		try {
			System.out.println("manual writing");
			os.defaultWriteObject();
			os.writeInt(c.getSize());
		} catch (Exception e) {e.printStackTrace();}
	}

	private void readObject(ObjectInputStream ois) {
		try {
			System.out.println("manual reading");
			ois.defaultReadObject();
			c = new Collar(ois.readInt());
		} catch (Exception e) {e.printStackTrace();}
	}

	public Collar getCollar() {
		return c;
	}

	public String getName() {
		return name;
	}
}

class Collar {
	private int size = 0;

	Collar(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
}
class Animal {
	Animal() {
		System.out.println("Animal's constructor used");
	}
	int weight = 42;
}
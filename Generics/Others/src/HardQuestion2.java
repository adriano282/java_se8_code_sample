import java.util.*;

class Animal { 
	String name;
	public String toString() {return name;}
}
class Dog extends Animal {
	public String name;
	Dog (String name) { 
		this.name = name;
	}
	public String toString() {return name;}
}
public class HardQuestion2<T> {
	public List<? super T> backwards(List<T> input) {
		List<T> output = new LinkedList<T>();
		for (T t : input) {
			output.add(t);
		}
		return output;
	}
	
	public static void main(String...args) {
		HardQuestion2<Dog> hq = new HardQuestion2<>();

		List<Dog> dogs = Arrays.asList(new Dog("tunico"), new Dog("betoven"));		
		
		System.out.println(hq.backwards(dogs));
	}
}

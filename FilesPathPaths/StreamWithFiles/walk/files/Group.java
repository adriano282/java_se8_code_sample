import java.util.*;

public class Group extends HashSet<Person> {
	public static void main(String...args) {
		Group g = new Group();
		g.add(new Person("Adriano"));
		g.add(new Person("Gabriel"));
		g.add(new Person("Adriano"));
		System.out.println("Total: " + g.size());
	}

	@Override
	public boolean add(Person p) {
		System.out.println("Adding: " + p);
		return super.add(p);
	}

}
class Person {
	private final String name;
	public Person(String name) {this.name = name;}
	public String toString() {return name;}
}

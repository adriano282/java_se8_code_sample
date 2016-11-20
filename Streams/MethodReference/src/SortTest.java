import java.util.*;

class Person {
	String name;
	String dob;

	public Person(String name, String dob) {
		this.name = name; this.dob = dob;
	}
}
class MySorter {
	public int compare(Person p1, Person p2) {
		return p1.dob.compareTo(p2.dob);
	}
}

public class SortTest {
	public static int diff(Person p1, Person p2) {
		return p1.dob.compareTo(p2.dob);
	}

	public static void main(String[] args) {
		ArrayList<Person> al = new ArrayList<>();
		al.add(new Person("Paul", "01012000"));
		al.add(new Person("Peter", "01011990"));
		al.add(new Person("Patrick", "01012002"));
		
		java.util.Collections.sort(al, new MySorter()::compare);
	}
}
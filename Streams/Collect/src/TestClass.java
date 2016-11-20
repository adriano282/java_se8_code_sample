import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class TestClass {
	public static void main(String...args) {
		List<Person> roster = Person.createRoster();
		
		
		Averager averager = roster.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE)
			.map(Person::getAge)
			.collect(Averager::new, Averager::accept, Averager::combine);
		
		System.out.format("The average  age of male members: %.2f%n", averager.average());

		List<String> names = roster.stream()
			.map(Person::getName)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println(names);

		ConcurrentMap<Person.Sex, List<Person>> byGender =
			roster
			.parallelStream()
			.collect(
				Collectors.groupingByConcurrent(Person::getGender));
		
		System.out.println(byGender);
	}
}

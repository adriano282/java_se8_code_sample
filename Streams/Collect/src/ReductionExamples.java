import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Set;

public class ReductionExamples {
	static Predicate<Person> byMaleGender = p -> p.getGender() == Person.Sex.MALE;
	
	public static void main(String...args) {
		List<Person> roster = Person.createRoster();
		
		System.out.println("Contents of roster");
		roster.stream()
			.forEach(Person::printPerson);

		averageAgeOfMaleMembers(roster);
		sumOfAgesWithSum(roster);
		sumOfAgesWithReduction(roster);
		averageOfMaleMembersWithCollect(roster);
		namesOfMalesWithCollect(roster);
		groupMembersByGender(roster);
	}

	static void averageAgeOfMaleMembers(List<Person> roster) {
		double average = roster
			.stream()
			.filter(byMaleGender)
			.mapToInt(p -> p.getAge())
			.average()
			.getAsDouble();
		System.out.format("Average age of male member is %.2f%n", average);
	}

	static void sumOfAgesWithSum(List<Person> roster) {
		long sum = roster
			.stream()
			.mapToInt(p -> p.getAge())
			.sum();

		System.out.format("Sum of ages: %d (With sum from IntStream)%n", sum);
	}
	
	static void sumOfAgesWithReduction(List<Person> roster) {
		int sum = roster
			.stream()
			.mapToInt(p -> p.getAge())
			.reduce(0, (a, b) -> a + b);
		System.out.format("Sum of ages: %d (With reduce)%n", sum);
	}

	static void averageOfMaleMembersWithCollect(List<Person> roster) {
		double  average = roster
			.stream()
			.filter(byMaleGender)
			.map(Person::getAge)
			.collect(Averager::new, Averager::accept, Averager::combine)
			.average();
		System.out.format("Average age of male members: %.2f (With Collect)%n", average);
	}

	static void namesOfMalesWithCollect(List<Person> roster) {
		List<String> name = roster
			.stream()
			.filter(byMaleGender)
			.map(Person::getName)
			.collect(Collectors.toList());
		System.out.println("Names of Males (With Collect)");
		printAll(name);
	}

	static void groupMembersByGender(List<Person> roster) {
		Map<Person.Sex, List<Person>> result =
			roster.stream()
			.collect(Collectors.groupingBy(Person::getGender));
		printAllPersons(result);

	}

	static  void groupNameByGender(List<Person> roster){
		Map<Person.Sex, List<String>> list =
			roster.stream()
			.collect(
				Collectors.groupingBy(Person::getGender,
				Collectors.mapping(Person::getName,
					Collectors.toList())));

		printAllStrings(list);
	}

	static void totalAgeByGender() {}
	static void averageAgeByGender() {}


	static void printAll(List<?> list) {
		list.forEach(System.out::println);
	}
	static void printAllStrings(Map<Person.Sex, List<String>> map) {
			map.entrySet().forEach(e -> {
			System.out.format("key: %s:%n", e.getKey());
			System.out.format("  values: %s%n", e.getValue());
		});
	}

	static void printAllPersons(Map<Person.Sex, List<Person>> map) {
			map.entrySet().forEach(e -> {
			System.out.format("key: %s:%n", e.getKey());
			System.out.format("  values: %s%n", e.getValue());
		});
	}
}

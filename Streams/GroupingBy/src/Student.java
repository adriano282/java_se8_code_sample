import java.util.*;
import java.util.stream.Collector;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;


public class Student {
	public static enum Grade {A, B, C, D, F};
	private String name;
	private Grade grade;

	public Student(String name, Grade grade) {
		this.name = name;
		this.grade = grade;
	}

	public String toString() {return name + ":" + grade;}
	public String getName() {return name;}
	public Grade getGrade() {return grade;}

	public static void main(String...args) {
		List<Student> ls = 
			Arrays.asList(	new Student("S1", Student.Grade.A),
							new Student("S2", Student.Grade.B),
							new Student("S3", Student.Grade.C),
							new Student("S4", Student.Grade.A),
							new Student("S5", Student.Grade.B),
							new Student("S6", Student.Grade.C));

		Map<Student.Grade, List<Student>> grouping = 
			ls.stream().collect(groupingBy(Student::getGrade)));
		System.out.println(grouping);

		Map<Student.Grade, Long> groupingCount = 
			ls.stream().collect(groupingBy(Student::getGrade, counting()));
		System.out.println(groupingCount);		

		Map<Student.Grade, List<String>> groupingWithMapping = 
			ls.stream().collect(groupingBy(Student::getGrade, mapping(Student::getName, toList())));
		System.out.println(groupingWithMapping);		
	}
}

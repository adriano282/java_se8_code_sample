import java.util.*;
import java.util.stream.Collectors;

public class Course {
	private String id;
	private String category;

	public Course(String id, String category) {
		this.id = id;
		this.category = category;
	}

	public String toString() {
		return id + " " + category;
	}

	public String getCategory() {return category;}

	public static void main(String ...args) {
		List<Course> s1 = Arrays.asList(
			new Course("OCAJP", "java"),
			new Course("OCPJP", "java"),
			new Course("C#", "C#"),
			new Course("OCEJPA", "java"));

		s1.stream()
			.collect(Collectors.groupingBy(Course::getCategory))
			.forEach((m, n) -> System.out.println(n));
	}
}
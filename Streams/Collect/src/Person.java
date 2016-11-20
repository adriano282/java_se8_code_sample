import java.util.List;
import java.util.ArrayList;
import java.time.chrono.IsoChronology;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class Person implements Comparable<Person> {
	public enum Sex {MALE, FEMALE}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	
	Person (String name, LocalDate birthday, Sex gender, String email) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = email;
	}
	
	public Sex getGender() {
		return this.gender;
	}

	public Integer getAge() {
		return birthday
			.until(IsoChronology.INSTANCE.dateNow())
			.getYears();
	}
	
	public void printPerson() {
		System.out.printf("Nome: %s, Age: %d%n", name, this.getAge());
	}
	
	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	public int compareTo(Person p) {
		return this.getAge().compareTo(p.getAge());
	}

	public String toString() {
		return name + ":" + gender;
	}

	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<>();
		roster.add(
	            new Person(
        	    "Fred",
	            IsoChronology.INSTANCE.date(1980, 6, 20),
	            Person.Sex.MALE,
	            "fred@example.com"));
	        roster.add(
	            new Person(
	            "Jane",
	            IsoChronology.INSTANCE.date(1990, 7, 15),
	            Person.Sex.FEMALE, "jane@example.com"));
        	roster.add(
	            new Person(
	            "George",
	            IsoChronology.INSTANCE.date(1991, 8, 13),
	            Person.Sex.MALE, "george@example.com"));
	        roster.add(
	            new Person(
	            "Bob",
	            IsoChronology.INSTANCE.date(2000, 9, 12),
	            Person.Sex.MALE, "bob@example.com"));
	        
	        return roster;
	}
}

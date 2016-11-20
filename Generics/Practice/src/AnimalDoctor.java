import java.util.*;

abstract class Animal{
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() {
		System.out.println("Dog checkup");
	}
}
class Cat extends Animal {
	public void checkup() {
		System.out.println("Cat checkup");
	}
}
class Bird extends Animal {
	public void checkup() {
		System.out.println("Bird checkup");
	}
}

class AnimalDoctorGeneric {
	public void addAnimal(List<? super Dog> animals) {
		animals.add(new Dog());
	}
}

public class AnimalDoctor {
	public void checkAnimal(Animal a) {
		a.checkup();
	}
	
/**	public void checkAnimals(List<? extends Animal> animals) {
		for (Animal a : animals) a.checkup();
		
	}**/
	public <E> void checkAnimals(List<E super Cat> animals) {
//		for (Cat  a : animals) a.checkup();
	}
	public static void main(String...args) {
/**		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
**/
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat());
		cats.add(new Cat());

/**		List<Bird> birds = new ArrayList<Bird>();
		birds.add(new Bird());
		birds.add(new Bird());
**/
		AnimalDoctor doc = new AnimalDoctor();
		
//		doc.checkAnimals(dogs);
		doc.checkAnimals(cats);
//		doc.checkAnimals(birds);


	}
}

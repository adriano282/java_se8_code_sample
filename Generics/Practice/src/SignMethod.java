import java.util.*;

class SuperClass {
	public String toString() {
		return "from superClass";
	}
}
public class SignMethod extends SuperClass {
	public static void m1(List<? extends  Number> list) {
		System.out.println(list.get(0));
		Number n = list.get(0);
	}
	public static void main(String...args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		m1(list);

		Map<String, ? super SuperClass> myMap = new HashMap<>();

		myMap.put("one", new SuperClass());
		myMap.put("two", new SignMethod());

		myMap.forEach((k,v) -> System.out.println(k + ":"+v));

	}

	public String toString() {return "from subclass";}
}

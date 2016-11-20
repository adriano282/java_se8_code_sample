import java.util.*;

public class WildCard {
	public void print() {
		System.out.println("WildCard");
	}
}
class Weather extends WildCard {
	public void print() {
		System.out.println("Weather");
	}
}
class Check<A> {
	void lists() {
		// This examples do compile:
		Map<Weather, A> l1 = new HashMap<Weather, A>();
		//or
		Map<Weather, A> l2 = new HashMap<>();
		//or 
		Map<?, ?> l3 = new HashMap<Weather, A>();
		
		// This do not compile!!
//		Map<Weather, A> l4 = new HashMap<? ,?>();

	}
	public static <T super Weather> void print(T t) {
		t.print();
	}
	public static void main(String... args) {
		System.out.println(" compiled and raw");
		Weather w = new Weather();
		WildCard wc = new Weather();
		WildCard wc2 = new WildCard();

		print(w);
		print(wc);
		print(wc2);
	}
}

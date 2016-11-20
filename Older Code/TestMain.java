import java.util.function.Supplier;
import java.util.function.Predicate;
interface MyList<T>{
	T head();
	MyList<T> tail();

	default boolean isEmpty() {
		return true;
	}

	default MyList<T> filter(Predicate<T> p) {
		return isEmpty() ?
				this :
				p.test(head()) ?
					new LazyList<>(head(), () -> tail().filter(p)) :
					tail().filter(p);
	}
}
class MyLinkedList<T> implements MyList<T> {
	private final T head;
	private final MyList<T> tail;
	public MyLinkedList(T head, MyList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	public T head() {
		return head;
	}

	public MyList<T> tail() {
		return tail;
	}

	public boolean isEmpty() {
		return false;
	}
}
class Empty<T> implements MyList<T> {
	public T head() {
		throw new UnsupportedOperationException();
	}

	public MyList<T> tail() {
		throw new UnsupportedOperationException();
	}
	public boolean isEmpty() {
		return true;
	}
}

class LazyList<T> implements MyList<T> {
	final T head;
	final Supplier<MyList<T>> tail;
	public LazyList(T head, Supplier<MyList<T>> tail) {
		this.head = head;
		this.tail = tail;
	}

	public T head() {
		return head;
	}

	public MyList<T> tail() {
		return tail.get();
	}	

	public boolean isEmpty() {
		return false;
	}


}
public class TestMain {
	public static LazyList<Integer> from(int n) {
		return new LazyList<Integer>(n, () -> from(n+1));
	}
	public static MyList<Integer> primes (MyList<Integer> numbers) {
		return new LazyList<> (
			numbers.head(),
			() -> primes(
				numbers.tail().filter(n -> n % numbers.head() != 0)
				));
	}
	public static void printAll(MyList<Integer> list) {
		while(!list.isEmpty()) {
			System.out.println(list.head());
			list = list.tail();
		}
	}
	public static void main(String... args) {
		MyList<Integer> l =
			new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty()));


		while (!l.isEmpty()) {
			System.out.println(l.head());
			l = l.tail();
		}

		LazyList<Integer> numbers = from(2);
		int two = numbers.head();
		int three = numbers.tail().head();
		int four = numbers.tail().tail().head();
		int five = numbers.tail().tail().tail().head();

		System.out.println(two + "" + three + "" + four+ "" + five);

		int dois = primes(numbers).head();
		int tres = primes(numbers).tail().head();
		int cinco = primes(numbers).tail().tail().head();

		System.out.println(dois + "" + tres + "" + cinco);

		printAll(primes(from(2)));
	}
}
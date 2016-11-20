import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

class Account {
	private String id;
	public Account(String id) {this.id = id;}
	public String getId() {return id;}
	public String toString() {return id;}
}
public class BankAccount extends Account {
	private double balance;
	public BankAccount(String id, double balance) {
		super(id);
		this.balance = balance;
	}
	
	public static void main(String...args) {
		Map<String, Account> myAccts = new HashMap<>();
		//myAccts.put("111", null);
		myAccts.put("222", new BankAccount("111", 200.0));
		myAccts.put(null, new Account("NO-NULL"));
		myAccts.put("555",new Account("NO-NULL"));

		System.out.print("Initial state:\n");
		iterateOnMap(myAccts);
		System.out.println();

		System.out.println("\ncomputeIfAbsent()");
		Function<String, Account> function = (a) -> {	
			System.out.format("Key passed: %s%n", a);
			return new Account("placed");
		};
		System.out.format("Return of computeIfAbsent(): %s%n", myAccts.computeIfAbsent("111", function));
		System.out.println("After:");
		iterateOnMap(myAccts);
		System.out.println();

		System.out.println("\ncomputeIfPresent()");
		BiFunction<String, Account, Account> bif = 
			(a1, a2) -> {
				System.out.format("Current Key: %s%n", a1);
				System.out.format("Current value: %s%n", a2);
				return new Account("Contains the key, and value is not null");
			};
		
		System.out.format("Return of computeIfPresent() %s%n", 
			myAccts.computeIfPresent(null, bif));

		System.out.println("After:");
		iterateOnMap(myAccts);
		System.out.println();

		
		System.out.println("\ncompute()");
		BiFunction<String, Account, Account> bif2 =
			(a1, a2) ->  {
				System.out.format("Current Key: %s%n", a1);
				System.out.format("Current value: %s%n", a2);
			// throw new RuntimeException();
				return null;
			};

		try {System.out.format("Return of compute: %s%n", 
			myAccts.compute("555", bif2));} 
		catch (Exception e) {e.printStackTrace();}
		System.out.println("After:");
		iterateOnMap(myAccts);
 	
 		System.out.format("%nMerge: 222, return null%n");
 		try {
			myAccts.merge("222", new Account("1"), (a1, a2) -> {
				System.out.println("current value: " + a1 );
				System.out.println("new value: " + a2 +"\n");
				//return new Account(a1.getId() + a2.getId());
				throw new RuntimeException();
				//return null;
			});
		} catch (Exception e) {System.out.println("Exception catched.");}
		System.out.format("%nAfter Merge: %n");
		iterateOnMap(myAccts);
		
	}
	public static <K, V> void iterateOnMap(Map<K, V>  map) {
		for (Map.Entry<K, V> pair : map.entrySet()) {
			System.out.println("Key : " + pair.getKey() + " | Value : " + pair.getValue());
		}
	}
}

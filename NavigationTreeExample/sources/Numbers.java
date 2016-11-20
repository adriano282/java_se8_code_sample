import java.util.*;

public class Numbers {
	private Set<Integer> numbers = new TreeSet<Integer>();
	public Numbers(int... nums) {
		for (int n : nums)
			numbers.add(n);
	}
	
	public Numbers negate() {
		Numbers negatives = new Numbers();
		for (int n : numbers)
			negatives.numbers.add(-n);
		return negatives;
	}
	public void show() {
		for (int n : numbers)
			System.out.print(n + " ");
	}
	public static void main(String...args) {
		new Numbers(1, 3, -5).negate().show();
	}
}

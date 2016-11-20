import java.util.function.*;

public class TestClass {
	public static void main(String...args) {
		double principle = 100;
		int interestrate = 5;
		double amount = compute(principle, x -> x * interestrate);
		System.out.println(amount);
		double amount2 = compute2(principle, x -> x * interestrate);
		System.out.println(amount2);
	}

	public static double compute(double base, Function<Integer, Integer> func) {
		return func.apply((int)base);
	}
	public static double compute2(double base, Function<Double, Double> f) {
		return f.apply(base);
	}
}
public class FactorialClass {
	public static int factorialIterative(int n) {
		int r = 1;

		for (int i = 1; i <= n; i++) {
			r *= i;
		}
		return r;
	}

	public static long factorialRecursive(long n) {
		return n == 1 ? 1 : n * factorialRecursive(n-1);
	}

	public static void main(String... args) {
		System.out.println(factorialRecursive(8));
		System.out.println(factorialIterative(8));
	}
}
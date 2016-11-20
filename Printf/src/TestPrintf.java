public class TestPrintf {
	public static void main(String...args) {
		int i1 = -123;
		int i2 = -12345;
		float f3 = 123.9434f;
		
		System.out.printf("R$ %1$f.2\n", f3);
		System.out.printf(">%1$(7d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
		System.out.printf(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);

		System.out.format("%b", 123);
		System.out.printf("%d", 123);
	}
}

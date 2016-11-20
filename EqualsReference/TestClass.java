public class TestClass {
	public static void main(String...args) {
		Integer i = 127;
		Integer i2 = 127;

		equals(i, i2);
		i2++;
		i++;
		equals(i, i2);
		
		i--;
		i2--;
		equals(i, i2);
		

		
	}
	public static void print(String s) {System.out.println(s);}
	public static void equals(Integer a, Integer b) {
		if (a == b) print("equals");
		else print("not equals");
	}
}

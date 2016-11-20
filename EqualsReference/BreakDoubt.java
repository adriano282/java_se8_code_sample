public class BreakDoubt {
	private String name = "adriano";
	public String getName() {return name;}
	public static void main(String... args) {
		String name2 = "adriano";
		String name3 = name2;
	
		if (name3 == name2) {
			System.out.println("==");
		}
		name3 += "v";
		name3 = new String("adriano");
		if (name3 == name2) {
			System.out.println("==");
		}
	}
}
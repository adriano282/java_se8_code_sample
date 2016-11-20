public class High {
	public static String go(int... x) {return "hi ";}
} 
class Low extends High {
//	public static String go(int x, int y) { return "low "; }
	public static void main(String [] args) {
		System.out.println(go(9, 27));
		System.out.println(go(81));
	}
}

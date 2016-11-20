public class TestEnum {
	enum Teste {
		A, B, C;
		
		Teste() {
		}
	}
	public enum Season implements Runnable {
		SUMMER(10), AUTUMN(9), WINTER(8), SPRING(5);

		public void run() {}
		private int number;

		Season(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}	
	
	public static void main(String... args) {

		for (Season s : Season.values()) {
			System.out.println(s + " " + s.getNumber());
		}
		Season s = Season.SUMMER;
		System.out.println(Season.valueOf("SUMMER"));
		System.out.println(s.ordinal());
	}
}

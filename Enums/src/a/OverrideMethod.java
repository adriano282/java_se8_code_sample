package a;

public class OverrideMethod {
	public enum Season {
		SPRING, AUTUMN, SUMMER,

		WINTER {
			public void info() {System.out.println("cold");}
		};

		public void info() {System.out.println("season");}
	}

	public static void main(String...args) {
		Season.WINTER.info();
		Season.SPRING.info();
	}
}
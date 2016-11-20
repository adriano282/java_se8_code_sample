package b;

import a.OverrideMethod;

public class TestEnum {
	public static void main(String...args) {
		OverrideMethod.Season.WINTER.info();
		OverrideMethod.Season.SPRING.info();
	}
}
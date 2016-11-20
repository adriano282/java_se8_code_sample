public class ReferecingAEnum {
	public static void main(String...args) {
		Other.Faster f = Other.Faster.HIGHER;
		System.out.print(f);
		System.out.format("ordianal : %s%n", f.ordinal());
		System.out.format("ordianal : %s%n", Other.Faster.LONGER.ordinal());
		System.out.format("name: %s", f.name());
	}
}

class Other {
	enum Faster { HIGHER, LONGER };
}

import java.util.function.Function;
public class InnerClass {
	Function<Object, String> f = new Function<Object, String>() {
		@Override
		public String apply(Object obj) {
			return obj.toString();
		}
	};
	
	class InerClass extends InnerClass {
	}

	public static void main(String... args) {
		System.out.println("Its OK");
	}
}

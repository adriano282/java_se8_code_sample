package b;

import a.OuterClass;

public class OtherClass {
	public static void main(String... args) {
		OuterClass outClass = new OuterClass();
		OuterClass.InnerClass in = new OuterClass.InnerClass();
		in.print();
		in.staticMethod();
	}
	
}

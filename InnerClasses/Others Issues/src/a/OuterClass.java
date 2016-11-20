package a;

public class OuterClass {
	private String s = "outer_variable";

	
	public static class InnerClass {
		public String s = "from inner class";
		public void print() {
			// The inner class can acces all members
			// from outerclass including private member
			System.out.println(s);
		}

		public static void staticMethod() {
			System.out.println("from a static method");
		}
	}

/*	public static void main(String... args) {
		InnerClass in = new InnerClass();
		in.print();

		OuterClass.InnerClass in2 = new OuterClass.InnerClass();
		in2.print();

		OuterClass.InnerClass in3 = new InnerClass();
		in3.print();

		InnerClass in4 = new OuterClass.InnerClass();
		in4.print();
		
	}*/
}

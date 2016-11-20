public class PollMethodsExample {
	public static void main(String... args) {
		
		TreeSetValues.init();
		getAndRemoveFirstElement();

		write("\n\nInitializing again\n");
		TreeSetValues.init();
		
		getAndRemoveLastElement();
		
		
	}
	public static int getAndRemoveFirstElement() {
		
		write("treeSet.poolFirst(): \n");
		write("before poolFirst: ");
		show();
		write("poolFirst executed \n");
		int r = TreeSetValues.treeSet.pollFirst();
		write("after poolFirst: " );
		show();
		return r;		
	}
	public static int getAndRemoveLastElement() {
		write("before pollLast: \n");
		show();
		write("executed: treeSet.pollLast()\n");
		int r = TreeSetValues.treeSet.pollLast();
		write("after pollLast: \n");
		show();
		return r;
	}
	public static void write(String message) {System.out.print(message);}
	public static void show() {write(TreeSetValues.treeSet + "\n");}
}

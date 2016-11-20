import java.util.*;

public class EnumOnTreeSet {
	public enum Season {WINTER, AUTUMN, SUMMER, SPRING}
	public static void main(String...args) {
		TreeSet<Season> tree = new TreeSet<>();
		
		tree.add(Season.WINTER);
		tree.add(Season.SUMMER);
		tree.add(Season.SPRING);
		tree.add(Season.AUTUMN);
		tree.add(Season.WINTER);
		
		System.out.println(tree);
	}
}

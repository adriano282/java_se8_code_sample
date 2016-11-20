import java.util.*;

class SearchObjArray {
	public static void main(String[] args) {
		String[] sa = {"one", "two", "three", "four"};

		Arrays.sort(sa);
		for(String s : sa)
			System.out.print(s + " ");

		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));

		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator();
		Arrays.sort(sa, rs);

		for (String s: sa)
			System.out.print(s + " ");

		System.out.println("\none = "
							+ Arrays.binarySearch(sa, "one", rs));
	}
	static class ReSortComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			return s2.compareTo(s1);
		}
	}
}
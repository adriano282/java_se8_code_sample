import java.util.*;

class CastingListToArry {
	public static void main(String... args) {
		List<Integer> iL = new ArrayList<Integer>();
		for (int x = 0; x < 3; x++)
			iL.add(x);

		System.out.println(iL);
		Object oa = iL.toArray();

		System.out.println(oa);

		Object[] objectArray = (Object[]) oa;
		
		for (Object o : objectArray)
			System.out.println(o);

		Integer[] a1 = (Integer[]) objectArray;
		System.out.println(a1[0]);
		
	}
}

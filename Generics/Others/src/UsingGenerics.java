import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class UsingGenerics {
	public static void main(String... args) {
		String[] p = {"1", "2", "3"};
		int[] numeros = {1, 2, 3};

		List<?> list1 = new ArrayList<>(Arrays.asList(p, p)); // Compile and run
		System.out.println(list1);
		
	}
}

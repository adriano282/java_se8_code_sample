import static java.util.stream.Collectors.toList;
import java.util.*;

class Names {
	private List<String> list;
	public List<String> getList() {
		return list;
	}
	
	public void setList(List<String> list) {
		this.list = list;
	}
	
	public void printNames(String name) {
		System.out.println(name);
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
			"Bob Hope",
			"Bob Dole",
			"Bob Brown"
		);

		Names n = new Names();
		n.setList(list.stream().collect(toList()));
		n.getList().forEach(n::printNames);
	}
}

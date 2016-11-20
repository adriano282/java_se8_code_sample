import java.io.*;

class ListDirectory {
	public static void main(String ... args) throws IOException {
		String[] files = new String[100];
		File search = new File("/searchThis");
		files = search.list();

		for (String file : files) {
			System.out.println(file);
		}
	}
}

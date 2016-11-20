import java.io.*;

public class Writer2 {
	public static void main(String[] args) {
		char[] in = new char[50];
		int size = 0;
		try {
			File file = new File("fileWrite2.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Adriano de Jesus");
			pw.println("Gabriel de Jesus");
						

			fw.flush();
			fw.close();

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				System.out.println(line);
			}
	
			fr.close();
		} catch (IOException e) {

		};
	}
}

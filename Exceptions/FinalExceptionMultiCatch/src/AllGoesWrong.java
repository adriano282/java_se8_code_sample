import java.io.*;
import java.sql.*;

class AllGoesWrong {
	public static void main(String[] args) {
		AllGoesWrong a = new AllGoesWrong();
		try {
			a.blowUp();
			System.out.println("a");
		} catch (FileNotFoundException e) {
		} catch(IOException | SQLException e) {
// 			Do not permitted reasign e 
//			because in multicatch the variable is final
//			e = new IOException();

			
			System.out.println("c");
		} finally {
			System.out.println("d");
		}
	}
	void blowUp() throws IOException, SQLException {
		throw new SQLException();
	}
}

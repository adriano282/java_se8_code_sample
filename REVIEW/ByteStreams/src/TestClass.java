
import java.nio.file.*;
import java.io.*;
import static util.UtilFiles.*;

public class TestClass {
	public static void main(String...args) {
		Path p1 = Paths.get("/personal/./photos/../readme.txt");
		Path p2 = Paths.get("/personal/index.html");
		relativize(p1, p2);
		
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
		Path p4 = p1.resolve(p3);
		System.out.println(p4);

		Path p5 = p4.normalize();
		System.out.println(p5);
		System.out.println(p5.equals(p2));
		
	}
}


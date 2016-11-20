import java.nio.file.*;

class ResolveNull {
	public static void main(String... args) {
		Path path = Paths.get("/usr/bin/zip");
	// both method resolve(Path) in 
	// Path and method resolve(String) in Path match
	// Does not compile:
	//	path.resolve(null);
		System.out.println(path.resolve(Paths.get("/usr/teste")));		
	}
}

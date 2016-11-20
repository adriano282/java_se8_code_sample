class Super {
	public void robustMethod() throws AssertionError {}
}
public class ThrowsClause extends Super {
	public void robustMethod() throws Error {}
	
}
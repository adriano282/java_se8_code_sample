public class BookStore {
	private static final int taxId = 300000;
	private String name;
	public String searchBook(String criteria) {
		criteria = "teste";
		class Enumerator {
			void print() {
				System.out.println(criteria);
			}
		}
		new Enumerator().print();
		return "";
	}

	public static void main(String...args) {
		new BookStore().searchBook("adriano");
	}
}
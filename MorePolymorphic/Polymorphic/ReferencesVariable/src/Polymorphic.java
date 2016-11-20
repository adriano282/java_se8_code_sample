abstract class Widget {
	String data = "data";
	Integer number = 200;
	public void doWidgetStuff() {
	}
}

class GoodWidget extends Widget {
	String data = "big data";
	Integer number = 500;
	public void doWidgetStuff() {
		System.out.println(data + number);
	}
}

public class Polymorphic {
	public static void main(String... args) {
		//Lesson here is that the fields and static methods 
		// aren't polymorphics!!!!
		Widget w = new GoodWidget();
		w.doWidgetStuff();
		System.out.println(w.number);
		System.out.println(((GoodWidget) w).number);
	}
}

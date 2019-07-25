package chapter04;

public class AccessModifier {
	private String myRoom;
	String usHouse;
	protected String myFamily;
	public String park;

	public AccessModifier() {
	}

	public AccessModifier(String myRoom, String usHouse, String myFamily, String park) {
		// super();
		this.myRoom = myRoom;
		this.usHouse = usHouse;
		this.myFamily = myFamily;
		this.park = park;
	}

	public void print() {
		System.out.printf("room : %s\thouse : %s\tfamil : %s\tpark : %s\n", myRoom, usHouse, myFamily, park);
	}
}

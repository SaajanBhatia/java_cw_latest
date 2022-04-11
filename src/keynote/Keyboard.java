package keynote;

public class Keyboard extends Product {
	String type;
	String layout;
	
	public Keyboard(int barcode, String brand, String colour, String connec, int quantity, double origCost, double retPrice, String type, String layout) {
		// Inherit Attr's from Product
		super(barcode, brand, colour, connec, quantity, origCost, retPrice);
		
		// Keyboard Type and Country Layout
		this.type = type;
		this.layout = layout;
	}
	
}

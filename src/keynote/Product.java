package keynote;

public class Product {
	int barcode;
	String brand;
	String colour;
	String connec;
	int quantity;
	double origCost;
	double retPrice;
	
	// Set Constructor Method
	public Product(int barcode, String brand, String colour, String connec, int quantity, double origCost, double retPrice) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.connec = connec;
		this.quantity = quantity;
		this.origCost = origCost;
		this.retPrice = retPrice;
	}
}

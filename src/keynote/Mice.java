package keynote;

public class Mice extends Product {
	
	String type;
	int noButtons;

	public Mice(int barcode, String brand, String colour, String connec, int quantity, double origCost,
			double retPrice, String type, int noButtons) {
		super(barcode, brand, colour, connec, quantity, origCost, retPrice);
		
		// Type and Number of Buttons
		this.type = type;
		this.noButtons = noButtons;
	}

}

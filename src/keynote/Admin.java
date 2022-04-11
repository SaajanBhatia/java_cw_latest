package keynote;


import java.util.HashMap; // import the HashMap class



public class Admin extends User {

	public Admin(int userID, String username, String name, String[] address) {
		super(userID, username, name, address);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addNewProduct(String product, HashMap<String, String> objInfo) {
		if (product == "mouse") {
			// Declare Mouse Object
			return true;
		} 
		if (product == "keyboard") {
			// Declare Keyboard Object
			return true;
		}
		return false;
	}
	
	
	public boolean updateQuantity(int prodBarcode, int newQuantity) {
		// Find Product
		
		// Update Quantity
		return true;
	}


}

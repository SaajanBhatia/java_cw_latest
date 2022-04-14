package keynote;

import java.util.ArrayList; // import the ArrayList class

import java.util.HashMap; // import the HashMap class
import java.util.Map;



public class Customer extends User {
	
	// Storing the Product and Quantity
	public HashMap<Integer, Integer> shoppingBasket = new HashMap<Integer, Integer>();
	public ProcessFile comp = new ProcessFile();

	public Customer(int userID, String username, String name, String[] address) {
		super(userID, username, name, address);
		// TODO Auto-generated constructor stub
	}
	
	public HashMap<Integer, Integer> getBasket() {
		return this.shoppingBasket;
	}
	
	public ArrayList<String> addItemToBasket(int prodBarcode, int desiredQuantity) {
		// Result
		ArrayList<String> results = new ArrayList<String>();
		// First Check Quantity
		int prodQuantity = this.comp.getQuantity(prodBarcode);
		if (prodQuantity < desiredQuantity) {
			results.add("Product Quantity Insufficient");
			results.add("error");
		} else {
			// Decrement Stock Quantity
			this.comp.updateQuantity(prodBarcode, (prodQuantity - desiredQuantity));
			// Check if item is already in basket
			if (this.shoppingBasket.containsKey(prodBarcode)) {
				int origDesiredQuant = this.shoppingBasket.get(prodBarcode);
				this.shoppingBasket.put(prodBarcode, (origDesiredQuant+desiredQuantity));
				results.add("Updated Basket Quantity");
			} else {
				this.shoppingBasket.put(prodBarcode, desiredQuantity);
				results.add("Added Item To Basket");
			}
			results.add("success");
			
			
		}
		
		return results;
	}
	
	public ArrayList<String> removeItemFromBasket (int prodBarcode) {
		// Result
		ArrayList<String> results = new ArrayList<String>();
		
		// Get Current and Basket Quantity
		int desiredQuantity = this.shoppingBasket.get(prodBarcode);
		int currentQuantity = comp.getQuantity(prodBarcode);
		
		// Delete Product from basket if it exists in the basket
		if ( this.shoppingBasket.containsKey(prodBarcode) == false) {
			results.add("Product is not in basket");
			results.add("error");
		} else {
			this.shoppingBasket.remove(prodBarcode);
			results.add("Product Removed Successfully");
			results.add("success");
		}
		
		// Update Quantity in Stock
		comp.updateQuantity(prodBarcode, currentQuantity + desiredQuantity);
		
		

		
		// Increment Stock Quantity
		return results;
	}
	
	public boolean payment(String paymentMethod) {
		if (paymentMethod == "PAYPAL") {
			// Get PayPal UserName 
			clearBasket();
			
		} else if (paymentMethod == "CARD") {
			// Get CardNo and CVC
			clearBasket();
			
		} else {
			
		}
		
		// Redirect User to Customer Dash board
		return true;
	}
	
	public void clearBasket() {
		// Update Original Quantity in Stock File
		for (Map.Entry<Integer, Integer> set : this.shoppingBasket.entrySet()) {
			removeItemFromBasket(set.getKey());
		}
	}
	
	public ArrayList<Product> searchProducts(String searchQ){
		Misc temp = new Misc();
		ArrayList<Product> tempRes = temp.searchProducts(comp.getAllStockData(), searchQ);
		return tempRes;
	}
	
	public ArrayList<String>retrieveProductDetails(int barcode) {
		ArrayList<String> prodDetails = new ArrayList<String>(); // Create an ArrayList object
		
		Product res = comp.getProdObj(barcode);
		if (res != null) {
			prodDetails.add(res.brand);
			prodDetails.add(res.colour);
			prodDetails.add(res.connec);
		}
		// If keyboard product
		if (res instanceof Keyboard) {
			Keyboard resKb = (Keyboard) res;
			prodDetails.add("Keyboard");
			prodDetails.add(resKb.layout);
		}
		
		// If mouse product
		if (res instanceof Mice) {
			Mice resM = (Mice) res;
			prodDetails.add("Mouse"); 
			prodDetails.add(String.valueOf(resM.noButtons));
		}
		
		return prodDetails;
	}
	
}

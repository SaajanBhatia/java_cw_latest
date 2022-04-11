package keynote;

import java.util.ArrayList; // import the ArrayList class

public class Misc {
	
	public ArrayList<Product> searchProducts(ArrayList<Product> allProducts, String searchQ) {
		ArrayList<Product> searchRes = new ArrayList<Product>();
		// str1.toUpperCase().contains(str2.toUpperCase())
		
		for (int i = 0; i < allProducts.size(); i++ ) {
			
			if (allProducts.get(i) instanceof Mice) {   
				Mice tempProd = (Mice) allProducts.get(i);
				if ( searchQ.toUpperCase().contains(tempProd.brand.toUpperCase()) ) {
					if (searchQ.toUpperCase().contains("KEYBOARD") == false){
						searchRes.add((Product) allProducts.get(i));
					}
				}  
			}
			
			if (allProducts.get(i) instanceof Keyboard) {
				Keyboard tempProd = (Keyboard) allProducts.get(i);
				if ( searchQ.toUpperCase().contains(tempProd.brand.toUpperCase()) ) {
					if (searchQ.toUpperCase().contains("MOUSE") == false ) {
						searchRes.add((Product) allProducts.get(i));
					}
				}
			}
				
			
		}
		
		return searchRes;
		
		
	}

	public Misc() {
		// Searching Function 
		
	}

}

package keynote;

import java.util.ArrayList; // import the ArrayList class

public class Misc {
	
	public boolean isInt(String value) {
		return value.matches("-?\\d+");
	};
	
	public ProcessFile comp = new ProcessFile();
	
	public ArrayList<Product> searchProducts(ArrayList<Product> allProducts, String searchQ) {
		// Results Array
		ArrayList<Product> searchRes = new ArrayList<Product>();
		
		// First Check for BarCode Search
		if (isInt(searchQ)) {
			ArrayList<Integer> allBarcodes = comp.getAllProductBarcodes();
			if ( allBarcodes.contains(Integer.parseInt(searchQ)) ) {
				Product result = comp.getProdObj(Integer.parseInt(searchQ));
				searchRes.add(result);
			}
		} 
		
		// Check for brand name 
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

package keynote;


// Main Class 
// Used for Storing Global Variables, Reading and Writing to Files, 


//  with ArrayList


public class Main {



	public Main() {
		
	}


	public static void main(String[] args) {
		System.out.println("Initialising Project ...");
		ProcessFile comp = new ProcessFile();
		
		// User Login
		User sysUser = comp.userLogin("102", "user2");
		
		// If user does not exist
		if (sysUser == null) {
			System.out.print("User does not exist");
		} else {
			// User signed in successfully
			System.out.println("User has signed in");
			//System.out.println(sysUser.getClass().getSimpleName());
			if (sysUser instanceof Customer) {
				Customer customerUser = (Customer) sysUser;
				System.out.println(customerUser.addItemToBasket(112233, 5));
				System.out.println(customerUser.addItemToBasket(112233, 6));
				System.out.println(customerUser.getBasket());
				System.out.println(customerUser.addItemToBasket(123456, 1));
				System.out.println(customerUser.getBasket());
				System.out.println(customerUser.removeItemFromBasket(112233));
				System.out.println(customerUser.getBasket());
				customerUser.clearBasket();
				
				
			}
			
		}
		
		
		
		
		// Keyboard newProd = new Keyboard(101709, "Dell", "Blue", "Wireless", 19, 15.5, 20, "Gaming", "UK");
		// boolean well = comp.addKeyboardToStock(newProd);
		// System.out.println(well);
		
		
		
		
		
		
				
		
		
	}

}

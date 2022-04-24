package keynote;

// This file will read and write to the text files

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedWriter; // For writing to files

// Working with ArrayList
import java.util.ArrayList; // import the ArrayList class




public class ProcessFile {
	
	public void formatStockFile() {
	    // First Read file
	    ArrayList<String> fileContents = new ArrayList<String>();

	    try {
	      File fileObj = new File("./Stock.txt");
	      Scanner myReader = new Scanner(fileObj);
	      while (myReader.hasNextLine()) {
	        String line = myReader.nextLine();
	        if (line != "") {
	          fileContents.add(line);
	        } 
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    
	   

	    // Rewrite to file
	    try {
		      FileWriter myWriter = new FileWriter("./Stock.txt");
		      BufferedWriter bw = new BufferedWriter(myWriter);
		      for (int k = 0; k < fileContents.size(); k ++) {
		        bw.write(fileContents.get(k));
		        bw.newLine();
		      }
		      bw.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	    
	  }
	
	
	public ArrayList<Product> bubbleSort(ArrayList<Product> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j).retPrice > arr.get(j+1).retPrice) {
                    Product temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
        return arr;
    }
	
	public ArrayList<Product> getAllStockData() {
		// Declare Array containing All Products
		ArrayList<Product> allProducts = new ArrayList<Product>();
		
		// Try Read Stock.txt
		try {
			File stockObj = new File("Stock.txt");
			Scanner fileReader = new Scanner(stockObj);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				String mouse = new String("mouse");
				String keyboard = new String("keyboard");
				
				// Declare a Mouse Object
				if (items[1].equals(mouse) ) {
					Mice obj = new Mice( Integer.parseInt(items[0]), items[3], items[4], items[5], Integer.parseInt(items[6]), Double.parseDouble(items[7]), Double.parseDouble(items[8]), items[2], Integer.parseInt(items[9]) );
					allProducts.add(obj);
				}  
				
				// Declare a Keyboard Object
				if (items[1].equals(keyboard) ){
					Keyboard obj = new Keyboard( Integer.parseInt(items[0]), items[3], items[4], items[5], Integer.parseInt(items[6]), Double.parseDouble(items[7]), Double.parseDouble(items[8]), items[2], items[9] );
					allProducts.add(obj);
				}
			
				// Produce
								
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// If the file can't be found, return a File Error and return the error trace
			System.out.println("File Error");
			e.printStackTrace();
		}
		
		return bubbleSort(allProducts);
	}
	
	public Product getProdObj(int barcode) {
		ArrayList<Product> allProducts = getAllStockData();
		for (int i = 0; i < allProducts.size(); i++ ) {
			if (allProducts.get(i).barcode == barcode) {
				return allProducts.get(i);
			}
		}
		Product emptyRes = null;
		return emptyRes;
	}
	
	
	public int getQuantity(int barcode) {
		// Get All Stock Data
		ArrayList<Product> data = getAllStockData();
		for (int i = 0; i < data.size(); i++ ) {
			if ( (data.get(i).barcode) == barcode) {
				// Once at the correct item, return the quantity
				return data.get(i).quantity;
			}
		}
		// If the item does not exist, return -1
		return -1;
	}
	
	public boolean updateQuantity(int barcode, int quantity) {
		
		// Read contents into ArrayList<String>
	    ArrayList<String[]> fileContents = new ArrayList<String[]>();
	    try {
	      File myObj = new File("Stock.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] array = data.split(", ", -1); 
	        fileContents.add(array);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

	    for (int i = 0; i < fileContents.size(); i ++){
	      String[] product = fileContents.get(i);
	      if (product[0].equals(String.valueOf(barcode))) {
	        product[6] = String.valueOf(quantity);
	        fileContents.set(i, product);
	      };
	    }

	    // Write to file
	    try {
	      FileWriter myWriter = new FileWriter("Stock.txt");
	      BufferedWriter bw = new BufferedWriter(myWriter);
	      for (int k = 0; k < fileContents.size(); k ++) {
	        bw.write(
	          String.join(", ", fileContents.get(k))
	        );
	        bw.newLine();
	      }
	      bw.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	    return true;
	}
	
	public ArrayList<Integer> getAllProductBarcodes() {
		ArrayList<Integer> allBarcodes = new ArrayList<Integer>();
		
		try {
			File barObj = new File("Stock.txt");
			Scanner fileReader = new Scanner(barObj);
			
			while (fileReader.hasNextLine()) {
				
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				allBarcodes.add(Integer.parseInt( items[0] ));
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// If the file can't be found, return a File Error and return the error trace
			System.out.println("File Error");
			e.printStackTrace();
		}
		
		return allBarcodes;		
	}
	
	public boolean addKeyboardToStock(Keyboard prodObj) {
		
		// First Make Sure product id doesn't already exist
		ArrayList<Integer> allBarcodes = getAllProductBarcodes();
		for (int i = 0; i < allBarcodes.size(); i++) {
			if (allBarcodes.get(i) == prodObj.barcode) {
				System.out.println("Barcode already exists");
				return false;
			}
		}
		
		try {
	      FileWriter myWriter = new FileWriter("Stock.txt", true);
	      BufferedWriter lineWriter = new BufferedWriter(myWriter);
	      
	      // Add Details to Product
	      String[] newProduct = new String[]{
	    		  String.valueOf(prodObj.barcode), 
	    		  "keyboard", 
	    		  prodObj.type, 
	    		  prodObj.brand, 
	    		  prodObj.colour, 
	    		  prodObj.connec, 
	    		  String.valueOf(prodObj.quantity), 
	    		  String.valueOf(prodObj.origCost), 
	    		  String.valueOf(prodObj.retPrice), 
	    		  prodObj.layout
	      };
	      
	      String newLine = String.join(", ", newProduct);
	      lineWriter.write(newLine);
	      lineWriter.newLine();
	      lineWriter.close();
	      
	      System.out.println("Successfully wrote to the file.");
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		return true;
	}
	
	public boolean addMouseToStock(Mice prodObj) {
		
		// First Make Sure product id doesn't already exist
		ArrayList<Integer> allBarcodes = getAllProductBarcodes();
		for (int i = 0; i < allBarcodes.size(); i++) {
			if (allBarcodes.get(i) == prodObj.barcode) {
				System.out.println("Barcode already exists");
				return false;
			}
		}
				
		
		try {
			FileWriter myWriter = new FileWriter("Stock.txt", true);
			BufferedWriter lineWriter = new BufferedWriter(myWriter);
			
			String[] newProduct = new String[] {
					String.valueOf(prodObj.barcode),
					"mouse",
					prodObj.type,
					prodObj.brand,
					prodObj.colour,
					prodObj.connec,
					String.valueOf(prodObj.quantity),
					String.valueOf(prodObj.origCost),
					String.valueOf(prodObj.retPrice),
					String.valueOf(prodObj.noButtons)
			};
			
			String newLine = String.join(", ", newProduct);
			lineWriter.write(newLine);
			lineWriter.newLine();
			lineWriter.close();
			
			System.out.println("Successfully added mouse");
			
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		return true;
	}
	
	
	public ArrayList<String> verifyUser(String userID, String username) {
		ArrayList<String> result = new ArrayList<String>();;
		
		try {
			File userObj = new File("UserAccounts.txt");
			Scanner fileReader = new Scanner(userObj);
			
			while ( fileReader.hasNextLine() ) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				if (items[0].equals(userID) && items[1].equals(username) ) {
					result.add("found");
					if ( items[6].equals("admin") ) {
						result.add("admin");
					} else {
						result.add("customer");
					}
				} 
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	
	public String[] getAllUsernames(){
		ArrayList<String> usernames = new ArrayList<String>();
		
		try {
			File userObj = new File("UserAccounts.txt");
			Scanner fileReader = new Scanner(userObj);
			
			while ( fileReader.hasNextLine() ) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				// Add user to array
				usernames.add(items[1]);
				
				
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Convert to String Array
		String[] usernamesStrArr = new String[usernames.size()];
		usernamesStrArr = usernames.toArray(usernamesStrArr);
		
		
		return usernamesStrArr;
	}
	
	public String[] getAllUserIDs(){
		ArrayList<String> userIds = new ArrayList<String>();
		
		try {
			File userObj = new File("UserAccounts.txt");
			Scanner fileReader = new Scanner(userObj);
			
			while ( fileReader.hasNextLine() ) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				// Add user to array
				userIds.add(items[0]);
				
				
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Convert to String Array
		String[] userIdsArr = new String[userIds.size()];
		userIdsArr = userIds.toArray(userIdsArr);
		
		
		return userIdsArr;
	}
	
	public Customer getCustomerObj(String userID) {
		Customer userAcc = null;
		
		try {
			File custObj = new File("UserAccounts.txt");
			Scanner fileReader = new Scanner(custObj);
			
			while ( fileReader.hasNextLine() ) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				if ( items[0].equals(userID) ) {
					String[] addr = { items[3],items[4],items[5] };
					userAcc = new Customer( Integer.parseInt(userID), items[1], items[2], addr );
				}
				
			}
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userAcc;
		
	}
	
	
	public Admin getAdminObj(String userID) {
		Admin userAcc = null;
		
		try {
			File adminObj = new File("UserAccounts.txt");
			Scanner fileReader = new Scanner(adminObj);
			
			while ( fileReader.hasNextLine() ) {
				String data = fileReader.nextLine();
				String[] items = data.split(",");
				
				// Get rid of blank space in string items
				for ( int i=0 ; i < items.length ; i++ ) {
					items[i] = items[i].replace(" ","");
					items[i] = new String(items[i]);
				};
				
				if ( items[0].equals(userID) ) {
					String[] addr = { items[3],items[4],items[5] };
					userAcc = new Admin( Integer.parseInt(userID), items[1], items[2], addr );
				}
				
			}
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userAcc;
		
	}
	
	public User userLogin(String userID, String username) {
		
		User sysUser = null;
		
		ArrayList<String> result = verifyUser(userID, username);
		if (result.isEmpty()) {
			return sysUser;
		} else {
			// Get User Details
			if (result.get(1).equals("customer")) {
				sysUser = (Customer) getCustomerObj( new String(userID) );
			} else {
				sysUser = (Admin) getAdminObj( new String(userID) );
			}
		}
		
		return sysUser;
		
	}
	
	
	
	
	
	// Another that returns customer gets customer details
	

	public ProcessFile() {
		// TODO Auto-generated constructor stub
	}

}

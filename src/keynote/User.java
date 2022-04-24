package keynote;

import java.util.ArrayList;

// Store Address 
import java.util.HashMap; // import the HashMap class



public class User {
	public int userID;
	public String username;
	protected String name;
	private HashMap<String, String> address = new HashMap<String, String>();
	
	// Constructor Method
	public User(int userID, String username, String name, String[] address) {
		this.userID = userID;
		this.username = username;
		this.name = name;
		this.address.put("houseNo", address[0]);
		this.address.put("postCode", address[1]);
		this.address.put("city", address[2]);
	}
	
	// Get Method
	public HashMap<String, String> getAddress() {
		return this.address;
	}
	
	public String getStrAddress() {
		String addr = new String(this.address.get("houseNo") + " " + this.address.get("postCode") + ", " + this.address.get("city"));
		return addr;
	}
	
	// Get Method
	public String getName() {
		return this.name;
	}
	
	
	
	

}

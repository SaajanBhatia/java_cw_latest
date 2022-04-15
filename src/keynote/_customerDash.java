package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel; // import the ArrayList class


public class _customerDash{

	private JFrame frame;
	private JTextField search_customer_query;
	private JTextField add_barcode_inp;
	private JTextField del_barcode_inp;
	public ProcessFile comp = new ProcessFile();
	public Customer sysCustomer = null;
	public JTree shopping_tree;
	public JLabel success_lbl_customer;
	public JLabel totalCostLbl;
	
	public String[] protocol = {"CUSTOMER"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_customerDash window = new _customerDash(args[0]);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean isInt(String value) {
		return value.matches("-?\\d+");
	}
	
	public static void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}

	/**
	 * Create the application.
	 * @param userID 
	 */
	public _customerDash(String userID) {
		this.sysCustomer = comp.getCustomerObj("101");
		t.start();
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1197, 709);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Customer Dashboard");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(51,50,50));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		search_customer_query = new JTextField();
		search_customer_query.setBounds(365, 65, 235, 36);
		desktopPane.add(search_customer_query);
		search_customer_query.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(299, 63, 75, 36);
		desktopPane.add(lblNewLabel_1);
		
		JButton search_customer_sbt_btn = new JButton("Go");
		search_customer_sbt_btn.setForeground(Color.WHITE);
		search_customer_sbt_btn.setBackground(new Color(67, 127, 151));
		search_customer_sbt_btn.setBounds(610, 67, 61, 33);
		desktopPane.add(search_customer_sbt_btn);
		
		
		DefaultTreeModel shopping_basket = new DefaultTreeModel(updateShoppingTree());
		shopping_tree = new JTree(shopping_basket);
		
		shopping_tree.setShowsRootHandles(true);
		shopping_tree.setEditable(true);
		shopping_tree.setBackground(Color.GRAY);
		shopping_tree.setBounds(797, 84, 363, 444);
		desktopPane.add(shopping_tree);
		
		JLabel basket_lbl = new JLabel("Basket");
		basket_lbl.setForeground(Color.WHITE);
		basket_lbl.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		basket_lbl.setBounds(797, 37, 363, 36);
		desktopPane.add(basket_lbl);
		
		JButton logout_btn = new JButton("Exit");
		logout_btn.setForeground(Color.WHITE);
		logout_btn.setBackground(new Color(67, 127, 151));
		logout_btn.setBounds(24, 581, 166, 33);
		desktopPane.add(logout_btn);
		
		JButton pay_btn_card = new JButton("Pay by Card");
		pay_btn_card.setForeground(Color.WHITE);
		pay_btn_card.setBackground(new Color(67, 127, 151));
		pay_btn_card.setBounds(608, 440, 166, 33);
		desktopPane.add(pay_btn_card);
		
		JButton pay_btn_paypal = new JButton("Pay by PayPal");
		pay_btn_paypal.setForeground(Color.WHITE);
		pay_btn_paypal.setBackground(new Color(67, 127, 151));
		pay_btn_paypal.setBounds(608, 495, 166, 33);
		desktopPane.add(pay_btn_paypal);
		
		add_barcode_inp = new JTextField();
		add_barcode_inp.setColumns(10);
		add_barcode_inp.setBounds(156, 204, 150, 36);
		desktopPane.add(add_barcode_inp);
		
		JLabel lblNewLabel_1_2 = new JLabel("Add Product");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(45, 157, 118, 36);
		desktopPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Type Barcode :");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(43, 203, 103, 36);
		desktopPane.add(lblNewLabel_1_2_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(316, 204, 47, 36);
		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		desktopPane.add(spinner);
		
		JButton add_prod_btn = new JButton("Add Product");
		add_prod_btn.setForeground(Color.WHITE);
		add_prod_btn.setBackground(new Color(67, 127, 151));
		add_prod_btn.setBounds(381, 206, 166, 33);
		desktopPane.add(add_prod_btn);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Type Barcode :");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(43, 342, 103, 36);
		desktopPane.add(lblNewLabel_1_2_1_1);
		
		del_barcode_inp = new JTextField();
		del_barcode_inp.setColumns(10);
		del_barcode_inp.setBounds(156, 343, 207, 36);
		desktopPane.add(del_barcode_inp);
		
		JButton del_prod_btn = new JButton("Delete Product");
		del_prod_btn.setForeground(Color.WHITE);
		del_prod_btn.setBackground(new Color(67, 127, 151));
		del_prod_btn.setBounds(381, 345, 166, 33);
		desktopPane.add(del_prod_btn);
		
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Delete Product");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBounds(43, 295, 118, 36);
		desktopPane.add(lblNewLabel_1_2_2);
		
		JButton clear_basket = new JButton("Clear Basket");
		clear_basket.setForeground(Color.WHITE);
		clear_basket.setBackground(new Color(67, 127, 151));
		clear_basket.setBounds(608, 380, 166, 33);
		desktopPane.add(clear_basket);
		
		JLabel error_lbl_customer = new JLabel("");
		error_lbl_customer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		error_lbl_customer.setForeground(new Color(255, 0, 0));
		error_lbl_customer.setBounds(45, 460, 393, 44);
		desktopPane.add(error_lbl_customer);
		
		success_lbl_customer = new JLabel("");
		success_lbl_customer.setForeground(Color.GREEN);
		success_lbl_customer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		success_lbl_customer.setBounds(45, 407, 393, 44);
		desktopPane.add(success_lbl_customer);
		
		// Total Cost
		
		totalCostLbl = new JLabel("Total Cost: \u00A3 0.00");
		totalCostLbl.setForeground(Color.WHITE);
		totalCostLbl.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		totalCostLbl.setBounds(797, 539, 192, 44);
		desktopPane.add(totalCostLbl);
		
		
		// User Logs Out
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent log_e) {
				System.exit(0);
			}
		});
		
		// Search Function
		search_customer_sbt_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear any messages on screen
				clearMessages(success_lbl_customer, error_lbl_customer);
				
				String searchQ = search_customer_query.getText();
				ArrayList<Product> searchResults = sysCustomer.searchProducts(searchQ);
				_searchResults searchInstance = new _searchResults();
				searchInstance.initialize(searchResults);
				passMsg("Successfully produced search results", success_lbl_customer);
			}
		});
		
		// User Adds Product to Basket
		add_prod_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear any messages on screen
				clearMessages(success_lbl_customer, error_lbl_customer);
				
				String prodBarcode = add_barcode_inp.getText();
				// If input is invalid
				if (isInt(prodBarcode) == false) {
					passMsg("Barcode should contain only numbers.", error_lbl_customer);
				} else {
					// Get result from method
					ArrayList<String> res = sysCustomer.addItemToBasket(Integer.parseInt(prodBarcode), (Integer) spinner.getValue());
					// If Success
					if (res.get(1) == "success") {
						String succMsg = String.format("Product %s Successfully added to basket", prodBarcode);
						passMsg(succMsg, success_lbl_customer);
						
						// Update Tree
						DefaultTreeModel model = (DefaultTreeModel)shopping_tree.getModel();
						model.setRoot(updateShoppingTree());
						model.reload();
						
						// Update Total Cost
						updateTotalCostLbl(totalCostLbl);
						
					// If error then pass error message
					} else {
						passMsg(res.get(0), error_lbl_customer);
					}
				}
				
					
				
				
				
			}
		});
		
		// User takes product out of basket
		del_prod_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent log_del) {
				// Clear any messages on screen
				clearMessages(success_lbl_customer, error_lbl_customer);
				
				String prodBarcode = del_barcode_inp.getText();
				
				// If input is invalid
				if (isInt(prodBarcode) == false) {
					passMsg("Barcode should contain only numbers.", error_lbl_customer);
				} else {
					// Get result from method
					ArrayList<String> res = sysCustomer.removeItemFromBasket(Integer.parseInt(prodBarcode));
					if (res.get(1) == "error" ) {
						passMsg(res.get(0), error_lbl_customer);
					} else {
						passMsg(res.get(0), success_lbl_customer);
						
						// Success -> Update Tree
						DefaultTreeModel model = (DefaultTreeModel)shopping_tree.getModel();
						model.setRoot(updateShoppingTree());
						model.reload();
						
						// Update Total Cost
						updateTotalCostLbl(totalCostLbl);
						
						
					}
				}
			}
		});
		
		// Clear Basket
		clear_basket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_clear) {
				// Clear any messages on screen
				clearMessages(success_lbl_customer, error_lbl_customer);
				
				sysCustomer.clearBasket();
				passMsg("CLEARED BASKET", success_lbl_customer);
				
				// Update Tree
				DefaultTreeModel model = (DefaultTreeModel)shopping_tree.getModel();
				model.setRoot(updateShoppingTree());
				model.reload();
			
			}
		});
		
		
		// Card Payment Method
		pay_btn_card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_getCard cardPayment = new _getCard(sysCustomer);
				cardPayment.run();
				
				
				
			}
		});
		
		// PayPal Payment Method
		pay_btn_paypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_getPaypal paypalPayment = new _getPaypal(sysCustomer);
				paypalPayment.run();
			}
		});		
		
	}
	
	
	
	
	// Function to update tree
	public DefaultMutableTreeNode updateShoppingTree() {
						
		// New Root
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Basket (double click barcode to expand)");		
		
		// Get Basket
		HashMap<Integer, Integer> shoppingBasket = sysCustomer.getBasket();
		
		for (Map.Entry<Integer, Integer> set : shoppingBasket.entrySet()) {
			DefaultMutableTreeNode prodCode = new DefaultMutableTreeNode(set.getKey());
			
			// Get Product Details Brief for Basket Display
			ArrayList<String> prodDetails = sysCustomer.retrieveProductDetails(set.getKey());
			String quantityStr = String.format("Quantity: %s", set.getValue());
						
			if (prodDetails.get(3).equals("Keyboard")) {
				String itemStr = prodDetails.get(0) + " " + "Keyboard " + prodDetails.get(1).toUpperCase() + " " + prodDetails.get(2).substring(0,1).toUpperCase() + prodDetails.get(2).substring(1);
				prodCode.add(new DefaultMutableTreeNode( itemStr ));
				prodCode.add(new DefaultMutableTreeNode( "Layout: " + prodDetails.get(4).toUpperCase() ));
			} else {
				String itemStr = prodDetails.get(0) + " " + "Mouse " + prodDetails.get(1).toUpperCase() + " " + prodDetails.get(2).substring(0,1).toUpperCase() + prodDetails.get(2).substring(1);
				prodCode.add(new DefaultMutableTreeNode( itemStr ));
				prodCode.add(new DefaultMutableTreeNode( "No. Buttons: " + prodDetails.get(4)));
			}
			
			
			prodCode.add(new DefaultMutableTreeNode( quantityStr ));
			
			// Cost of Product
			double prodCost = Double.parseDouble(prodDetails.get(5)) * set.getValue();
			String costStr = String.format("Price: \u00A3 %.2f", prodCost);
			prodCode.add(new DefaultMutableTreeNode( costStr ));
			
			// Add product to root
			root.add(prodCode);
		}
		
		
		return root;
	}
	
	// Listening Function that checks whether the payment is successful
	Thread t = new Thread(new Runnable() {
	    public void run() {
	    	while (true) {
	    		if (sysCustomer.paymentSuccess) {
	    			
	    			// Clear Tree
	    			DefaultTreeModel model = (DefaultTreeModel)shopping_tree.getModel();
					model.setRoot(updateShoppingTree());
					model.reload();
					
					// Pass Success Message
					passMsg("Checkout Successful", success_lbl_customer);
					
					// Reset Payment Success
					sysCustomer.paymentSuccess = false; 
					
					// Update total cost
					updateTotalCostLbl(totalCostLbl);
	    		}
		    	pause(800);
	    	}
	    }
	});
	
	

	
	
	// Update Total Cost
	public void updateTotalCostLbl(JLabel label) {
		String totalCostStr = String.format("Total Cost: \u00A3 %.2f", sysCustomer.getTotalBasketPrice());
		label.setText(totalCostStr);
	}
	
	// Pass error/success message
	public void passMsg(String msg, JLabel label) {
		label.setText(msg);
	};
	
	// Clear Messages
	public void clearMessages(JLabel success, JLabel error) {
		success.setText("");
		error.setText("");
	}
	
	
}

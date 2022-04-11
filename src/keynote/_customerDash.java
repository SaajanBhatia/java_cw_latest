package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

import java.util.ArrayList;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel; // import the ArrayList class


public class _customerDash {

	private JFrame frame;
	private JTextField search_customer_query;
	private JTextField add_barcode_inp;
	private JTextField del_barcode_inp;
	public ProcessFile comp = new ProcessFile();
	public Customer sysCustomer = null;
	
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
	
	public boolean tryParseInt(String value) {
	    try {
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	/**
	 * Create the application.
	 * @param userID 
	 */
	public _customerDash(String userID) {
		this.sysCustomer = comp.getCustomerObj(userID);
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
		search_customer_sbt_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchQ = search_customer_query.getText();
				ArrayList<Product> searchResults = sysCustomer.searchProducts(searchQ);
				_searchResults searchInstance = new _searchResults();
				searchInstance.initialize(searchResults);
			}
		});
		search_customer_sbt_btn.setForeground(Color.WHITE);
		search_customer_sbt_btn.setBackground(new Color(67, 127, 151));
		search_customer_sbt_btn.setBounds(610, 67, 61, 33);
		desktopPane.add(search_customer_sbt_btn);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		//ArrayList<DefaultMutableTreeNode> shoppingItems = new ArrayList<DefaultMutableTreeNode>();
		for (int i = 0;i < 5; i++) {
			DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode("Vegetables");
			DefaultMutableTreeNode tempNode2 = new DefaultMutableTreeNode("Carrot");
			tempNode.add(tempNode2);
			root.add(tempNode);
		}
		
		JTree shopping_tree = new JTree(root);
		shopping_tree.setBackground(Color.GRAY);
		shopping_tree.setBounds(797, 84, 363, 444);
		desktopPane.add(shopping_tree);
		
		JLabel basket_lbl = new JLabel("Basket");
		basket_lbl.setForeground(Color.WHITE);
		basket_lbl.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		basket_lbl.setBounds(797, 37, 363, 36);
		desktopPane.add(basket_lbl);
		
		JButton logout_btn = new JButton("Logout");
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
		pay_btn_paypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

		JLabel error_lbl_customer = new JLabel("");
		error_lbl_customer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		error_lbl_customer.setForeground(new Color(255, 0, 0));
		error_lbl_customer.setBounds(45, 460, 393, 44);
		desktopPane.add(error_lbl_customer);
		
		add_prod_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prodBarcode = add_barcode_inp.getText();
				if (tryParseInt(prodBarcode) == false) {
					error_lbl_customer.setText("Please Type Integer Barcode");
				} else {
					int quantity = (Integer) spinner.getValue();
					sysCustomer.addItemToBasket(Integer.parseInt(prodBarcode), quantity);
				}
				
				
				
			}
		});
		
		
		
		JButton clear_basket = new JButton("Clear Basket");
		clear_basket.setForeground(Color.WHITE);
		clear_basket.setBackground(new Color(67, 127, 151));
		clear_basket.setBounds(608, 380, 166, 33);
		desktopPane.add(clear_basket);
	}
}

package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _adminDash {

	private JFrame frame;
	private JTextField barcode_admin_inp;
	private JTextField brand_admin_inp;
	private JTextField colour_admin_inp;
	private JTextField connec_admin_inp;
	private JTextField quantity_admin_inp;
	private JTextField origCost_admin_inp;
	private JTextField retPrice_admin_inp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField keyLayout_admin_inp;
	private JTextField numBtns_admin_inp;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_adminDash window = new _adminDash();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public _adminDash() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1271, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(51,50,50));
		scrollPane.setViewportView(desktopPane);
		
		JLabel lbl_barcode = new JLabel("Barcode");
		lbl_barcode.setForeground(Color.WHITE);
		lbl_barcode.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_barcode.setBounds(87, 107, 63, 19);
		desktopPane.add(lbl_barcode);
		
		JLabel lbl_brand = new JLabel("Brand");
		lbl_brand.setForeground(Color.WHITE);
		lbl_brand.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_brand.setBounds(87, 137, 44, 19);
		desktopPane.add(lbl_brand);
		
		JLabel lbl_colour = new JLabel("Colour");
		lbl_colour.setForeground(Color.WHITE);
		lbl_colour.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_colour.setBounds(87, 167, 50, 19);
		desktopPane.add(lbl_colour);
		
		JLabel lbl_connec = new JLabel("Connectivity");
		lbl_connec.setForeground(Color.WHITE);
		lbl_connec.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_connec.setBounds(87, 197, 94, 19);
		desktopPane.add(lbl_connec);
		
		JLabel lbl_quantity = new JLabel("Quantity");
		lbl_quantity.setForeground(Color.WHITE);
		lbl_quantity.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_quantity.setBounds(87, 227, 63, 19);
		desktopPane.add(lbl_quantity);
		
		JLabel lbl_orig_cost = new JLabel("Original Cost");
		lbl_orig_cost.setForeground(Color.WHITE);
		lbl_orig_cost.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_orig_cost.setBounds(87, 257, 97, 19);
		desktopPane.add(lbl_orig_cost);
		
		JLabel lcl_ret_price = new JLabel("Retail Price");
		lcl_ret_price.setForeground(Color.WHITE);
		lcl_ret_price.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lcl_ret_price.setBounds(87, 287, 87, 19);
		desktopPane.add(lcl_ret_price);
		
		barcode_admin_inp = new JTextField();
		barcode_admin_inp.setColumns(10);
		barcode_admin_inp.setBounds(215, 108, 133, 20);
		desktopPane.add(barcode_admin_inp);
		
		brand_admin_inp = new JTextField();
		brand_admin_inp.setColumns(10);
		brand_admin_inp.setBounds(215, 138, 133, 20);
		desktopPane.add(brand_admin_inp);
		
		colour_admin_inp = new JTextField();
		colour_admin_inp.setColumns(10);
		colour_admin_inp.setBounds(215, 168, 133, 20);
		desktopPane.add(colour_admin_inp);
		
		connec_admin_inp = new JTextField();
		connec_admin_inp.setColumns(10);
		connec_admin_inp.setBounds(215, 198, 133, 20);
		desktopPane.add(connec_admin_inp);
		
		quantity_admin_inp = new JTextField();
		quantity_admin_inp.setColumns(10);
		quantity_admin_inp.setBounds(215, 228, 133, 20);
		desktopPane.add(quantity_admin_inp);
		
		origCost_admin_inp = new JTextField();
		origCost_admin_inp.setColumns(10);
		origCost_admin_inp.setBounds(215, 258, 133, 20);
		desktopPane.add(origCost_admin_inp);
		
		retPrice_admin_inp = new JTextField();
		retPrice_admin_inp.setColumns(10);
		retPrice_admin_inp.setBounds(215, 288, 133, 20);
		desktopPane.add(retPrice_admin_inp);
		
		JLabel AddProduct_lbl = new JLabel("Add Product");
		AddProduct_lbl.setForeground(Color.WHITE);
		AddProduct_lbl.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		AddProduct_lbl.setBounds(87, 58, 177, 38);
		desktopPane.add(AddProduct_lbl);
		
		JRadioButton keyboard_radio = new JRadioButton("Keyboard");
		buttonGroup.add(keyboard_radio);
		keyboard_radio.setForeground(Color.WHITE);
		keyboard_radio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		keyboard_radio.setBackground(new Color(67,127,151));
		keyboard_radio.setBounds(87, 344, 109, 23);
		desktopPane.add(keyboard_radio);
		
		JRadioButton mouse_radio = new JRadioButton("Mouse");
		buttonGroup.add(mouse_radio);
		mouse_radio.setForeground(Color.WHITE);
		mouse_radio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		mouse_radio.setBackground(new Color(67, 127, 151));
		mouse_radio.setBounds(215, 344, 109, 23);
		desktopPane.add(mouse_radio);
		
		JLabel lcl_ret_price_1 = new JLabel("Keyboard Layout");
		lcl_ret_price_1.setForeground(Color.WHITE);
		lcl_ret_price_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lcl_ret_price_1.setBounds(60, 419, 158, 19);
		desktopPane.add(lcl_ret_price_1);
		
		keyLayout_admin_inp = new JTextField();
		keyLayout_admin_inp.setColumns(10);
		keyLayout_admin_inp.setBounds(228, 418, 133, 20);
		desktopPane.add(keyLayout_admin_inp);
		
		JLabel lcl_ret_price_1_1 = new JLabel("Number of Buttons");
		lcl_ret_price_1_1.setForeground(Color.WHITE);
		lcl_ret_price_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lcl_ret_price_1_1.setBounds(60, 450, 158, 19);
		desktopPane.add(lcl_ret_price_1_1);
		
		numBtns_admin_inp = new JTextField();
		numBtns_admin_inp.setColumns(10);
		numBtns_admin_inp.setBounds(228, 449, 133, 20);
		desktopPane.add(numBtns_admin_inp);
		
		JButton addProduct_admin_btn = new JButton("Add Product");
		addProduct_admin_btn.setForeground(Color.WHITE);
		addProduct_admin_btn.setBackground(new Color(67, 127, 151));
		addProduct_admin_btn.setBounds(137, 514, 166, 33);
		desktopPane.add(addProduct_admin_btn);
		
		keyboard_radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcl_ret_price_1_1.setEnabled(false);
				numBtns_admin_inp.setEnabled(false);
				lcl_ret_price_1.setEnabled(true);
				keyLayout_admin_inp.setEnabled(true);
				
			}
		});
		
		mouse_radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcl_ret_price_1_1.setEnabled(true);
				numBtns_admin_inp.setEnabled(true);
				lcl_ret_price_1.setEnabled(false);
				keyLayout_admin_inp.setEnabled(false);
			}
		});
		
		// sample 
		// Table Set Up
		String[] columnNames = {"Barcode", "Product", "Type", "Brand", "Colour", "Connectivity", "Original Cost", "Retail Price", "Quantity","No Buttons","Layout"};
		String[][] egData = {
				{"1011","Mouse","Gaming","Logitech","White","Wireless","40","50","13","1","N/A"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"1011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"2011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"2011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"2011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"2011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"3011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
				{"4011","Keyboard","Comfort","Logitech","Black","Wired","40","50","13","N/A","UK"},
		};
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(417, 91, 793, 500);
		tablePanel.setLayout(new BorderLayout());
		JTable admin_all_products_table = new JTable(egData, columnNames);
		admin_all_products_table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		admin_all_products_table.setForeground(Color.WHITE);
		admin_all_products_table.setBackground(Color.DARK_GRAY);
		admin_all_products_table.setFillsViewportHeight(true);
		admin_all_products_table.setShowVerticalLines(false);
		
		JScrollPane pane = new JScrollPane(admin_all_products_table);
		tablePanel.add(pane, BorderLayout.CENTER);
		desktopPane.add(tablePanel);
		
		JButton logout_btn = new JButton("Logout");
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logout_btn.setForeground(Color.WHITE);
		logout_btn.setBackground(new Color(67, 127, 151));
		logout_btn.setBounds(15, 586, 166, 33);
		desktopPane.add(logout_btn);
		desktopPane.setVisible(true);
		
		
		
	}
}

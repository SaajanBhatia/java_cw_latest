package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public JTable admin_all_products_table;
	
	// Check if integer data type
	public boolean isInt(String value) {
		return value.matches("-?\\d+");
	}
	
	public boolean isDouble(String value) {
		return value.matches("([0-9]*)\\.([0-9]*)");
	}
	
	// Administrator Class Declaration - The program assumes there is only ONE administrator
	public Admin sysAdmin;
	
	public ProcessFile comp = new ProcessFile();
	private JTextField type_admin_inp;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_adminDash window = new _adminDash(sysAdmin);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// Function to format ArrayList for table use
	public String[][] formatDataAdmin(ArrayList<Product> data) {
		String[][] finalRes = new String[data.size()][11];
		for (int i = 0; i < data.size(); i ++) {
			if (data.get(i) instanceof Keyboard) {
				Keyboard res = (Keyboard) data.get(i);
				finalRes[i] = new String[] {String.valueOf(data.get(i).barcode),data.get(i).getClass().getSimpleName(), res.type ,data.get(i).brand, data.get(i).colour, data.get(i).connec, String.valueOf(data.get(i).origCost), String.valueOf(data.get(i).retPrice), String.valueOf(data.get(i).quantity), "N/A", res.layout};
			} else {
				Mice res = (Mice) data.get(i);
				finalRes[i] = new String[] {String.valueOf(data.get(i).barcode),data.get(i).getClass().getSimpleName(), res.type, data.get(i).brand, data.get(i).colour, data.get(i).connec, String.valueOf(data.get(i).origCost), String.valueOf(data.get(i).retPrice), String.valueOf(data.get(i).quantity), String.valueOf(res.noButtons), "N/A"}; 
			}
			
		}
		
		return finalRes;
		
		
		
	}
	

	/**
	 * Create the application.
	 */
	public _adminDash(Admin sysAdmin) {
		this.sysAdmin = sysAdmin;
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
		lbl_barcode.setBounds(87, 107, 131, 19);
		desktopPane.add(lbl_barcode);
		
		JLabel lbl_brand = new JLabel("Brand");
		lbl_brand.setForeground(Color.WHITE);
		lbl_brand.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_brand.setBounds(87, 137, 131, 19);
		desktopPane.add(lbl_brand);
		
		JLabel lbl_colour = new JLabel("Colour");
		lbl_colour.setForeground(Color.WHITE);
		lbl_colour.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_colour.setBounds(87, 167, 131, 19);
		desktopPane.add(lbl_colour);
		
		JLabel lbl_connec = new JLabel("Connectivity");
		lbl_connec.setForeground(Color.WHITE);
		lbl_connec.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_connec.setBounds(87, 197, 131, 19);
		desktopPane.add(lbl_connec);
		
		JLabel lbl_quantity = new JLabel("Quantity");
		lbl_quantity.setForeground(Color.WHITE);
		lbl_quantity.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_quantity.setBounds(87, 227, 131, 19);
		desktopPane.add(lbl_quantity);
		
		JLabel lbl_orig_cost = new JLabel("Original Cost");
		lbl_orig_cost.setForeground(Color.WHITE);
		lbl_orig_cost.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_orig_cost.setBounds(87, 257, 131, 19);
		desktopPane.add(lbl_orig_cost);
		
		JLabel lcl_ret_price = new JLabel("Retail Price");
		lcl_ret_price.setForeground(Color.WHITE);
		lcl_ret_price.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lcl_ret_price.setBounds(87, 287, 131, 19);
		desktopPane.add(lcl_ret_price);
		
		barcode_admin_inp = new JTextField();
		barcode_admin_inp.setColumns(10);
		barcode_admin_inp.setBounds(250, 107, 133, 20);
		desktopPane.add(barcode_admin_inp);
		
		brand_admin_inp = new JTextField();
		brand_admin_inp.setColumns(10);
		brand_admin_inp.setBounds(250, 137, 133, 20);
		desktopPane.add(brand_admin_inp);
		
		colour_admin_inp = new JTextField();
		colour_admin_inp.setColumns(10);
		colour_admin_inp.setBounds(250, 167, 133, 20);
		desktopPane.add(colour_admin_inp);
		
		connec_admin_inp = new JTextField();
		connec_admin_inp.setColumns(10);
		connec_admin_inp.setBounds(250, 197, 133, 20);
		desktopPane.add(connec_admin_inp);
		
		quantity_admin_inp = new JTextField();
		quantity_admin_inp.setColumns(10);
		quantity_admin_inp.setBounds(250, 227, 133, 20);
		desktopPane.add(quantity_admin_inp);
		
		origCost_admin_inp = new JTextField();
		origCost_admin_inp.setColumns(10);
		origCost_admin_inp.setBounds(250, 257, 133, 20);
		desktopPane.add(origCost_admin_inp);
		
		retPrice_admin_inp = new JTextField();
		retPrice_admin_inp.setColumns(10);
		retPrice_admin_inp.setBounds(250, 287, 133, 20);
		desktopPane.add(retPrice_admin_inp);
		
		JLabel AddProduct_lbl = new JLabel("Add Product");
		AddProduct_lbl.setForeground(Color.WHITE);
		AddProduct_lbl.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		AddProduct_lbl.setBounds(87, 58, 177, 38);
		desktopPane.add(AddProduct_lbl);
		
		JRadioButton keyboard_radio = new JRadioButton("Keyboard");
		buttonGroup.add(keyboard_radio);
		keyboard_radio.setActionCommand("Keyboard");
		keyboard_radio.setForeground(Color.WHITE);
		keyboard_radio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		keyboard_radio.setBackground(new Color(67,127,151));
		keyboard_radio.setBounds(87, 362, 109, 23);
		desktopPane.add(keyboard_radio);
		
		JRadioButton mouse_radio = new JRadioButton("Mouse");
		buttonGroup.add(mouse_radio);
		mouse_radio.setActionCommand("Mouse");
		mouse_radio.setForeground(Color.WHITE);
		mouse_radio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		mouse_radio.setBackground(new Color(67, 127, 151));
		mouse_radio.setBounds(215, 362, 109, 23);
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
		
		// If keyboard radio than disable mouse input
		keyboard_radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcl_ret_price_1_1.setEnabled(false);
				numBtns_admin_inp.setEnabled(false);
				lcl_ret_price_1.setEnabled(true);
				keyLayout_admin_inp.setEnabled(true);
				
			}
		});
		
		// If mouse radio than disable keyboard input
		mouse_radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcl_ret_price_1_1.setEnabled(true);
				numBtns_admin_inp.setEnabled(true);
				lcl_ret_price_1.setEnabled(false);
				keyLayout_admin_inp.setEnabled(false);
			}
		});
		
		
		String[] columnNames = {"Barcode", "Product", "Type", "Brand", "Colour", "Connectivity", "Original Cost", "Retail Price", "Quantity","No Buttons","Layout"};
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(417, 91, 793, 500);
		tablePanel.setLayout(new BorderLayout());
		
		admin_all_products_table = new JTable();
		
		DefaultTableModel adminModel = (DefaultTableModel) admin_all_products_table.getModel();
		adminModel.setDataVector(formatDataAdmin(comp.getAllStockData()), columnNames);
		
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
				frame.dispose();
				_startApp.main(new String[0]);
			}
		});
		logout_btn.setForeground(Color.WHITE);
		logout_btn.setBackground(new Color(67, 127, 151));
		logout_btn.setBounds(15, 586, 166, 33);
		desktopPane.add(logout_btn);
		
		JLabel message_lbl = new JLabel("Message: ");
		message_lbl.setForeground(Color.RED);
		message_lbl.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		message_lbl.setBounds(406, 37, 665, 33);
		desktopPane.add(message_lbl);
		
		JLabel lcl_ret_price_2 = new JLabel("Type");
		lcl_ret_price_2.setForeground(Color.WHITE);
		lcl_ret_price_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lcl_ret_price_2.setBounds(87, 317, 131, 19);
		desktopPane.add(lcl_ret_price_2);
		
		type_admin_inp = new JTextField();
		type_admin_inp.setColumns(10);
		type_admin_inp.setBounds(250, 318, 133, 20);
		desktopPane.add(type_admin_inp);
		desktopPane.setVisible(true);
		
		// Add product to stock
		addProduct_admin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// First Check all fields are filled and valid data type
				if (barcode_admin_inp.getText().isEmpty() ) {
					setMessage("error","Barcode must be filled.", message_lbl);
				}  
				
				else if (isInt(barcode_admin_inp.getText()) == false)  {
					setMessage("error","Barcode must be numbers only.", message_lbl);
				}
					
				else if(brand_admin_inp.getText().isEmpty()) {
					setMessage("error","Complete Brand name.", message_lbl);
				} 
				
				else if(colour_admin_inp.getText().isEmpty()) {
					setMessage("error","Fill in Colour of product", message_lbl);
				}
				
				else if(connec_admin_inp.getText().isEmpty()) {
					setMessage("error","Fill in Connectivity", message_lbl);
				} 
				
				else if(quantity_admin_inp.getText().isEmpty() || isInt(quantity_admin_inp.getText()) == false ) {
					setMessage("error","Fill in Quantity, must be numbers only.", message_lbl);
				}
				
				else if(origCost_admin_inp.getText().isEmpty()){
					setMessage("error","Fill in Original Cost", message_lbl);
				} 
				
				else if( !( isDouble(origCost_admin_inp.getText()) || isInt(origCost_admin_inp.getText()) ) || !( isDouble(retPrice_admin_inp.getText()) || isInt(retPrice_admin_inp.getText()) ) ) {
					setMessage("error","Original and Retail Cost must be numbers only.", message_lbl);
				}
				
				else if(retPrice_admin_inp.getText().isEmpty()) {
					setMessage("error","Fill in Retail Price", message_lbl);
				} 
				
				else if(type_admin_inp.getText().isEmpty()) {
					setMessage("error","Fill in Product Type", message_lbl);
				} 
				
				else if(buttonGroup.getSelection()==null) {
					setMessage("error","Select if product is keyboard or mouse",message_lbl);
				}
				
				else if (buttonGroup.getSelection().getActionCommand() == "Mouse" && ( numBtns_admin_inp.getText().isEmpty() || isInt(numBtns_admin_inp.getText()) == false ) ) {
					setMessage("error","Enter Number of Mouse buttons, must be integer",message_lbl);
				}
				
				else if (buttonGroup.getSelection().getActionCommand() == "Keyboard" && ( keyLayout_admin_inp.getText().isEmpty() ) ) {
					setMessage("error","Enter Keyboard Layout",message_lbl);
				}
				
				else {
					if (buttonGroup.getSelection().getActionCommand() == "Mouse") {
						String[] items = {
								barcode_admin_inp.getText(), brand_admin_inp.getText(), colour_admin_inp.getText(), connec_admin_inp.getText(), 
								quantity_admin_inp.getText(), origCost_admin_inp.getText(), retPrice_admin_inp.getText(), type_admin_inp.getText(), numBtns_admin_inp.getText()
						};
						Mice newProd = new Mice(Integer.parseInt(items[0]), items[1], items[2], items[3], Integer.parseInt(items[4]), Double.parseDouble(items[5]), Double.parseDouble(items[6]), items[7], Integer.parseInt(items[8]));
						boolean successAdd = comp.addMouseToStock(newProd);
						if (successAdd) {
							setMessage("success","Successfully Added Product",message_lbl);
						} else {
							setMessage("error","Product Barcode already exists",message_lbl);
						}
					}
					
					if (buttonGroup.getSelection().getActionCommand() == "Keyboard") {
						String[] items = {
								barcode_admin_inp.getText(), brand_admin_inp.getText(), colour_admin_inp.getText(), connec_admin_inp.getText(), 
								quantity_admin_inp.getText(), origCost_admin_inp.getText(), retPrice_admin_inp.getText(), type_admin_inp.getText(), keyLayout_admin_inp.getText()
						};
						Keyboard newProd = new Keyboard(Integer.parseInt(items[0]), items[1], items[2], items[3], Integer.parseInt(items[4]), Double.parseDouble(items[5]), Double.parseDouble(items[6]), items[7], items[8]);
						boolean successAdd = comp.addKeyboardToStock(newProd);
						if (successAdd) {
							setMessage("success","Successfully Added Product",message_lbl);
						} else {
							setMessage("error","Product Barcode already exists",message_lbl);
						}
					}
					
					// Update Table
					adminModel.setDataVector(formatDataAdmin(comp.getAllStockData()), columnNames);
					
				}
				
				
				
				
				
			}
		});
		
		
	}
	
	public void setMessage(String category, String message, JLabel label) {
		if (category == "error") {
			label.setForeground(Color.RED);
		} else {
			label.setForeground(Color.GREEN);
		}
		
		label.setText(message);
	}
}

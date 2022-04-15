package keynote;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;

public class _searchResults {

	private JFrame frame;
	private JTable search_results_table;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_searchResults window = new _searchResults();
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
	
	public ArrayList<Product> searchData = new ArrayList<Product>();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setSearchData(ArrayList<Product> data) {
		this.searchData = data;
	}
	
	/*
	public _searchResults() {
		Initialise();
		_searchResults window = new _searchResults();
		window.frame.setVisible(true);
	}
	*/
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public String[][] formatData(ArrayList<Product> data) {
		String[][] finalRes = new String[data.size()][10];
		for (int i = 0; i < data.size(); i ++) {
			if (data.get(i) instanceof Keyboard) { 
				Keyboard res = (Keyboard) data.get(i);
				finalRes[i] = new String[] {String.valueOf(data.get(i).barcode),data.get(i).getClass().getSimpleName(), res.type ,data.get(i).brand, data.get(i).colour, data.get(i).connec, String.valueOf(data.get(i).retPrice), String.valueOf(data.get(i).quantity), "N/A", res.layout};
			} else {
				Mice res = (Mice) data.get(i);
				finalRes[i] = new String[] {String.valueOf(data.get(i).barcode),data.get(i).getClass().getSimpleName(), res.type, data.get(i).brand, data.get(i).colour, data.get(i).connec, String.valueOf(data.get(i).retPrice), String.valueOf(data.get(i).quantity), String.valueOf(res.noButtons), "N/A"}; 
			}
			
		}
		return finalRes;
	}

	/**
	 * Initialise the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(ArrayList<Product> searchData) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1075, 289);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Set Frame title
		frame.setTitle("Search Results");
		
		
		String[] columnNames = {"Barcode", "Product", "Type", "Brand", "Colour", "Connectivity", "Retail Price", "Quantity","No Buttons","Layout"};
		
		
		search_results_table = new JTable(formatData(searchData), columnNames);
		search_results_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		search_results_table.setForeground(Color.WHITE);
		search_results_table.setBackground(Color.GRAY);
		JScrollPane scrollPane = new JScrollPane( search_results_table );
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		
	}

}

package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _getPaypal {

	private JFrame frame;
	private JTextField paypal_inp;
	public Customer sysCustomer = null;

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
					_getPaypal window = new _getPaypal(sysCustomer);
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
	public _getPaypal(Customer sysCustomer) {
		this.sysCustomer = sysCustomer;
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 604, 387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		paypal_inp = new JTextField();
		paypal_inp.setBounds(308, 84, 196, 33);
		frame.getContentPane().add(paypal_inp);
		paypal_inp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PayPal Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(95, 88, 182, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JButton pay_btn = new JButton("Pay");
		pay_btn.setForeground(Color.WHITE);
		pay_btn.setBackground(new Color(67, 127, 151));
		pay_btn.setBounds(201, 149, 166, 33);
		frame.getContentPane().add(pay_btn);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_cancel) {
				frame.dispose();
			}
		});
		cancel_btn.setForeground(Color.WHITE);
		cancel_btn.setBackground(new Color(67, 127, 151));
		cancel_btn.setBounds(201, 193, 166, 33);
		frame.getContentPane().add(cancel_btn);
		
		String totalCostStr = String.format("Total Cost: \u00A3 %.2f", sysCustomer.getTotalBasketPrice());
		JLabel totalCost = new JLabel(totalCostStr);
		totalCost.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		totalCost.setForeground(Color.WHITE);
		totalCost.setBounds(74, 35, 187, 27);
		frame.getContentPane().add(totalCost);
		
		JLabel errorLbl = new JLabel("");
		errorLbl.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(130, 299, 336, 27);
		frame.getContentPane().add(errorLbl);
		
		pay_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// First check if string is empty
				if (paypal_inp.getText().isEmpty()) {
					errorLbl.setText("Paypal Username must not be empty");
				} else {
					pay();
				}
			}
		});
	}
	
	public void pay() {
		this.sysCustomer.payment("CARD");
		sysCustomer.paymentSuccess = true;
		frame.dispose();
	}

}

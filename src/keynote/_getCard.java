package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class _getCard{

	public JFrame payFrame;
	private JTextField card_num_inp;
	private JTextField card_cvc_inp;
	public Customer sysCustomer = null;
	
	public boolean paymentSuccess = false;
	
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
					_getCard window = new _getCard(sysCustomer);
					window.payFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public _getCard(Customer sysCustomer) {
		this.sysCustomer = sysCustomer;
		initialize();
	}
	
	
	
	public boolean isInt(String value) {
		return value.matches("-?\\d+");
	}

	/**
	 * Initialise the contents of the frame.
	 */
	public void initialize() {
		payFrame = new JFrame();
		payFrame.getContentPane().setForeground(Color.WHITE);
		payFrame.getContentPane().setBackground(Color.DARK_GRAY);
		payFrame.setBounds(100, 100, 574, 382);
		payFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		payFrame.getContentPane().setLayout(null);
		
		card_num_inp = new JTextField();
		card_num_inp.setColumns(10);
		card_num_inp.setBounds(289, 77, 196, 33);
		payFrame.getContentPane().add(card_num_inp);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCardNumber.setBounds(76, 81, 182, 27);
		payFrame.getContentPane().add(lblCardNumber);
		
		JButton pay_btn = new JButton("Pay");
		pay_btn.setForeground(Color.WHITE);
		pay_btn.setBackground(new Color(67, 127, 151));
		pay_btn.setBounds(202, 195, 166, 33);
		payFrame.getContentPane().add(pay_btn);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_cancel) {
				payFrame.dispose();
			}
		});
		cancel_btn.setForeground(Color.WHITE);
		cancel_btn.setBackground(new Color(67, 127, 151));
		cancel_btn.setBounds(202, 239, 166, 33);
		payFrame.getContentPane().add(cancel_btn);
		
		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setForeground(Color.WHITE);
		lblCvc.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCvc.setBounds(76, 130, 182, 27);
		payFrame.getContentPane().add(lblCvc);
		
		card_cvc_inp = new JTextField();
		card_cvc_inp.setColumns(10);
		card_cvc_inp.setBounds(289, 126, 86, 33);
		payFrame.getContentPane().add(card_cvc_inp);
		
		JLabel error_lbl = new JLabel("");
		error_lbl.setForeground(Color.RED);
		error_lbl.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		error_lbl.setBounds(22, 295, 368, 37);
		payFrame.getContentPane().add(error_lbl);
		
		String totalCostStr = String.format("Total Cost: \u00A3 %.2f", sysCustomer.getTotalBasketPrice());
		JLabel totalCost = new JLabel(totalCostStr);
		totalCost.setForeground(Color.WHITE);
		totalCost.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		totalCost.setBounds(76, 27, 156, 31);
		payFrame.getContentPane().add(totalCost);
		
		// Payment
		pay_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e_cancel) {
				String cardNo = card_num_inp.getText();
				String cardCVC = card_cvc_inp.getText();
				
				// First validate input
				if (isInt(cardNo) == false || isInt(cardCVC) == false) {
					error_lbl.setText("Both Inputs need to be numbers only");
				} else {
					// Clear User Basket without refilling stock
					pay();
				}
				
			}
		});
		
	}
	
	public void pay() {
		this.sysCustomer.payment("CARD");
		sysCustomer.paymentSuccess = true;
		payFrame.dispose();
	}

}

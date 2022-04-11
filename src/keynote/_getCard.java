package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class _getCard {

	private JFrame frame;
	private JTextField card_num_inp;
	private JTextField card_cvc_inp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_getCard window = new _getCard();
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
	public _getCard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 574, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		card_num_inp = new JTextField();
		card_num_inp.setColumns(10);
		card_num_inp.setBounds(289, 77, 196, 33);
		frame.getContentPane().add(card_num_inp);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCardNumber.setBounds(76, 81, 182, 27);
		frame.getContentPane().add(lblCardNumber);
		
		JButton pay_btn = new JButton("Pay");
		pay_btn.setForeground(Color.WHITE);
		pay_btn.setBackground(new Color(67, 127, 151));
		pay_btn.setBounds(202, 195, 166, 33);
		frame.getContentPane().add(pay_btn);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setForeground(Color.WHITE);
		cancel_btn.setBackground(new Color(67, 127, 151));
		cancel_btn.setBounds(202, 239, 166, 33);
		frame.getContentPane().add(cancel_btn);
		
		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setForeground(Color.WHITE);
		lblCvc.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCvc.setBounds(76, 130, 182, 27);
		frame.getContentPane().add(lblCvc);
		
		card_cvc_inp = new JTextField();
		card_cvc_inp.setColumns(10);
		card_cvc_inp.setBounds(289, 126, 86, 33);
		frame.getContentPane().add(card_cvc_inp);
	}

}

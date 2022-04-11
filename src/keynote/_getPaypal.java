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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_getPaypal window = new _getPaypal();
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
	public _getPaypal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 604, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		paypal_inp = new JTextField();
		paypal_inp.setBounds(287, 115, 196, 33);
		frame.getContentPane().add(paypal_inp);
		paypal_inp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PayPal Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(74, 119, 182, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JButton pay_btn = new JButton("Pay");
		pay_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pay_btn.setForeground(Color.WHITE);
		pay_btn.setBackground(new Color(67, 127, 151));
		pay_btn.setBounds(200, 214, 166, 33);
		frame.getContentPane().add(pay_btn);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setForeground(Color.WHITE);
		cancel_btn.setBackground(new Color(67, 127, 151));
		cancel_btn.setBounds(200, 258, 166, 33);
		frame.getContentPane().add(cancel_btn);
	}

}

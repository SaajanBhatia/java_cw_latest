package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class _startApp {

	private JFrame frame;
	public static ProcessFile comp = new ProcessFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Configuration and Set Up
		System.out.println("Initialising App ...");
		comp.formatStockFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_startApp window = new _startApp();
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
	public _startApp() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KeyNote");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(116, 112, 102, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(155, 148, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox accounts_combo = new JComboBox(this.comp.getAllUsernames());
		accounts_combo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		accounts_combo.setBounds(267, 140, 194, 22);
		frame.getContentPane().add(accounts_combo);
		
		JLabel lblNewLabel_2 = new JLabel("Select User Account");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setBounds(267, 106, 143, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton login_btn = new JButton("Sign In");
		login_btn.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		login_btn.setBackground(Color.WHITE);
		login_btn.setBounds(267, 200, 102, 31);
		frame.getContentPane().add(login_btn);
		
		// When user presses Sign In
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get selected item
				String selectedAcc = (String) accounts_combo.getSelectedItem();
				List<String> userIds  = Arrays.asList(comp.getAllUsernames());
				int indexOf = userIds.indexOf(selectedAcc);
				User sysUser = comp.userLogin(comp.getAllUserIDs()[indexOf], selectedAcc);
				
				frame.dispose();
				
				String[] userDetails = {comp.getAllUserIDs()[indexOf]};

				if (sysUser instanceof Admin) {
					_adminDash adminUser = new _adminDash((Admin)sysUser);
					adminUser.run();
				} else {
					_customerDash.main(userDetails);
				}

				System.out.println(selectedAcc);
			}
		});
	}
}

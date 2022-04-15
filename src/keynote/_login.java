package keynote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _login {

	private JFrame frame;
	private JTextField userID_input;
	private JTextField username_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Initialising Project ...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_login window = new _login();
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
	public _login() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 553, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KeyNote");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 101, 102, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(128, 137, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setBounds(250, 100, 75, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username");
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(250, 139, 75, 24);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		userID_input = new JTextField();
		userID_input.setText("101");
		userID_input.setBounds(335, 103, 110, 20);
		frame.getContentPane().add(userID_input);
		userID_input.setColumns(10);
		
		username_input = new JTextField();
		username_input.setText("user1");
		username_input.setColumns(10);
		username_input.setBounds(335, 137, 110, 20);
		frame.getContentPane().add(username_input);
		
		JLabel login_error_lbl = new JLabel(" ");
		login_error_lbl.setForeground(Color.RED);
		login_error_lbl.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		login_error_lbl.setBounds(43, 253, 299, 39);
		frame.getContentPane().add(login_error_lbl);
		
		JButton login_btn = new JButton("Sign In");
		// When User Submits Sign In
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessFile comp = new ProcessFile();
				User sysUser = comp.userLogin(userID_input.getText(), username_input.getText());
				if ( sysUser != null ) {
					// Dispose Login Frame
					frame.dispose();
					
					String[] userDetails = {userID_input.getText()};

					if (sysUser instanceof Admin) {
						_adminDash adminUser = new _adminDash((Admin)sysUser);
						adminUser.run();
					} else {
						_customerDash.main(userDetails);
					}
					
					
					
				} else {
					// Update Error Label
					login_error_lbl.setText("Error - Invalid User Details");
				}
			}
		});
		login_btn.setBackground(SystemColor.window);
		login_btn.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		login_btn.setBounds(305, 192, 102, 31);
		frame.getContentPane().add(login_btn);
		
		
		
		
	}
}

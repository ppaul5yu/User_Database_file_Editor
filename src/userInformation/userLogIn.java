package userInformation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userLogIn extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField userNametextField;
	private JTextField passwordtextField;
	JButton btnLogIn, btnCancle;
	String userName, password;
	int number;
	FileEditor fileOpen;
	static userLogIn window;
	ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new userLogIn();
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
	public userLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("User Login");
		frame.setBounds(100, 100, 461, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitle = new JLabel("Please Log In");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(51, 32, 107, 28);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setBounds(51, 100, 72, 28);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(51, 152, 72, 28);
		frame.getContentPane().add(lblPassword);
		
		userNametextField = new JTextField();
		userNametextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		userNametextField.setBounds(133, 102, 163, 25);
		frame.getContentPane().add(userNametextField);
		userNametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordtextField.setColumns(10);
		passwordtextField.setBounds(133, 152, 163, 25);
		frame.getContentPane().add(passwordtextField);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(this);
		btnLogIn.setBackground(Color.GREEN);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogIn.setBounds(62, 233, 89, 23);
		frame.getContentPane().add(btnLogIn);
		
		btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancle.setBackground(Color.RED);
		btnCancle.setBounds(207, 234, 89, 23);
		frame.getContentPane().add(btnCancle);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 12));
		cratorName.setBounds(303, 292, 121, 14);
		frame.getContentPane().add(cratorName);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PoMmi\\Downloads\\output-onlinepngtools.png"));
		lblNewLabel.setBounds(335, 89, 89, 111);
		frame.getContentPane().add(lblNewLabel);
		
		
		number = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e)
{
		icon = new ImageIcon("C:\\Users\\PoMmi\\Downloads\\1828651gggg.png");
		userName = userNametextField.getText();
		password = passwordtextField.getText();
		
		if (e.getSource() == btnLogIn)
		{
		
			if (number <= 3)
			{
		
		
				if (userName.equals("pretom") && password.equals("Pretom123"))
				{
					JOptionPane.showMessageDialog(null, "Login Successfully !\nWelcome.", 
				                "Message", JOptionPane.INFORMATION_MESSAGE, icon);
					
						fileOpen = new FileEditor();
						fileOpen.fileEditorTitle.setVisible(true);
						
						frame.setVisible(false);
						
				}
			
				else 
				{
					JOptionPane.showMessageDialog(frame, "Your UserName and/or Password do not match.\nPlease enter the correct User Name and Password." + "\n\nattemps left: " + (3-number), "Warning Message", JOptionPane.WARNING_MESSAGE);
					number = number +1;
					userNametextField.setText("");
					passwordtextField.setText("");
					
				}
			}
			else
		
			{
				JOptionPane.showMessageDialog(frame, "You have done 3 Wrong attemps. You cannot login to the application.", "Error Message", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
		
	}
}

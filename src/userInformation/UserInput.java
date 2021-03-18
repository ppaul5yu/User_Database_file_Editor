package userInformation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class UserInput extends FileEditor implements ActionListener{

	JFrame frame;
	private JTextField textFieldLable;
	private JTextField lastNameInput;
	private JTextField firstNameInput;
	private JTextField addressInput;
	private JTextField cityInput;
	private JTextField provinceInput;
	private JTextField postalCodeInput;
	private JTextField cellNoInput;
	JLabel validationCellNo;
	JButton importButton, readButton;
	static UserInput window;
	FileWriter out;
	BufferedWriter outing;
	JFrame fileEdit;
	private JButton refreshButton;
	private JLabel lnValidation;
	private JLabel fnValidation;
	private JLabel cityValidation;
	private JLabel pValidation;
	
	readtable reading;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new UserInput();
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
	public UserInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("File Editing");
		frame.setBounds(100, 100, 465, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// Lables
		
		textFieldLable = new JTextField();
		textFieldLable.setForeground(Color.DARK_GRAY);
		textFieldLable.setBackground(Color.WHITE);
		textFieldLable.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldLable.setText("< User Information Form >");
		textFieldLable.setEditable(false);
		textFieldLable.setBounds(92, 28, 232, 34);
		frame.getContentPane().add(textFieldLable);
		textFieldLable.setColumns(10);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 11));
		cratorName.setBounds(320, 462, 119, 23);
		frame.getContentPane().add(cratorName);
		
		JLabel lastNameLable = new JLabel("Last Name:");
		lastNameLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastNameLable.setBounds(81, 108, 82, 14);
		frame.getContentPane().add(lastNameLable);
		
		JLabel firstNameLable = new JLabel("First Name:");
		firstNameLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		firstNameLable.setBounds(81, 143, 82, 14);
		frame.getContentPane().add(firstNameLable);
		
		JLabel addressLable = new JLabel("Address:");
		addressLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		addressLable.setBounds(81, 179, 82, 14);
		frame.getContentPane().add(addressLable);
		
		JLabel cityLable = new JLabel("City:");
		cityLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		cityLable.setBounds(81, 211, 82, 14);
		frame.getContentPane().add(cityLable);
		
		JLabel provinceLable = new JLabel("Province:");
		provinceLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		provinceLable.setBounds(81, 244, 82, 14);
		frame.getContentPane().add(provinceLable);
		
		JLabel postalCodeLable = new JLabel("Postal Code:");
		postalCodeLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		postalCodeLable.setBounds(81, 282, 82, 14);
		frame.getContentPane().add(postalCodeLable);
		
		JLabel cellNoLable = new JLabel("Cell No:");
		cellNoLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		cellNoLable.setBounds(81, 317, 82, 14);
		frame.getContentPane().add(cellNoLable);
		
		validationCellNo = new JLabel("");
		validationCellNo.setFont(new Font("Tahoma", Font.BOLD, 9));
		validationCellNo.setForeground(Color.RED);
		validationCellNo.setBounds(320, 317, 119, 14);
		frame.getContentPane().add(validationCellNo);
		
		
		//Input Text field
		
		lastNameInput = new JTextField();
		lastNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isDigit(c))
				{
					lastNameInput.setEditable(false);
					lnValidation.setText("<Enter Text only>");
					
				}
				else if (lastNameInput.getText().length() >= 21)
				{
					lastNameInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					lastNameInput.setEditable(true);
					
				}
			}
		});
		
		lastNameInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lastNameInput.setBounds(173, 109, 140, 14);
		frame.getContentPane().add(lastNameInput);
		lastNameInput.setColumns(10);
		
		
		
		firstNameInput = new JTextField();
		firstNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isDigit(c))
				{
					firstNameInput.setEditable(false);
					fnValidation.setText("<Enter Text only>");
					
				}
				else if (firstNameInput.getText().length() >= 25)
				{
					firstNameInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					firstNameInput.setEditable(true);
					
				}
			}
		});
		
		firstNameInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		firstNameInput.setColumns(10);
		firstNameInput.setBounds(173, 144, 140, 14);
		frame.getContentPane().add(firstNameInput);
		
		
		
		addressInput = new JTextField();
		addressInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (addressInput.getText().length() >= 30)
				{
					addressInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					addressInput.setEditable(true);
					
				}
			}
		});
		
		addressInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addressInput.setColumns(10);
		addressInput.setBounds(173, 180, 140, 14);
		frame.getContentPane().add(addressInput);
		
		
		cityInput = new JTextField();
		cityInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isDigit(c))
				{
					cityInput.setEditable(false);
					cityValidation.setText("<Enter Text only>");
					
				}
				else if (cityInput.getText().length() >= 19)
				{
					cityInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					cityInput.setEditable(true);
					
				}
			}
		});
		
		cityInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cityInput.setColumns(10);
		cityInput.setBounds(173, 212, 140, 14);
		frame.getContentPane().add(cityInput);
		
		provinceInput = new JTextField();
		
		provinceInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isDigit(c))
				{
					provinceInput.setEditable(false);
					pValidation.setText("<Enter Text only>");
					
					
				}
				else if (provinceInput.getText().length() >= 19)
				{
					provinceInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					provinceInput.setEditable(true);
					
				}
			}
		});
		
		provinceInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		provinceInput.setColumns(10);
		provinceInput.setBounds(173, 245, 140, 14);
		frame.getContentPane().add(provinceInput);
		
		
		postalCodeInput = new JTextField();
		postalCodeInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			
				if (postalCodeInput.getText().length() >= 9)
				{
					postalCodeInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					postalCodeInput.setEditable(true);
					
				}
			}
		});
		postalCodeInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		postalCodeInput.setColumns(10);
		postalCodeInput.setBounds(173, 283, 140, 14);
		frame.getContentPane().add(postalCodeInput);
		
		cellNoInput = new JTextField();
		
		cellNoInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isLetter(c))
				{
					cellNoInput.setEditable(false);
					validationCellNo.setText("<Enter Numbers only>");
				}
				else if (cellNoInput.getText().length() >= 10)
				{
					cellNoInput.setEditable(false);
					JOptionPane.showMessageDialog(frame, "Text Limit Execeeded. \nClick Refresh Button to Enter.", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					cellNoInput.setEditable(true);
					
				}
			}
		});
		cellNoInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cellNoInput.setColumns(10);
		cellNoInput.setBounds(173, 318, 140, 14);
		frame.getContentPane().add(cellNoInput);
		
		
		//Buttons
		
		importButton = new JButton("Import");
		importButton.addActionListener(this);
			
		importButton.setBackground(Color.GREEN);
		importButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		importButton.setBounds(172, 360, 89, 23);
		frame.getContentPane().add(importButton);
		
		readButton = new JButton("Read the File");
		readButton.addActionListener(this);
		
		readButton.setBackground(Color.ORANGE);
		readButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		readButton.setBounds(40, 405, 149, 23);
		frame.getContentPane().add(readButton);
		
		JButton closeButton = new JButton("Close the Program");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		closeButton.setBackground(Color.RED);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		closeButton.setBounds(237, 405, 160, 23);
		frame.getContentPane().add(closeButton);
		
		refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lastNameInput.setEditable(true);
				lastNameInput.setText("");
				firstNameInput.setEditable(true);
				firstNameInput.setText("");
				addressInput.setEditable(true);
				addressInput.setText("");
				cityInput.setEditable(true);
				cityInput.setText("");
				provinceInput.setEditable(true);
				provinceInput.setText("");
				postalCodeInput.setEditable(true);
				postalCodeInput.setText("");
				cellNoInput.setEditable(true);
				cellNoInput.setText("");
				
			}
		});
		refreshButton.setBackground(Color.PINK);
		refreshButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		refreshButton.setBounds(338, 36, 89, 23);
		frame.getContentPane().add(refreshButton);
		
		lnValidation = new JLabel("");
		lnValidation.setForeground(Color.RED);
		lnValidation.setFont(new Font("Tahoma", Font.BOLD, 10));
		lnValidation.setBounds(320, 108, 116, 14);
		frame.getContentPane().add(lnValidation);
		
		fnValidation = new JLabel("");
		fnValidation.setForeground(Color.RED);
		fnValidation.setFont(new Font("Tahoma", Font.BOLD, 10));
		fnValidation.setBounds(320, 143, 116, 14);
		frame.getContentPane().add(fnValidation);
		
		cityValidation = new JLabel("");
		cityValidation.setForeground(Color.RED);
		cityValidation.setFont(new Font("Tahoma", Font.BOLD, 10));
		cityValidation.setBounds(323, 211, 116, 14);
		frame.getContentPane().add(cityValidation);
		
		pValidation = new JLabel("");
		pValidation.setForeground(Color.RED);
		pValidation.setFont(new Font("Tahoma", Font.BOLD, 10));
		pValidation.setBounds(320, 244, 116, 14);
		frame.getContentPane().add(pValidation);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 9, 72, 76);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PoMmi\\Downloads\\output-onlinepngtools (2).png"));
		frame.getContentPane().add(lblNewLabel);
		
	
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == importButton)
		{
			
			if (lastNameInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter Last Name", "Error Message", JOptionPane.ERROR_MESSAGE);
			}

			else if (firstNameInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter First Name", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (addressInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter Adress", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (cityInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter City", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (provinceInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter Province", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (postalCodeInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter Postal Code", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else if (cellNoInput.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(frame, "Please enter Cell No", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else
			{
				
				fileEdit = new JFrame("Input");
			
				
				try {
					out = new FileWriter(FileEditor.window.fileName + ".txt", true);
					outing = new BufferedWriter(out);
					outing.write(lastNameInput.getText() + "\t");
					outing.write(firstNameInput.getText() + "\t");
					outing.write(addressInput.getText() + "\t");
					outing.write(cityInput.getText() + "\t");
					outing.write(provinceInput.getText() + "\t");
					outing.write(postalCodeInput.getText() + "\t");
					outing.write(cellNoInput.getText() + "\t");
					outing.write("\n");
					
					outing.close();
			
					JOptionPane.showMessageDialog(fileEdit, "User information has been imported to "+ FileEditor.window.fileName +".txt");
					
					lastNameInput.setEditable(true);
					lastNameInput.setText("");
					firstNameInput.setEditable(true);
					firstNameInput.setText("");
					addressInput.setEditable(true);
					addressInput.setText("");
					cityInput.setEditable(true);
					cityInput.setText("");
					provinceInput.setEditable(true);
					provinceInput.setText("");
					postalCodeInput.setEditable(true);
					postalCodeInput.setText("");
					cellNoInput.setEditable(true);
					cellNoInput.setText("");
					
			
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "There is no file. \nPlease enter file.", "Error Message", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			
				
			}
		}
		
		else if (e.getSource() == readButton)
		{
			reading = new readtable();
			reading.frame.setVisible(true);
			
		}
		
	}
}

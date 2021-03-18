package userInformation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileEditor extends userLogIn implements ActionListener{

	JFrame fileEditorTitle, fileEdit;
	private JTextField fileNameField;
	static FileEditor window;
	private JButton createButton, cancleButton; 
	private JLabel fileNameLabel;
	private JLabel creatorLabel;
	static String fileName;
	PrintWriter output;
	FileWriter out;
	BufferedWriter bw;
	File file, tempFile;
	JTextField inputMessage;
	static String response;
	UserInput mywindow;
	boolean fCrated;
	

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					window = new FileEditor();
					window.fileEditorTitle.setVisible(true);
				} catch (Exception e) 
				
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileEditor() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		fileEditorTitle = new JFrame("Create a file");
		fileEditorTitle.setBounds(100, 100, 450, 246);
		fileEditorTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileEditorTitle.getContentPane().setLayout(null);
		
		fileNameLabel = new JLabel("Enter File Name :");
		fileNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fileNameLabel.setBounds(31, 21, 125, 26);
		fileEditorTitle.getContentPane().add(fileNameLabel);
		
		fileNameField = new JTextField();
		fileNameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		fileNameField.setBounds(31, 58, 260, 26);
		fileEditorTitle.getContentPane().add(fileNameField);
		fileNameField.setColumns(10);
		
		creatorLabel = new JLabel("Created By PoMmi");
		creatorLabel.setForeground(Color.BLUE);
		creatorLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
		creatorLabel.setBounds(315, 176, 109, 14);
		fileEditorTitle.getContentPane().add(creatorLabel);
		
		
		//Button Action
		createButton = new JButton("Create");
		createButton.addActionListener(this);
		createButton.setBackground(Color.GREEN);
		createButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		createButton.setBounds(31, 116, 119, 38);
		fileEditorTitle.getContentPane().add(createButton);
		
		
		cancleButton = new JButton("Cancle");
		cancleButton.addActionListener(this);
		cancleButton.setBackground(new Color(255, 0, 0));
		cancleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancleButton.setBounds(172, 116, 119, 38);
		fileEditorTitle.getContentPane().add(cancleButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PoMmi\\Downloads\\116637-200file.png"));
		lblNewLabel.setBounds(268, 2, 156, 141);
		fileEditorTitle.getContentPane().add(lblNewLabel);
		

	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		fileEdit = new JFrame("Input");
		
		if (e.getSource() == createButton)
		{
				if (fileNameField.getText().isEmpty())
				{
				
					JOptionPane.showMessageDialog(fileEditorTitle, "Please enter file Name.", "Error Message", JOptionPane.ERROR_MESSAGE);
				
				}
			
				else
				{
				
				
					fileName = fileNameField.getText();
				
					
							
							file = new File(fileName + ".txt");
							
							if (file.exists() && file.isFile())
							{
								
								int returnValue = JOptionPane.showConfirmDialog(
										fileEditorTitle,
										"\""+fileName + ".txt\"\n\n"+ "A file with this name already exists. Would you like to replace the existing? It could erase all\nexisting data in the file." ,
										"Message",
										JOptionPane.YES_NO_CANCEL_OPTION);
								
								if (returnValue == 0)
								{
									file.delete();
									
									fCrated = false;
				
									try {
										fCrated = file.createNewFile();
								
										out = new FileWriter(fileName + ".txt", true);
										bw = new BufferedWriter(out);
										bw.write("Last Name\t"+"First Name\t"+"Address\t"+"City\t"+"Province\t"+"Postal Code\t"+"Cell Number\n");
										bw.close();
								
										mywindow = new UserInput();
										fileEditorTitle.setVisible(false);
										mywindow.frame.setVisible(true);
								
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(fileEditorTitle, "There is no file. \nPlease enter file Name.", "Error Message", JOptionPane.ERROR_MESSAGE);
									}
								}
								
								else if (returnValue == 1)
								{
									
										mywindow = new UserInput();
										fileEditorTitle.setVisible(false);
										mywindow.frame.setVisible(true);
									
								}
									
				
								else if (returnValue == 2)
								{
									//System.exit(0);
								}
			
							}
							
							else
							{
								
								fCrated = false;
								
								try {
									fCrated = file.createNewFile();
							
									out = new FileWriter(fileName + ".txt", true);
									bw = new BufferedWriter(out);
									bw.write("Last Name\t"+"First Name\t"+"Address\t"+"City\t"+"Province\t"+"Postal Code\t"+"Cell Number\n");
									bw.close();
							
									mywindow = new UserInput();
									fileEditorTitle.setVisible(false);
									mywindow.frame.setVisible(true);
							
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(fileEditorTitle, "There is no file. \nPlease enter file Name.", "Error Message", JOptionPane.ERROR_MESSAGE);
								}
								
								//JOptionPane.showMessageDialog(fileEditorTitle, "There is no "+ fileName + ".txt file. \nPlease make the file.", "Error Message", JOptionPane.ERROR_MESSAGE);
							}
				}
		}	
		
		else if (e.getSource() == cancleButton) 
		{
			fileEditorTitle.setVisible(false);
		}
	}
}


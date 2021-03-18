package userInformation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class readtable extends UserInput implements ActionListener{

	JFrame frame;
	private JTable table;
	File file;
	BufferedReader br;
	String fLine, dataLine;
	String[] comumnName, rowData;
	DefaultTableModel model;
	static readtable window;
	Object[] tableLines;
	JTableHeader theader;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new readtable();
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
	public readtable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frame = new JFrame("Reading the file");
		frame.setBounds(100, 100, 1009, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 72, 937, 387);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		
		JButton returnButton = new JButton("Return to Edit File");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		returnButton.setBackground(Color.GREEN);
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		returnButton.setBounds(183, 521, 180, 23);
		frame.getContentPane().add(returnButton);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 12));
		cratorName.setBounds(862, 555, 131, 41);
		frame.getContentPane().add(cratorName);
		
		JButton closeButton = new JButton("Exit from Program");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		closeButton.setBackground(Color.RED);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		closeButton.setBounds(646, 521, 154, 23);
		frame.getContentPane().add(closeButton);
		
		JLabel Lable = new JLabel("User Infromation from text file \"" + UserInput.fileName + ".txt\"");
		Lable.setForeground(Color.BLACK);
		Lable.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		Lable.setBounds(40, 21, 527, 35);
		frame.getContentPane().add(Lable);
		
		
		
		
		
		file = new File(UserInput.fileName + ".txt");
		
		//get the first line;  get the column name from first line;  set columns name to jtable model
		
		try {
			br = new BufferedReader(new FileReader(file));
			fLine = br.readLine().trim();
			comumnName = fLine.split("\t");
			model = (DefaultTableModel)table.getModel();
			model.setColumnIdentifiers(comumnName);
			
			//get lines from txt file
			tableLines = br.lines().toArray();
			
			//extratct data from lines
			//set dada to table model
			
			for (int i=0; i< tableLines.length; i++)
			{
				dataLine = tableLines[i].toString().trim();
				rowData = dataLine.split("\t");
				model.addRow(rowData);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, e);
		}
		
		theader = table.getTableHeader();
		theader.setBackground(Color.GRAY);
		theader.setForeground(Color.WHITE);
		
		theader.setFont(new Font("Tahome",Font.BOLD,15));
		
		table.setFont(new Font("Tahome", Font.BOLD,12));
		
		
	}
}

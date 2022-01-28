import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.*;

class AdminSide implements ActionListener{
	private JFrame frame = new JFrame();
	private JButton button = new JButton("SUBMIT");
	private SimpleDateFormat dateTime;
	private String []All = new String[10];
	private JOptionPane confrm = new JOptionPane();
	
	
	
	private JLabel label1 =new JLabel("Bus Name: ");
	private JLabel label2 =new JLabel("Bus Number: ");
	private JLabel label3 =new JLabel("Source: ");
	private JLabel label4 =new JLabel("Destination: ");
	private JLabel label5 =new JLabel("Start Date ");
	private JLabel label6 =new JLabel("Start Time: ");
	private JLabel label7 =new JLabel("End Date: ");
	private JLabel label8 =new JLabel("End Time: ");
	private JLabel label9 =new JLabel("Fare per seat: ");
	private JLabel label10 =new JLabel("Nos Rows(seats): ");
	private JLabel warn =  new JLabel();
	
	private JTextField textField1 = new JTextField();
	private JTextField textField2 = new JTextField();
	private JTextField textField3 = new JTextField();
	private JTextField textField4 = new JTextField();
	private JTextField textField5 = new JTextField();
	private JTextField textField6 = new JTextField();
	private JTextField textField7 = new JTextField();
	private JTextField textField8 = new JTextField();
	
	private JTextField textField9 = new JTextField();
	private JTextField textField10 = new JTextField();
	private JTextField textField11 = new JTextField();
	private JCheckBox checkbox = new JCheckBox();
	
	public void set_up(){
		frame.setSize(700,600);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label1.setBounds(20,15,120,50);
		label2.setBounds(20,65,120,50);
		label3.setBounds(20,115,120,50);
		label4.setBounds(20,165,120,50);
		label5.setBounds(20,215,120,50);
		label6.setBounds(20,265,120,50);
		label7.setBounds(20,315,120,50);
		label8.setBounds(20,365,120,50);
		label9.setBounds(20,415,120,50);
		label10.setBounds(20,465,120,50);
		warn.setBounds(100, 450, 200, 200);
		
		textField1.setBounds(150,25,200,30);
		textField2.setBounds(150,75,200,30);
		textField3.setBounds(150,125,200,30);
		textField4.setBounds(150,175,200,30);
		textField5.setBounds(150,225,200,30);
		textField6.setBounds(150,275,200,30);
		textField7.setBounds(150,325,200,30);
		textField8.setBounds(150,375,200,30);
		textField9.setBounds(150,425,200,30);
		textField10.setBounds(150,475,200,30);
		textField11.setBounds(450,40,150,450);
		checkbox.setBounds(360, 485, 20, 20);
		button.setBounds(550,520,100,30);
		button.addActionListener(this);
		
		frame.add(warn);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		frame.add(label8);
		frame.add(label9);
		frame.add(label10);
		
		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(textField4);
		frame.add(textField5);
		frame.add(textField6);
		frame.add(textField7);
		frame.add(textField8);
		frame.add(textField9);
		frame.add(textField10);
		frame.add(textField11);
		
		frame.add(checkbox);
		frame.add(button);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public boolean check_dates(String s1,String s2,String s3,String s4) {
		dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date today = new Date();
		Date check1 = null;
	
		try {
			check1 = dateTime.parse(s1+" "+s2);
			if(!check1.after(today)) {return false;}
			}catch(Exception e) {return false;}
	
		try {
			Date check2 = dateTime.parse(s3+" "+s4);
			if(!check2.after(check1)) {return false;}
			}catch(Exception e) {return false;}
		return true;
	}
	
	public void fill_All() {
		All[0] = textField1.getText();
		All[1] = textField2.getText();
		All[2] = textField3.getText();
		All[3] = textField4.getText();
		All[4] = textField5.getText();
		All[5] = textField6.getText();
		All[6] = textField7.getText();
		All[7] = textField8.getText();
		All[8] = textField9.getText();
		All[9] = textField10.getText();
	}

	public boolean check_all() {
		if(textField1.getText().isEmpty()==true||
			textField2.getText().isEmpty()==true||
			textField3.getText().isEmpty()==true||
			textField4.getText().isEmpty()==true||
			textField5.getText().isEmpty()==true||
			textField6.getText().isEmpty()==true||
			textField7.getText().isEmpty()==true||
			textField8.getText().isEmpty()==true||
			textField9.getText().isEmpty()==true||
			textField10.getText().isEmpty()==true) {return false;}
		return true;
	}
	
	public void write_into_DB() {
		
		
		writingIntoFile.insert(All[0], All[1], All[2], All[3], All[4]+" "+All[5], 
				All[6]+" "+All[7], Integer.parseInt(All[8]), Integer.parseInt(All[9]));
	}
	
	
	public void set_seats(int [][]seats ,int row) {
		int y = 1;
		for(int i =0 ;i<row;i++) {
			for(int j=0;j<4;j++) {
				seats[i][j] = y;
				y++;
			}
			}
	}

@Override
public void actionPerformed(ActionEvent e) {
	
	boolean DateCheck = check_dates(textField5.getText(),textField6.getText(),textField7.getText(),textField8.getText());
	
	if(e.getSource()==button) {
		
		if(check_all()==true) {
			
			if(DateCheck==true) {
				SEAT_file S = new SEAT_file();
				fill_All();
				int [][]seats = new int[Integer.parseInt(textField10.getText())][4];
				set_seats(seats,Integer.parseInt(textField10.getText()));
				S.write_into_file(textField2.getText(),seats);
				System.out.print("HElllo");
				write_into_DB();
				frame.dispose();
				String options[] = {"OK"};
				confrm.showOptionDialog(null, "Bus Added Successfully", "Confirmation", 0,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
			}
			else {
				textField5.setText(null);
				textField6.setText(null);
				textField7.setText(null);
				textField8.setText(null);
				warn.setText("Wrong Date/Time | Enter Again!");
			}
			
		}
				
		else {
			warn.setText("Fill All Fields!");
			
		}
		}
	
}
	
public void display() 	{
	for(String s:All) {System.out.println(s);}
}

}


public class Inner1{
	public static void main(String [] args) {
		

		}
	}

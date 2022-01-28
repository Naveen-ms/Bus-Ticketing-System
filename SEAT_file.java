import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SEAT_file implements ActionListener,Serializable{
	 HashMap<String,int[][]> map = new HashMap<String,int[][]>();
	
	 private JFrame frame = new JFrame();
	 private JTextArea textField = new JTextArea();
	 private JTextField Field1 = new JTextField();
	 private JTextField Field2 = new JTextField();
	 private JLabel label1 = new JLabel("Enter No. Seats:");
	 private JLabel label2 = new JLabel("Enter Seats:");
	 private JButton button = new JButton("Book");
	 private JLabel warn = new JLabel();
	 String key = null;
	 private Details d = new Details();
	
	 
	 
	 public String convert(int [][] seats) {
		 String empty = "";
		 int row = seats.length;
			for(int i =0 ;i<row;i++) {
				for(int j=0;j<5;j++) {
					if(j==2) {empty=empty+"\t";}
					if(j<2 && seats[i][j]<=9) {empty = empty+"\s\s"+String.valueOf(seats[i][j])+"\s\s";}
					else if(j>2&& seats[i][j-1]<=9) {empty = empty+ "\s\s"+String.valueOf(seats[i][j-1])+"\s\s";}
					else if(j<2 && seats[i][j]>9) {empty = empty+String.valueOf(seats[i][j])+"\s\s";}
					else if(j>2&& seats[i][j-1]>9) {empty = empty+String.valueOf(seats[i][j-1])+"\s\s";}
				}
			empty = empty+"\n";
			}
			return empty;
		
	}
	 
//	public static void main(String []args) {
//		SEAT_file s = new SEAT_file();
//		
//		 
//	 }	 
	 
	 	public boolean select_seat_no(int [][] seats,int [] seatNo) {
			int r,c;
			for(int p:seatNo) {
				r = (int)Math.ceil((float)p/4);
				c = p%4==0 ? 4:p%4 ;
				if(seats[r-1][c-1]==0) {return false;}
				seats[r-1][c-1] = 0;
			}	
			return true;
	 	
	}
	 	 

		 public boolean check_seat_selection(String key) {
				int n  = Integer.valueOf(Field1.getText());
				String r = Field2.getText();
				String []P = r.split(",");
				if(n!=P.length) {return false;}
				int [] arr = new int[n];
				int i=0;
				for(String s : P) {arr[i]=Integer.valueOf(s);i++;}
				int [][] U = show_seats(key);
				if(select_seat_no(U,arr)==false) {return false;}
				write_into_file(key,U);
			return true;
		 }

	 	
	 	
	
	 public int[][] show_seats(String key) {
		 try {
			 FileInputStream file = new FileInputStream("Seat_info.ser");
			 ObjectInputStream os = new ObjectInputStream(file);
			 map = (HashMap<String,int[][]>) os.readObject();
			 file.close();
			 }catch(Exception e) {}
		return map.get(key); 
	 }
	 
	 
	 public void set_seat_Layout(String key,int fare) {
		 
		 textField.setBounds(50,20,150,200);	 
		 label1.setBounds(10,250,100,50);
		 label2.setBounds(10,300,100,50);
		 this.key = key;
		 Field1.setBounds(120,265,30,20);
		 Field2.setBounds(120,310,100,30);
		 
		 button.setBounds(80, 400, 100, 30);
		 button.addActionListener(this);
		 warn.setBounds(80,350,150,50);
		 
		 
		 frame.setSize(300,500);
		 frame.add(textField);
		 frame.add(label1);
		 frame.add(label2);
		 frame.add(Field1);
		 frame.add(Field2);
		 frame.add(button);
		 frame.add(warn);
		 frame.setLocationRelativeTo(null);
		 frame.setLayout(null);
		 frame.setVisible(true);
		 String P = convert(show_seats(key));
		
		 textField.setText(P);
		 
		 textField.setEditable(false);
	 }
	 
	 
	 public void write_into_file(String Bus_number,int [][] seats) {
		 
		 try {
		 FileInputStream file = new FileInputStream("Seat_info.ser");
		 ObjectInputStream os = new ObjectInputStream(file);
		 map = (HashMap<String, int[][]>) os.readObject();
		 file.close();
		 }catch(Exception e) {}
		 map.put(Bus_number, seats);
		 try {
		 FileOutputStream file = new FileOutputStream("Seat_info.ser");
		 ObjectOutputStream os = new ObjectOutputStream(file);
		 os.writeObject(map);
		 os.close();
		 file.close();
		 }catch(Exception e) {}
	}
	 


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			if(check_seat_selection(key)==false) {
				Field1.setText(null);Field2.setText(null);
				warn.setText("Wrong Credentials!");}
			else {
				frame.dispose();
				d.fill_Details(Integer.parseInt(Field1.getText()),key,Field2.getText());
			}
			}
			
		}
	}
	 


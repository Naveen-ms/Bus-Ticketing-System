import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.io.*;
import java.util.Arrays;
class Details implements ActionListener{
	private JButton button = new JButton("Submit");
	private JFrame frame = new JFrame();
	private JTable tabel;
	private int Noseats = 0;
	private String seats = null;
	private String key = null;
	private JOptionPane confrm = new JOptionPane();
	public void fill_Details(int Noseats,String key,String seats){
		this.seats = seats;
		this.Noseats = Noseats;
		this.key = key;
		String Header[] = {"Seat.No","Name","Phone Number","Gender"};
		
		String [][]details = new String[Noseats][4];
		
		String []P = seats.split(",");
		for(int y=0;y<Noseats;y++) {details[y][0]=String.valueOf(P[y]);}
		
		
		
		tabel = new JTable(details,Header);
		JScrollPane pane = new JScrollPane(tabel); 
		
		pane.setBounds(0, 0, 500, 300);
		button.setBounds(150, 400, 120, 30);
		button.addActionListener(this);
		
		
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.add(pane);
		frame.add(button);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	
	
	
	public void get_table_values() {
		String []constarints = {"Seat:","Passenger Name:","Phone Number:","Gender:"};
		try {
			String File= key+".txt";
			FileWriter writer = new FileWriter(File,true);
			for(int t=0;t<Noseats;t++) {
				for(int j=0;j<4;j++) {
					writer.write(constarints[j]+String.valueOf(tabel.getValueAt(t, j)));
					writer.write("\n");
				}
				writer.write("\n");
			}
		writer.close();	
		}catch(Exception e) {}
		
		
	}
	
	public void ticket_generate() {
		writingIntoFile w = new writingIntoFile();
		String result[] = new String[7];
		int k=0;
		String []constarints = {"Seat","Passenger Name","Phone Number","Gender"};
		String []details  = {"Bus Name: ","Bus Number: ","Start Point: ","End Point: ","StartDateTime: ","EndDateTime: "};
		for(String s:w.get_bus_details(key)) {result[k]=s;k++;}
		
		try {
			FileWriter writer = new FileWriter("Ticket.txt");
			for(int i=0;i<6;i++) {writer.write(details[i]);writer.write(result[i]);writer.write("\n");}
			int  d = Integer.valueOf(result[6])*Noseats;
			
			writer.write("************************************************************************************************************");
			writer.write("\n");
			for(int h=0;h<4;h++) {
				String format = "%1$-25s";
				String y = String.format(format,constarints[h]);
				writer.write(y);
				writer.write("\t");
			}
			writer.write("\n");;
			
			
			for(int t=0;t<Noseats;t++) {
				for(int j=0;j<4;j++) {
					String format = "%1$-25s";
					String y = String.format(format,String.valueOf(tabel.getValueAt(t, j)));			
					writer.write(y);
					writer.write("\t");
				}
				writer.write("\n");
			}
			writer.write("Total Fare: "+String.valueOf(d)+"/-"+"\n");
			writer.write("************************************************************************************************************");
			
			writer.write("\n");
			writer.write("\t\t\tHappy Journey");
			writer.write("\n");
			writer.write("\t\t\tNo Cancellation,Sorry!");
			
			
			writer.close();
		}catch(Exception e) {System.out.print(0);}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			get_table_values();
			ticket_generate();
			frame.dispose();
			String options[] = {"OK"};
			confrm.showOptionDialog(null, "Your Tickets are Booked", "Confirmation", 0,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		}
		
	}}

public class Passenger_details {
	public static void main(String [] args) {
		
		//confrm.showConfirmDialog(null, "Your Tickets are Booked");
	
	}
	
}

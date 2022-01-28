import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


class Passenger implements ActionListener{
	private JFrame frame = new JFrame();
	
	private JLabel label1 =new JLabel("Start Point: ");
	private JLabel label2 =new JLabel("Destination: ");
	private JButton button = new JButton("Check Bus Availability");
	private Tablee T = new Tablee();
	private JComboBox CB1; 
	private JComboBox CB2; 
	
	public void set_up_Pass() {
		
		CB1 = new JComboBox(writingIntoFile.read_Source("SOURCE"));
		CB2 = new JComboBox(writingIntoFile.read_Source("DESTINATION"));
		
		frame.setSize(400,250);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.cyan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label1.setBounds(20,15,120,50);
		label2.setBounds(20,65,120,50);
	//	label3.setBounds(20,115,120,50);
		
		button.setBounds(150, 170, 150, 30);
		CB1.addActionListener(this);
		CB2.addActionListener(this);
		button.addActionListener(this);
		
		CB1.setBounds(150,25,200,30);
		CB2.setBounds(150,75,200,30);
		
		frame.add(label1);
		frame.add(label2);

		frame.add(CB1);
		frame.add(CB2);
		//frame.add(textField3);
		frame.add(button);
		
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}
	
	public String[][] convertLtS(List<ArrayList<String>> K) {
  
		
		String[][] array = new String[K.size()][];
		for (int i = 0; i < K.size(); i++) {
		    ArrayList<String> row = K.get(i);
		    array[i] = row.toArray(new String[row.size()]);
		}
		return array;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {								
			writingIntoFile w = new writingIntoFile();
			List<ArrayList<String>>  P = w.readAllData((String)CB1.getSelectedItem() ,(String) CB2.getSelectedItem());	
			T.set_Tablee(convertLtS(P));
			frame.dispose();			
		}
		
	}
	
}

public class Client_Passenger {
	public static void main(String [] args) {

		//System.out.print();
		//for(String i:) {System.out.println(i);}
	}
}

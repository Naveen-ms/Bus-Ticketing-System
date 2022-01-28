import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


class Tablee implements ActionListener{
	JTable jt;
	JButton button = new JButton("Select Seats");
	String[] column_header = {"Bus-Name","Bus-Number","Source","Destination","StartDateTime","EndDateTime","FarePS"};
	JFrame frame = new JFrame();
	String key = null;
	int fare = 0;
	public void set_Tablee(String[][]details){
		jt = new JTable(details,column_header);		
		JScrollPane pane = new JScrollPane(jt);
		jt.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	        	   JTable target = (JTable)me.getSource();
	               int row = target.getSelectedRow();
	               key = (String) jt.getValueAt(row, 1);
	               fare = Integer.valueOf((String) jt.getValueAt(row, 6));
	         }
	      });
						
		pane.setBounds(0, 0, 700, 500);
		button.setBounds(350,550,150,50);
		button.addActionListener(this);
		frame.add(pane);
		frame.add(button);
		frame.setSize(700,700);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			frame.dispose();
			SEAT_file sf = new SEAT_file();
			sf.set_seat_Layout(key,fare);
		}
	}
	

	
}


public class Jtable {
	
}

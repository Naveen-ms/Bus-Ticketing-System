import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminOrPassenger implements ActionListener {
	private JButton Admin = new JButton("Admin");
	private JButton Passenger = new JButton("Passenger");
	private JFrame frame = new JFrame();
	
	public void set_up() {
		
		Admin.setBounds(50,50,100,50);
		Passenger.setBounds(160,50,100,50);
		Admin.setFocusable(false);
		Admin.addActionListener(this);
		Passenger.addActionListener(this);
		Passenger.setFocusable(false);
		
		
		frame.add(Admin);
		frame.add(Passenger);
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Admin) {
			AdminSide admin = new AdminSide();
			admin.set_up();
			frame.dispose();
		}
		else if(e.getSource()==Passenger) {
			Passenger P = new Passenger();
			P.set_up_Pass();
			frame.dispose();
		}
	}
	

	
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class SignLog extends JFrame implements ActionListener{
	private JButton signup = new JButton("SIGN-UP");
	private JButton login = new JButton("LOG-IN");
	
	SignLog(){
		
		signup.setBounds(50,50,100,50);
		login.setBounds(160,50,100,50);
		signup.setFocusable(false);
		signup.addActionListener(this);
		login.addActionListener(this);
		login.setFocusable(false);
		this.setSize(350,200);
		this.setLayout(null);
		this.setTitle("Option Page");
		this.setLocationRelativeTo(null);
		this.add(login);
		this.add(signup);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			this.dispose();
			MyFrame f1 = new MyFrame();
			f1.loginPage();
		}
		if(e.getSource()==signup) {
			this.dispose();
			SignGUI f2 = new SignGUI();
			f2.sign_page();
		}
		
	}	
}

public class OptionBegg {
	public static void main(String [] args) {
		new SignLog();
	}
}

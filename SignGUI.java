import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignGUI extends MyFrame implements ActionListener {
	private JLabel label3 = new JLabel("Re-enter:");
	private JTextField textfield3 = new JTextField();
	private JOptionPane pane = new JOptionPane();
	public void sign_page() {
		this.loginPage();
		this.setSize(350,270);
		button.setBounds(130, 180, 80, 30);
		label3.setBounds(30, 90, 130,50);
		textfield3.setSize(180, 30);
		textfield3.setBounds(120,100,180,30);
		this.setTitle("Sign_in Page");
		this.add(textfield3);
		this.setLocationRelativeTo(null);
		this.add(label3);
		this.setVisible(true);
		
	}
	public boolean checkPass(String p,String rp){
		if(p.equals(rp)) {return true;}
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			if(checkPass(textfield2.getText(),textfield3.getText())==true) {
				UserName_Pass u1 = new UserName_Pass();
				u1.add_new(textfield1.getText(),textfield3.getText());
				this.dispose();
				String options[] = {"OK"};
				pane.showOptionDialog(null, "You Signed-up Sucessfully", "Confirmation", 0,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
			}}
			else {
				textfield2.setText(null);
				textfield3.setText(null);
				
			}
		}
		
	}



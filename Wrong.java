import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JTextField textfield1 = new JTextField();
	JTextField textfield2 = new JTextField();
	JLabel warn = new JLabel();
	JButton button = new JButton("Submit");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	public void loginPage(){
		label1.setText("UserName:");
		label2.setText("Password:");
	
		
		textfield1.setSize(180, 30);
		textfield1.setBounds(120,40,180,30);
		
		textfield2.setSize(180, 30);
		textfield2.setBounds(120,70,180,30);
		
		label1.setBounds(20,30,130,50);
		label2.setBounds(20,60,130,50);
		warn.setBounds(70,90,130,50);

		button.setBounds(120, 130, 80, 30);
		button.setFocusable(false);
		button.addActionListener(this);
	

		this.setSize(350,200);
		this.setLayout(null);
		this.setTitle("Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(button);
		this.add(label1);
		this.add(label2);
		
		this.add(textfield1);
		this.add(textfield2);
		this.add(warn);


		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e){  
         if(e.getSource()==button) {
        	 
        	 LogUP L = new LogUP(textfield1.getText(),textfield2.getText());
        	 if(L.LoGIE()==1) {
        	 	this.dispose();
        	 	System.out.print("LOggedIn");
        		AdminOrPassenger P = new AdminOrPassenger();
        		P.set_up();
        	 }
        	 else if(L.LoGIE()==0){textfield1.setText(null);
        	 		textfield2.setText(null);
        	 		warn.setText("wrong userId/Pass!!");
        	 }
        	 }
         }
	}


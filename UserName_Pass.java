import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
class UserName_Pass {
	
	
		
	
	public void add_new(String user,String pass) { 
	HashMap<String,String> map = new HashMap<>();
	
	try {
		FileInputStream file = new FileInputStream("Secret.ser");
		ObjectInputStream os = new ObjectInputStream(file);
		map = (HashMap<String, String>) os.readObject();
		//System.out.print(os.readObject());
		}
		catch(Exception e) {}

		map.put(user, pass);	
	
		try {
			FileOutputStream file = new FileOutputStream("Secret.ser");
			ObjectOutputStream os = new ObjectOutputStream(file);
			os.writeObject(map);
			}
	catch(Exception e) {System.out.print("Error");}
	System.out.println(map);
}}


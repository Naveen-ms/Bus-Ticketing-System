
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

class LogUP{
	
	private String user;
	private String Pass;
	
	LogUP(String s,String p){
		this.user = s;
		this.Pass = p;
	}
	
	
	public int LoGIE(){
		HashMap<String,String> map = new HashMap<>();
		
		try {
			FileInputStream file = new FileInputStream("Secret.ser");
			ObjectInputStream os = new ObjectInputStream(file);
			map = (HashMap<String, String>) os.readObject();
			}
			catch(Exception e) {System.out.print("Error");}
			
		System.out.print(map);
		if(map.containsKey(user)==true) {
			String check = map.get(user);
			if(check.equals(Pass)) {return 1;}
		}
		else {
			return 0;
		}
		return 0;
	}
	}





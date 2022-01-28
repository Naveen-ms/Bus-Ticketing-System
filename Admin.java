import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

class admin implements Serializable{
	  String Bus_name;
	  String Bus_number;
	  String source;
	  String Destination;
	  Date startDateTime;
	  Date EndDateTime;
	  SimpleDateFormat dateTime;
	  int [][] seats = new int[11][4];
	  double farePs;
	  Date today = new Date();
	public void setBus_Name(String Bn) {
		Bus_name = Bn;
	}
	public void setBus_number(String BS) {
		Bus_number = BS;
	}
		
	public void setFare(int f) {
		farePs = f ;
	}
	
	public void setBus_source(String src) {
		source = src;
	}
	public void setBus_destination(String dsnt) {
		Destination = dsnt;
	}	

	
	public void set_seats(int row) {
		int y = 1;
		for(int i =0 ;i<row;i++) {
			for(int j=0;j<4;j++) {
				seats[i][j] = y;
				y++;
			}
			}
	}

	
	
	
	
	
	
	public void Enter_Details() {
		this.set_seats(11);
		Date check1 = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter BusName:");
		setBus_Name(scan.nextLine());
		System.out.print("Enter Bus_number:");
		setBus_number(scan.nextLine());
		
		System.out.print("Enter SC:");
		setBus_source(scan.nextLine());
		
		System.out.print("Enter DS:");
		setBus_destination(scan.nextLine());
		
		dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println();
		System.out.print("Start-Date: ");
		String s1 = scan.nextLine();
		System.out.print("Start-Time: ");
		String s2 = scan.nextLine();
		try {
		check1 = dateTime.parse(s1+" "+s2);
		if(check1.after(today)) {startDateTime = check1;}
		}catch(Exception e) {}
		
		System.out.print("End-Date: ");
		String s3 = scan.nextLine();
		System.out.print("End-Time: ");
		String s4 = scan.nextLine();
		try {
			Date check2 = dateTime.parse(s3+" "+s4);
			if(check2.after(check1)) {EndDateTime = check2;}
			
		}catch(Exception e) {}
		
		System.out.print("Enter Fare per Seat:");
		setFare(scan.nextInt());
		scan.close();
		
	}
	
}


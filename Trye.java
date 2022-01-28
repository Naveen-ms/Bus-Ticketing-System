//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Trye {
	int row = 11;
	int [][]seats = new int[row][4];
	public static void main(String [] args) {
//		Date d = null;
//		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm");
//		
//		Date today = new Date();
//		System.out.println(today);
//		String s = "26/07/2021" + " " + "23:10";
//		try{d = date.parse(s);System.out.println(d);}catch(Exception e) {System.out.println(s);}
//		System.out.println(today.after(d));
		admin A = new admin();
//		Trye t = new Trye();
//		t.set_seats(11);
//		t.showLayout();
//
//		
//		t.showLayout();
		A.Enter_Details();
		System.out.println(A.Bus_name);
		System.out.println(A.Bus_number);
		System.out.println(A.source);
		System.out.println(A.Destination);
		System.out.println(A.startDateTime);
		System.out.println(A.EndDateTime);

		
//		Date d;
//		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm");
//		String s = "24/07/2021" + " " + "23:10";
//		try{d = date.parse(s);System.out.print(d);}catch(Exception e) {System.out.print(s);}
		
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
	
	public void select_seat_no(int seatNo) {
		int r = (int)Math.ceil((float)seatNo/4);
		for(int i=0;i<4;i++) {
			if(seats[r-1][i]== seatNo) 
			{seats[r-1][i]= 0;}}
		}
	
	
	public void showLayout() {
	
		for(int i =0 ;i<row;i++) {
			for(int j=0;j<5;j++) {
				if(j==2) {System.out.print("  ");}
				if(j<2 && seats[i][j]<=9) {System.out.print(" "+seats[i][j]+" ");}
				else if(j>2&& seats[i][j-1]<=9) {System.out.print(" "+seats[i][j-1]+" ");}
				else if(j<2 && seats[i][j]>9) {System.out.print(seats[i][j]+" ");}
				else if(j>2&& seats[i][j-1]>9) {System.out.print(seats[i][j-1]+" ");}
			}
		System.out.println();
		}
	}
	
}

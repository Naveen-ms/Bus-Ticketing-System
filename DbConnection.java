
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

import java.text.SimpleDateFormat;
//import java.util.*;
public class DbConnection {
  public static Connection connect() {
    Connection con = null; 
    try {
      //Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:BusAdminDB.db"); // connecting to our database
      System.out.println("Connected!");
    } catch (/*ClassNotFoundException |*/ SQLException e ) {
      System.out.println(e+"");
    }
    return con; 
  }
  
  public static void main(String [] args) {
	
	  SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	  java.util.Date date1=null,date2=null;
	  try {
	  date1 = date.parse("1/08/2021 18:00");
	  date2 = date.parse("1/08/2021 14:00");
	  }catch(Exception e) {}
	
	  
	  writingIntoFile.insert("KSRTC", "KA-07-PP-9012","Bangalore","Chennai","1/08/2021 18:00","1/08/2021 14:00", 900, 10);
  }
  
}
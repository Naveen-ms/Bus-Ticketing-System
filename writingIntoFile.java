import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class writingIntoFile {

	public static void insert(String BusName,String BusNumber,String Source,String Destination,String StartDateTime,String EndDateTime,
		int FarePS,int NOSRows) {
		 Connection con = DbConnection.connect();
		  PreparedStatement ps = null; 
		    
		  try {
		    
			String sql = "INSERT INTO BusAdminDB(BusName,BusNumber,Source,Destination,StartDateTime,EndDateTime,FarePS,NOSRows) VALUES(?,?,?,?,?,?,?,?) ";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, BusName);
		    ps.setString(2, BusNumber);
		    ps.setString(3, Source);
		    ps.setString(4, Destination);
		    ps.setString(5, StartDateTime);
		    ps.setString(6, EndDateTime);
		    ps.setInt(7, FarePS);
		    ps.setInt(8, NOSRows*4);	    
	
		    ps.execute();
		    
		    System.out.println("Data has been inserted!");
		  } catch(SQLException e) {
			  //System.out.println(1111);
			  System.out.println(e.toString());
		    
		    // always remember to close database connections
		  } finally {
		    try{
		      ps.close();
		      con.close();
		    } catch(SQLException e) {
		      System.out.println(e.toString());
		    }
	}}
	
	
	
	public static String[] read_Source(String what) {
		HashSet<String> set = new HashSet<String>();
		Connection con = DbConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	   if(what == "SOURCE") {
	    try {
	          String sql = "SELECT SOURCE FROM BusAdminDB";
		      ps = con.prepareStatement(sql); 
		      //ps.setString(1, "SOURCE");
		      
		  
		      rs = ps.executeQuery();
		      //System.out.println("ALL USERS\n");
		      while(rs.next()) {
		        String Sourcee = rs.getString("SOURCE"); 
		        set.add(Sourcee);
		      }
		    } catch(SQLException e) {
		      
		    } finally {
		      try {
		        rs.close();
		        ps.close();
		        con.close(); 
		      } catch(SQLException e) {
		        System.out.println(e.toString());
		      }
		    }}
	   else if(what == "DESTINATION") {
		   try {
		          String sql = "SELECT DESTINATION FROM BusAdminDB";
			      ps = con.prepareStatement(sql); 
			      //ps.setString(1, "SOURCE");
			      
			  
			      rs = ps.executeQuery();
			      //System.out.println("ALL USERS\n");
			      while(rs.next()) {
			        String Sourcee = rs.getString("DESTINATION"); 
			        set.add(Sourcee);
			      }
			    } catch(SQLException e) {
			      
			    } finally {
			      try {
			        rs.close();
			        ps.close();
			        con.close(); 
			      } catch(SQLException e) {
			        System.out.println(e.toString());
			      }
			    }
	   }
	    int i=0;
		String [] r = new String[set.size()];
		for(String ser:set) {r[i++] = ser;}
	    return r;
	}
	
	
	
	public List<ArrayList<String>> readAllData(String Source,String Destination) {
		
		List<ArrayList<String>> L = new ArrayList<ArrayList<String>>();
	    Connection con = DbConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	    try {
	      String sql = "SELECT * FROM BusAdminDB WHERE SOURCE = ? AND DESTINATION = ?";
	      ps = con.prepareStatement(sql); 
	      ps.setString(1, Source);
	      ps.setString(2, Destination);
	  
	      rs = ps.executeQuery();
	      //System.out.println("ALL USERS\n");
	     
	      while(rs.next()) {
	    	  ArrayList<String> dummy = new ArrayList<>();
	    	  dummy.add(rs.getString("BusName"));
	    	  dummy.add(rs.getString("BusNumber"));
	    	  dummy.add(rs.getString("Source"));
	    	  dummy.add(rs.getString("Destination"));
	    	  dummy.add(rs.getString("StartDateTime"));
	    	  dummy.add(rs.getString("EndDateTime"));
	    	  dummy.add(rs.getString("FarePS"));
	    	  L.add(dummy);
	      }
	      
	      
	    } catch(SQLException e) {
	      System.out.println("No Routes Found");
	    } finally {
	      try {
	        rs.close();
	        ps.close();
	        con.close(); 
	      } catch(SQLException e) {
	        System.out.println(e.toString());
	      }
	    }
	    
	    return L;
	  }
	
	public String[] get_bus_details(String key) {
		String [] empty = new String [7];
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM BusAdminDB WHERE BusNumber = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, key);
			rs = ps.executeQuery();
			empty[0]=rs.getString("BusName");
			empty[1]=rs.getString("BusNumber");
			empty[2]=rs.getString("Source");
			empty[3]=rs.getString("Destination");
			empty[4]=rs.getString("StartDateTime");
			empty[5]=rs.getString("EndDateTime");
			empty[6]=rs.getString("FarePS");
			

		}catch(Exception e) {}
		return empty;
	}
	
	
//	private static void readSpecificRow() {
//    // lets read specific row on the database
//    Connection con = DbConnection.connect(); 
//    PreparedStatement ps = null; 
//    ResultSet rs = null; 
//    try {
//      String sql = "Select first_name from contacts where email = ? "; 
//      ps = con.prepareStatement(sql); 
//      ps.setString(1, "ads");
//      rs = ps.executeQuery(); 
//      
//      // we are reading one row, so no need to loop 
//      String firstName = rs.getString(1); 
//      System.out.println(firstName);// it should give us eunice
//      
//    } catch(SQLException e) {
//      System.out.println(e.toString());
//    } finally {
//      // close connections
//      try{
//        rs.close(); 
//        ps.close();
//        con.close(); 
//      } catch (SQLException e) {
//        // TODO: handle exception
//        System.out.println(e.toString());
//      }
//      
//    }
//  }


	
//	private static void deleteRow() {
//	    Connection con = DbConnection.connect(); 
//	    PreparedStatement ps = null; 
//	    try {
//	      String sql = "delete from contacts WHERE email = ? "; 
//	      ps = con.prepareStatement(sql); 
//	      ps.setString(1, "ads");
//	      ps.execute();
//	      System.out.println("Data has been deleted!");
//	    } catch (Exception e) {
//	      // TODO: handle exception
//	      System.out.println(e.toString());
//	    } finally {
//	      //always remember to close, am forgetting because this is teaching purposes
//	      try {
//	        ps.close();
//	        con.close(); 
//	      } catch (SQLException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//	      } 
//	      
//	      
//	    }
//	  }
//	
//	public static void main(String [] args) {
//
//		//DbConnection.connect();
//		//insert(2,"Karthik","MS","asd","080");
//		//readSpecificRow();
//		//readAllData();
	
}

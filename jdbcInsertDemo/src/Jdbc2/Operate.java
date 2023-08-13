package Jdbc2;

import java.sql.PreparedStatement;

public class Operate {

	public  void  save ( Object o) {
		
		if (o instanceof Employee)
			try {
		  Employee em=(Employee)o;
		  
		   PreparedStatement ps=ConnectionProvider.getCon().prepareStatement("insert into employee values(?,?,?) ");
		   ps.setInt(1, em.getId());
		   ps.setString(2, em.getName());
		   ps.setString(3, em.getAdress());
		      int i=ps.executeUpdate();
		      if(i>0) 
		    	  System.out.println("data inserted");
		      else 
				 System.out.println("data not inserted");
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

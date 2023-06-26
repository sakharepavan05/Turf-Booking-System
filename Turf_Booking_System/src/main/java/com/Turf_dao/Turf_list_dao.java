package com.Turf_dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.Turf_bin.Login_bo;
import com.Turf_bin.Turf_list_bo;



public class Turf_list_dao {
	public static Connection connect()
	{
		Connection con=null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/turf_Booking_System?useSSL=false&allowPublicKeyRetrieval=true";
			 String user="root";
			 String pass="Pavan@143";
			 con= DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int add_turf(Turf_list_bo lb)
	{
		int status=0;
		try {
			Connection con=Login_dao.connect();
			PreparedStatement ps=con.prepareStatement("insert into turf_list(Name,Location,Description) values(?,?,?)");
			ps.setString(1, lb.getName());;
			ps.setString(2,lb.getLocation());
			ps.setString(3,lb.getDescription());
			
		status=ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Turf_list_bo> Turf_list()
	   {
		  
		   List<Turf_list_bo> list=new ArrayList<Turf_list_bo>();
		   String query="select * from turf_list";
		   try
		   {
			   Connection con=Turf_list_dao.connect();
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   Turf_list_bo lb=new Turf_list_bo();
				   lb.setName(rs.getString(1));
				   lb.setLocation(rs.getString(2));
				   lb.setDescription(rs.getString(3));
				   list.add(lb);
			   }
		   } 
		   catch (Exception e) 
		   {
			System.out.println(e);
		   }
		   return list;	   
      }
	public static int delete(String name)
	   {
		   int status =0;
		    String query="delete from turf_list where Name=?";
		    try
		    {
		    	Connection con=Turf_list_dao.connect();
		    	PreparedStatement ps=con.prepareStatement(query);
		    	ps.setString(1, name);
		    	status =ps.executeUpdate();
		    	ps.close();
		    	
		    }
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    }
		    return status;
}
}

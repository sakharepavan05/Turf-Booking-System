package com.Turf_dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.Turf_bin.Booking_bo;
import com.Turf_bin.Login_bo;


public class Login_dao {
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
	public static boolean Admin_login(Login_bo lb)
	{
	   boolean result=false;
		
		try {
			String q="select * from User_SignUp where  user_name=? and Password=?";
			Connection con=Login_dao.connect();
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,lb.getId());
			ps.setString(2,lb.getPassword());
			
			ResultSet rs=ps.executeQuery();
			result =rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	public static int SignUP(Login_bo lb)
	{
		int status=0;
		try {
			Connection con=Login_dao.connect();
			PreparedStatement ps=con.prepareStatement("insert into User_SignUp(user_name,password,Email_id,address) values(?,?,?,?)");
			ps.setString(1,lb.getId());
			ps.setString(2,lb.getPassword());
			ps.setString(3,lb.getEmail());
			ps.setString(4,lb.getAddress());
			
		status=ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Login_bo> user_list()
	   {
		  
		   List<Login_bo> list=new ArrayList<Login_bo>();
		   String query="select * from User_SignUp";
		   try
		   {
			   Connection con=Login_dao.connect();
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   Login_bo lb=new  Login_bo();
				   lb.setId(rs.getString(1));
				   lb.setPassword(rs.getString(2));
				   lb.setEmail(rs.getString(3));
				   lb.setAddress(rs.getString(4));
				   list.add(lb);
			   }
		   } 
		   catch (Exception e) 
		   {
			System.out.println(e);
		   }
		   return list;
	   }
	public static int Book(Booking_bo lb)
	{
		int status=0;
		try {
			Connection con=Login_dao.connect();
			PreparedStatement ps=con.prepareStatement("insert into turf_booking(Turf_Name,Time,Date) values(?,?,?)");
			ps.setString(1,lb.getName());
			ps.setString(2,lb.getTime());
			ps.setString(3,lb.getDate());
			
			
		status=ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Booking_bo> Boking_list()
	   {
		  
		   List<Booking_bo> list=new ArrayList<Booking_bo>();
		   String query="select * from turf_booking";
		   try
		   {
			   Connection con=Login_dao.connect();
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   Booking_bo lb=new  Booking_bo();
				   lb.setName(rs.getString(1));
				   lb.setTime(rs.getString(2));
				   lb.setDate(rs.getString(3));
				   list.add(lb);
			   }
		   } 
		   catch (Exception e) 
		   {
			System.out.println(e);
		   }
		   return list;
	   }
}

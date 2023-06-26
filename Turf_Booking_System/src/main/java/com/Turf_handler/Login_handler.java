package com.Turf_handler;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Turf_bin.Login_bo;
import com.Turf_dao.Login_dao;



/**
 * Servlet implementation class Login_handler
 */
@WebServlet("/Login_handler")
public class Login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login_handler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("user");
		String pass=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		Login_bo lb=new Login_bo(id,pass,email,address);
		
		if(Login_dao.Admin_login(lb))
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Enter Correct User And Password");
			RequestDispatcher rd=request.getRequestDispatcher("Admin_login.html");
			rd.include(request, response);
		}
	}

}

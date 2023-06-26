package com.Turf_handler;

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
 * Servlet implementation class SignUp_handler
 */
@WebServlet("/SignUp_handler")
public class SignUp_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		Login_bo lb=new Login_bo(user,password,email,address);
		
		int status=Login_dao.SignUP(lb);
		if(status >0)
		{
			pw.println("Register sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("Admin_login.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Register Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("SingUp_Admin.html");
			rd.include(request, response);
		}
	}

}

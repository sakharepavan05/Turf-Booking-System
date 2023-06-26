package com.Turf_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Turf_bin.Login_bo;
import com.Turf_dao.Login_dao;

/**
 * Servlet implementation class view_user_handler
 */
@WebServlet("/view_user_handler")
public class view_user_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_user_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<h1><a href='index.html'>Home</a></h1>");
		pw.println("<h1>User List</h1>");
		List<Login_bo> list=Login_dao.user_list();
		pw.print("<table border='1' width='100%'");
		pw.print("<tr><th>User</th><th>Password</th><th>Email</th><th>Address</th></tr>");
		for(Login_bo e:list)
		{
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>");

		}
		pw.print("</table>");
        pw.close();
	}
}



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
import com.Turf_bin.Turf_list_bo;
import com.Turf_dao.Login_dao;
import com.Turf_dao.Turf_list_dao;

/**
 * Servlet implementation class Add_turf_handler
 */
@WebServlet("/Add_turf_handler")
public class Add_turf_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_turf_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String Location=request.getParameter("Location");
		String Description=request.getParameter("Description");
		Turf_list_bo lb=new Turf_list_bo(name,Location,Description);
		
		int status=Turf_list_dao.add_turf(lb);
		if(status >0)
		{
			pw.println("Turf Add sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Add Turf Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("Add_turf.html");
			rd.include(request, response);
		}
	}

}

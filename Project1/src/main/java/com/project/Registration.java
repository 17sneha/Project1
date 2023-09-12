package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		Query q=new Query();
		try
		{
			int result=q.register(eid,fname, lname, uname, upass);
			
			if(result>0)
			{
				System.out.println("Registeration successfull");
				RequestDispatcher rd=request.getRequestDispatcher("./login.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Registeration failed");
				RequestDispatcher rd=request.getRequestDispatcher("./Registeration.jsp");
				rd.forward(request, response);
			}	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}

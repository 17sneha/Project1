package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rd=null;
		
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
	
		Query q=new Query();
		
		try
		{
		String result=q.login(uname, upass);
		
		
		
		
		
		if(result.equals(uname))
		{
			System.out.println("Login succesfull");
			rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Login failed");
			rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}

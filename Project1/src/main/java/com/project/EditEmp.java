package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditEmp() {
        super();
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		Query q=new Query();
		
		try
		{
			int s=q.edit(eid, fname, lname, uname, upass);
			
			if(s>0)
			{
				System.out.println("Successfully Edited");
				RequestDispatcher rd=request.getRequestDispatcher("./EmpDetails.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("failed to edit");
				RequestDispatcher rd=request.getRequestDispatcher("./EditEmpDetails.jsp");
				rd.forward(request, response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}

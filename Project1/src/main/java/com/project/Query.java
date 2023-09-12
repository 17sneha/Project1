
package com.project;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class Query 
{
	
	//Resultset rs=null;
	
	public int register(String Eid, String Firstname,String Lastname,String Username,String Password) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String qry="insert into RegisterPage values('"+Eid+"','"+Firstname+"','"+Lastname+"','"+Username+"','"+Password+"')";
			int count=st.executeUpdate(qry);  
		return count;
	}
	
	public int edit(String Eid, String Firstname,String Lastname,String Username,String Password) throws ClassNotFoundException, SQLException
	
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String qry="update RegisterPage set Firstname='"+Firstname+"',Lastname='"+Lastname+"',Username='"+Username+"',Password='"+Password+"' where Eid='"+Eid+"'";
		int count=st.executeUpdate(qry);
		return count;	
				
	}
	
	public String login(String Username,String Password) throws SQLException, ClassNotFoundException
	{
		
		String User="";
		String Pass="";
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String qry="select * from RegisterPage where Username='"+Username+"' and Password='"+Password+"'";
		ResultSet rs= st.executeQuery(qry);
		
		while(rs.next())
			{
		 User=rs.getString("Username");
		 Pass=rs.getString("Password");
			}
		return User;
		
	}
	
	
	
	}






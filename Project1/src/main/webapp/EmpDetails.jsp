<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="com.project.DBConnection" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Employee Record</h1>

<table border="1">
<tr>
<th>Eid</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Username</th>
<th>Password</th>
<th>Edit</th>
</tr>

<%
ResultSet rs=null;

String eid="";
String fname="";
String lname="";
String uname="";
String upass="";


Connection con=DBConnection.getConnection();
String qry="select * from RegisterPage";
Statement st=con.createStatement();
rs=st.executeQuery(qry);

while(rs.next())
{
	eid=rs.getString("Eid");
	fname=rs.getString("Firstname");
	lname=rs.getString("Lastname");
	uname=rs.getString("Username");
	upass=rs.getString("Password");
%>

<table border="1">
<tr>
<td><%=eid%></td>
<td><%=fname%></td>
<td><%=lname%></td>
<td><%=uname%></td>
<td><%=upass%></td>
<td><a href="./EditEmpDetails.jsp">edit</a></td>

</tr>
</table>
<%}%>


</table>

</body> 

<style>

body
{
background-color:grey;
}

th{
background-color:pink;
}
th,td
{

width:200px;
} w2
td{
background-color:white;
}
</style>

</html>
 
 
 
 
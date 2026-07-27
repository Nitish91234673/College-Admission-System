package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegServlet extends HttpServlet {
	Connection con;
	public void init(ServletConfig config) 
			throws ServletException {
		
		try {
		Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		try {
		String s1=request.getParameter("fname");
		String s2=request.getParameter("lname");
		String s3=request.getParameter("uname");
		String s4=request.getParameter("pword");
		String s5=request.getParameter("contact");
		String s6=request.getParameter("gender");
	    PreparedStatement pstmt=con.prepareStatement("insert into sweety values(?,?,?,?,?,?)");
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		pstmt.setString(3, s3);
		pstmt.setString(4, s4);
		pstmt.setString(5, s5);
		pstmt.setString(6, s6);
		pstmt.executeUpdate();
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body bgcolor=green text=white> <center>");
		pw.println("<h1>You have Registered Succesfully</h1>");
		pw.println("<a href=login.html>go to login page</a>");
		pw.println("</center></body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

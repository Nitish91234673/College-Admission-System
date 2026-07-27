package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
	public void init(ServletConfig config) throws ServletException {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

	public void destroy() {
         try {
        	 con.close();
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String s1=request.getParameter("applicantid");
        	PreparedStatement pstmt=con.prepareStatement("delete from userinfo where name=?");
        	pstmt.setString(1, s1);
        	pstmt.executeUpdate();
        	PrintWriter pw=response.getWriter();
        	pw.println("<html><body bgcolor=green text=white><center>");
        	pw.println("<h1>Records are successfully Deleted</h1>");
        	pw.println("<a href=delete.html>Go to HomePage</a>");
        	pw.println("</center></body></html>");
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}

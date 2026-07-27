package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   Connection con;   
	public void init(ServletConfig config) 
			throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:"
				+ "thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e){
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String s1=request.getParameter("uname");
			String s2=request.getParameter("pword");
			PreparedStatement pstmt=con.prepareStatement("select * from sweety where uname=? and pword=?");
			pstmt.setString(1,s1);
			pstmt.setString(2, s2);
			ResultSet rs=pstmt.executeQuery();
			PrintWriter pw=response.getWriter();
			if(rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else {
				pw.println("Invalid Username/Password");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

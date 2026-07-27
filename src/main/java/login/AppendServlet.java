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

public class AppendServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) 
					throws ServletException, IOException {
		try {
		String s1=request.getParameter("name");
		String s2=request.getParameter("fname");
		String s3=request.getParameter("mname");
		String s4=request.getParameter("email");
		String s5=request.getParameter("mobno");
		String s6=request.getParameter("dob");
		String s7=request.getParameter("village");
		String s8=request.getParameter("gender");
		String s9=request.getParameter("postoffice");
		String s10=request.getParameter("cast");
		String s11=request.getParameter("police");
		String s12=request.getParameter("distric");
		String s13=request.getParameter("state");
		String s14=request.getParameter("pin");
		String s15=request.getParameter("country");
		String s16=request.getParameter("session");
		String s17=request.getParameter("blood");
		String s18=request.getParameter("marital");
		String s19=request.getParameter("religion");
		String s20=request.getParameter("phy");
		String s21=request.getParameter("nationality");
		String s22=request.getParameter("id");
		String s23=request.getParameter("subject");
		PreparedStatement pstmt=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		pstmt.setString(3, s3);
		pstmt.setString(4, s4);
		pstmt.setString(5, s5);
		pstmt.setString(6, s6);
		pstmt.setString(7, s7);
		pstmt.setString(8, s8);
		pstmt.setString(9, s9);
		pstmt.setString(10, s10);
		pstmt.setString(11, s11);
		pstmt.setString(12, s12);
		pstmt.setString(13, s13);
		pstmt.setString(14, s14);
		pstmt.setString(15, s15);
		pstmt.setString(16, s16);
		pstmt.setString(17, s17);
		pstmt.setString(18, s18);
		pstmt.setString(19, s19);
		pstmt.setString(20, s20);
		pstmt.setString(21, s21);
		pstmt.setString(22, s22);
		pstmt.setString(23, s23);
		pstmt.executeUpdate();
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=green text=white><center>");
		pw.println("<h1>Your details are added succesfully</h1>");
		pw.println("<a href=append.html>Go to Home</a>");
		pw.println("</center></body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

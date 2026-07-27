package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReportServlet extends HttpServlet {
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
		        String cast = request.getParameter("cast");
		        String session = request.getParameter("sessionyear");
		        String gender = request.getParameter("gender");
		        int castcount = 0;
		        int gendercount=0;
		        int sessioncount=0;

		        try {
		            String sql = "SELECT COUNT(*) AS total FROM userinfo WHERE cast = ?";
		            PreparedStatement pstmt1 = con.prepareStatement(sql);
		            pstmt1.setString(1, cast);
		            ResultSet rs1 = pstmt1.executeQuery();
		            if (rs1.next()) {
		                castcount = rs1.getInt("total");
		            }
		            String sql2 = "SELECT COUNT(*) AS total FROM userinfo WHERE sessionyear = ?";
		            PreparedStatement pstmt2 = con.prepareStatement(sql2);
		            pstmt2.setString(1, session);
		            ResultSet rs2 = pstmt2.executeQuery();
		            if (rs2.next()) {
		                sessioncount = rs2.getInt("total");
		            }
		            String sql3 = "SELECT COUNT(*) AS total FROM userinfo WHERE gender = ?";
		            PreparedStatement pstmt3 = con.prepareStatement(sql3);
		            pstmt3.setString(1, gender);
		            ResultSet rs3 = pstmt3.executeQuery();
		            if (rs3.next()) {
		                gendercount = rs3.getInt("total");
		            }

		        PrintWriter out = response.getWriter();
		        out.println("<!DOCTYPE html>");
		        out.println("<html><body bgcolor=cyan><center>");
		        out.println("<h1>Total student of " +cast+ "  is:  "+castcount+ "<br><br>"
		        		+ " Total student of gender "+gender+" is: "+gendercount+"<br><br>"
		        				+ "Total student of session " +session+" is: "+sessioncount+"</h1>");
		        out.println("</center></body></html>");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

	}

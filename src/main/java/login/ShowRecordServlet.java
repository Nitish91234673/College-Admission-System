package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowRecordServlet extends HttpServlet {
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
	};

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          try {
        	  String s1=request.getParameter("sessionyear");
        	  PreparedStatement pstmt=con.prepareStatement("select * from userinfo where sessionyear=?");
        	  pstmt.setString(1, s1);
        	  ResultSet rs=pstmt.executeQuery();
        	  ResultSetMetaData rm=rs.getMetaData();
        	  int n=rm.getColumnCount();
        	  PrintWriter pw=response.getWriter();
        	  pw.println("<html><body bgcolor=cyan text=red><center>");
        	  pw.println("<h1><u>Student Details</u></h1>");
        	  pw.println("<table border=1><tr>"+"<td><b>Name</b></td>"+"<td><b>Father'sName</b></td>"
        	  +"<td><b>Mother'sName</b></td>"+"<td><b>Email id</b></td>"
        	  +"<td><b>Mobile no</b></td>"+"<td><b>DateofBirth</b></td>"
        	  +"<td><b>Village</b></td>"+"<td><b>Gender</b></td>"+"<td><b>PostOffice</b></td>"
        	  +"<td><b>CastCategory</b></td>"+"<td><b>PoliceStation</b></td>"+"<td><b>Distric</b></td>"
        	  +"<td><b>State</b></td>"+"<td><b>Pincode</b></td>"+"<td><b>Country</b></td>"
        	  +"<td><b>SessionYear</b></td>"+"<td><b>Blood group</b></td>"+"<td><b>MaritalStatus</b></td>"
        	  +"<td><b>Religion</b></td>"+"<td><b>Physically challenged</b></td>"+"<td><b>Nationality</b></td>"
        	  +"<td><b>Applicantid</b></td>"+"<td><b>Subject</b></td></tr>");
           	  while(rs.next()) {
        	  pw.print("<tr>"+"<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+
        			  "<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+
        			  "<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td>"+
        			  "<td>"+rs.getString(8)+"</td>"+"<td>"+rs.getString(9)+"</td>"+
        			  "<td>"+rs.getString(10)+"</td>"+"<td>"+rs.getString(11)+"</td>"+
        			  "<td>"+rs.getString(12)+"</td>"+"<td>"+rs.getString(13)+"</td>"+
        			  "<td>"+rs.getString(14)+"</td>"+"<td>"+rs.getString(15)+"</td>"+
        			  "<td>"+rs.getString(16)+"</td>"+"<td>"+rs.getString(17)+"</td>"+
        			  "<td>"+rs.getString(18)+"</td>"+"<td>"+rs.getString(19)+"</td>"+
        			  "<td>"+rs.getString(20)+"</td>"+"<td>"+rs.getString(21)+"</td>"+
        			  "<td>"+rs.getString(22)+"</td>"+"<td>"+rs.getString(23)+"</td></tr>");
        	  }
           	  pw.println("</table></center></body></html>");
        	  
          }catch(Exception e) {
        	  e.printStackTrace();
          }
	}

}

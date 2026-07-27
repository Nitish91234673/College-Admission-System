package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		String s = request.getParameter("uname");
		PrintWriter pw = response.getWriter();

		// Guard: s should always be present (forwarded from LoginServlet)
		if (s == null || s.trim().isEmpty()) {
			s = "Guest";
		}

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("    <head>");
		pw.println("     <style>");
		pw.println("        body { margin:0; padding:0; }");
		pw.println("        .container{");
		pw.println("            width:100%;");
		pw.println("            height:100vh;");
		pw.println("            position:relative;");
		pw.println("            overflow:hidden;");
		pw.println("            padding:20px;");
		pw.println("            box-sizing:border-box;");
		pw.println("        }");
		pw.println("        .menu-link a{");
		pw.println("           text-decoration: none;");
		pw.println("           color:#fff;");
		pw.println("           display:block;");
		pw.println("           width:fit-content;");
		pw.println("           margin:30px 0px;");
		pw.println("           font-size: 30px;");
		pw.println("        }");
		pw.println("        .menu-link a:hover { color: #ffd700; }");
		pw.println("        h1 { color:#fff; text-align:center; }");
		pw.println("        .logout { position:absolute; top:20px; right:20px; }");
		pw.println("        .logout a { color:#fff; font-size:18px; text-decoration:none; background:red; padding:8px 16px; border-radius:5px; }");
		pw.println("     </style>");
		pw.println("    </head>");
		pw.println("    <body style=\"background-image:url('Images/backwelcome2.avif'); background-size:cover; background-position:center;\">");
		pw.println("        <div class=\"logout\"><a href='login.html'>Logout</a></div>");
		pw.println("        <div class=\"container\">");
		pw.println("            <h1><u>Welcome, " + s + "</u></h1>");
		pw.println("            <div class=\"menu-link\">");
		pw.println("                <a href=\"append.html\">Append New Record</a>");
		pw.println("                <a href=\"delete.html\">Delete Record</a>");
		pw.println("                <a href=\"showrecord.html\">Show Specific Record</a>");
		pw.println("                <a href=\"showallrecord.html\">Show All Records</a>");
		pw.println("                <a href=\"search.html\">Search Record</a>");
		pw.println("                <a href=\"contact.html\">Project Summary</a>");
		pw.println("                <a href=\"report.html\">Student Report</a>");
		pw.println("            </div>");
		pw.println("        </div>");
		pw.println("    </body>");
		pw.println("</html>");
	}

}
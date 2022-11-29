package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;

@WebServlet("/ex4")
public class Ex4 extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws 
	IOException,ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title></title></head>");
		out.println("<body>");

		Enumeration e;
		e = request.getParameterNames();
		while(e.hasMoreElements()){
			String ele;
			ele = (String) e.nextElement();
			System.out.println("Ele = " + ele);
			out.println("<p>Request name is: <strong>" + ele +"</strong></p>");
		}

		out.println("</body></html>");
	}
}

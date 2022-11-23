package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;

@WebServlet("/exercise3")
public class Exercise3 extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Get Header Name</title></head>");
		out.println("<body>");

		Enumeration<String> e;
		e = request.getHeaderNames();
		while(e.hasMoreElements()){
			out.println("<p>Element : " + request.getHeader(e.nextElement()) + "</p>");
		}
		out.println("");

	}
}

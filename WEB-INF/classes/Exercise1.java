package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/exercise1")
public class Exercise1 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	IOException,ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Welcom</title></head>");
		out.println("<body>");
		out.println("<h3>Hello World</h3>");
		out.println("</body></html>");
		out.close();
	}
}
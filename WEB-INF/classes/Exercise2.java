package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/exercise2")
public class Exercise2 extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws
	IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Display Info</title></head>");
		out.println("<body>");
		out.println("<h2>Your Info Is: </h2>");
		String registerNo;
		String firstName;
		String lastName;

		registerNo = request.getParameter("registerNo");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");

		out.println("<p>Register No : " + registerNo + "</p>");
		out.println("<p>First Name : " + firstName + "</p>");
		out.println("<p>Last Name : " + lastName + "</p>");
		// String[] a;
		// a = request.getParameterValues("info");
		// out.println("<p>Your RegistrationNO : </p>");
		// for(int i=0;i<a.length;i++){
		// 	out.println("<p>" + a[i] + "</p>");
		// }
		out.println("</body></html>");
		out.close();

	}
}


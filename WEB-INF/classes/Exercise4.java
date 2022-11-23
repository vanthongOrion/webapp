//4. Make a form to input the details of students like regno, first name, last name, phone, education and email and, 
//display all the input values from Servlet by using Enumeration class.

package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import mysql.*;

@WebServlet("/exercise4")
public class Exercise4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html><head>");
		out.println("<title>Student Info Result</title></head>");
		out.println("<body>");
		String regNo;
		String firstName;
		String lastName;
		String phone;
		String mail;
		String education;

		regNo = request.getParameter("registerNo");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		phone = request.getParameter("phone");
		mail = request.getParameter("mail");
		education = request.getParameter("education");
		out.println("<h2>Thank you for your input, This is your info:</h2>");
		out.println("<p><b>Register No</b> : " + regNo+ "</p>");
		out.println("<p><b>First Name</b> : " + firstName+ "</p>");
		out.println("<p><b>Last Name</b> : " + lastName+ "</p>");
		out.println("<p><b>Telephone Number</b> : " + phone+ "</p>");
		out.println("<p><b>Education</b> : " + education+ "</p>");
		out.println("<p><b>Email</b> : " + mail+ "</p>");
		try {
			int count;
			count = ConnectMysql.insertInfo(regNo,firstName,lastName
				,phone,education,mail);
			if(count == -1){
				out.println("<p><strong>Not Successfully insert data into database</strong></p>");
				out.println("<p><strong>Check ConnectMysql class</strong></p>");			
			}else{
				out.println("<strong>Successfully insert " + count + " rows into database</strong></p>");
			}
		}catch (Exception e){
			out.println("<p><strong>Not Successfully insert data into database</strong></p>");
			out.println("<p><strong>Error: " + e.getMessage() + "</strong></p>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}

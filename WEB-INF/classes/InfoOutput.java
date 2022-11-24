//4. Make a form to input the details of students like regno, first name, last name, phone, education and email and, 
//display all the input values from Servlet by using Enumeration class.

package studentInfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import mysql.*;

@WebServlet("/output")
public class InfoOutput extends HttpServlet {
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
		String email;
		String education;
		ResultSet rs;
		String query = null;

		regNo = request.getParameter("registerNo");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		// out.println("<p>RegNo :'"+ regNo + "'</p>");                // debug
		// out.println("<p>First Name :'" + firstName + "'</p>");
		// out.println("<p>Last name :'"+ lastName + "'</p>");

		if((regNo == "") && (firstName == "" || lastName== "")){
			// if(firstName == "" || lastName== ""){
				query = null;
			// out.println("<p>XXXXXXXXXXXXX</p>"); debug
			// }
		}else if(regNo != ""){
			if(firstName != "" && lastName != ""){
				query = "SELECT * FROM studentInfo WHERE regno = '" + regNo + "' and firstname= '" + firstName + "' and lastname='" + lastName + "';";
			}else{
				query = "SELECT * FROM studentInfo WHERE regno =" + "'" + regNo + "';";
			}
			// out.println("<h3>Your Query is: " + query + "</h3>");    //debug
		}else {
			query = "SELECT * FROM studentInfo WHERE firstname=" + "'" + firstName + "' and lastname=" + "'" + lastName + "';";
			// out.println("<h3>Your Query is: " + query + "</h3>");   //debug
		}
		// out.println("<h1>" + query + "</h1>");    //debug

		if(query != null){
			try{
				rs = ConnectMysql.selectFrom(query);
				// DBPrinter.printResultSet(rs);
				// System.out.println(rs.next());
				if(rs.next()){
					rs.previous();
					 while(rs.next()){
						regNo = rs.getString(1);
						firstName = rs.getString(2);
						lastName = rs.getString(3);
						phone = rs.getString(4);
						education = rs.getString(5);
						email = rs.getString(6);
						out.println("<h2>Thank you for your query, This is Student Info:</h2>");
						out.println("<p><b>Register No</b> : " + regNo+ "</p>");
						out.println("<p><b>First Name</b> : " + firstName+ "</p>");
						out.println("<p><b>Last Name</b> : " + lastName+ "</p>");
						out.println("<p><b>Telephone Number</b> : " + phone + "</p>");
						out.println("<p><b>Education</b> : " + education + "</p>");
						out.println("<p><b>Email</b> : " + email + "</p>");		
					 }
				}else {
					out.println("<h2>Don't match any student Info</h2>");							
					// out.println("<p>XXXXXXXXXXXXXXX</p>"); 
				}
			}catch(Exception e){
				out.println("<p><strong>Error SQL:" + e.getMessage() + "</strong></p>");
				e.printStackTrace();
			}	
		}else {
			out.println("<p><strong>Error input: Please input again</strong></p>");
		}
		out.println("</body></html>");
	}

}

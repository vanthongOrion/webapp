package exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import mysql.*;

@WebServlet("/ex5")
public class Ex5 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Exercise 5</title></head>");
		out.println("<body>");

		//use parameterValues method to get values from request

		String empno, name, designation, phone;

		empno = request.getParameter("empno");
		name = request.getParameter("name");
		designation = request.getParameter("designation");
		phone = request.getParameter("phone");

		int count;
		count = ConnectMysql.insertInto(empno,name,designation,phone);

		if(count == -1 ){
			out.println("<h2><strong>Not Successfully insert into table. Check SQL Exception</strong></h2>");
		}else {
			out.println("<h2>Successfully insert <strong>" + count + "</strong> record");
		}

		out.println("</body></html>");
	}
}



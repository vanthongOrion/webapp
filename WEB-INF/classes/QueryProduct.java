package queryproduct;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import mysql.*;

@WebServlet("/queryproduct")
public class QueryProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>QueryProduct</title>");
		out.println("<style>form div{padding: 12px;border-bottom: 1px dashed #bec2c7;}");
		out.println("input[type='submit'] {margin: 20px;width: 7em;}</style>");
		out.println("</head>");
		out.println("<body>");

		//use get method to search product
		out.println("<h2>Input your info to Search</h2>");
		out.println("<form method='get' action='/project1/queryproductprocess'>");

		out.println("<div><label for='productid'>Product ID:</label><br>");
		out.println("<input type='text' id='productid' name='productid' value=''><br></div>");	

		out.println("<input type='submit' name='submit' value='Search'></form>");

		//use post method to update info into database
		out.println("<h2>Input your info to Update</h2>");
		out.println("<form method='post' action='/project1/queryproductprocess'>");

		out.println("<div><label for='productid'>Product ID:</label><br>");
		out.println("<input type='text' id='productid' name='productid' value=''><br></div>");

		out.println("<div><label for='productname'>Product Name:</label><br>");
		out.println("<input type='text' id='productname' name='productname' value=''><br></div>");		

		out.println("<div><label for='price'>Price:</label><br>");
		out.println("<input type='text' id='price' name='price' value=''><br></div>");

		out.println("<input type='reset' name='reset' value='Reset'>");
		out.println("<input type='submit' name='submit' value='Update'></form>");

		out.println("</body></html>");
	}
}
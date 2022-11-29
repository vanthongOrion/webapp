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

@WebServlet("/queryproductprocess")
public class QueryProductProcess extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>QueryProductResult</title>");
		out.println("<style>form div{padding: 12px;border-bottom: 1px dashed #bec2c7;}");
		out.println("table,th,td {border:1px solid black}");
		out.println("input[type='submit'] {margin: 20px;width: 7em;}</style>");
		out.println("</head>");
		out.println("<body>");

		//use get method to search product
		int count = 0;
		ResultSet rs;
		String query, productid;

		productid = request.getParameter("productid");
		query = "SELECT * FROM product where productid='" + productid + "'";
		try{
			rs = ConnectMysql.selectFrom(query);
			if(rs.next()){
				rs.previous();
				while(rs.next()){
					String name, id;
					int price;
					name = rs.getString("productname");
					id = rs.getString("productid");
					price = rs.getInt("price");
					out.println("<h2>Thank you for your Query</h2>");
					out.println("<h2>Your Query of Result is :</h2>");
					out.println("<table><tr>");
					out.println("<th>Product ID</th>");
					out.println("<th>Product Name</th>");
					out.println("<th>Price</th>");
					out.println("</tr><tr>");
					out.println("<td>" + id + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + price + "</td>");
					out.println("</tr></table>");	
					count ++;
				}
				out.println("<strong>"+ count + " orders have done</strong>");				
			} else {
				out.println("<h2>Don't match any product</h2>");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String productid,productname;
		int price, count;
		productid = request.getParameter("productid");
		productname = request.getParameter("productname");
		price = Integer.parseInt(request.getParameter("price"));

		try{
			count = ConnectMysql.insertInto(productid,productname,price);
			out.println("Successfully inserted, " + count + "affect0" );
		}catch (Exception e) {
			out.println("<h2>Error: " + e.getMessage() + "</h2>");
		}
		out.println("</body></html>");

	}
}
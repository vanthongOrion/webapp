package querybook;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import mysql.*;

@WebServlet("/query")
public class QueryBook extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	,ServletException{
		//Set content type
		response.setContentType("text/html");

		//Allocate printwriter value
		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html><head>");
		out.println("<title>QueryBook</title></head>");
		out.println("<body>");

		String query = "select * from books where author=";
		int id;
		String title;
		String author;
		double price;
		int qty;
		int count = 0;
		try{
			String[] par = request.getParameterValues("author");
			out.println("<h2>Thank you for query</h2>");
			query += "'" + par[0] + "'" + "or author=" + "'" + par[1] + "'" 
			 + " and qty >0 order by price desc";
			out.println("<p>Your query is " + query + "</p>");
			ResultSet rs;
			rs = ConnectMysql.executeQuery(query); 

			while(rs.next()){
				id = rs.getInt("id");
				title = rs.getString("title");
				author = rs.getString("author");
				price = rs.getDouble("price"); 
				out.println("<p>[id=" + id + ",title=" + title + ",author=" + author + ",price=" + price + "]</p>");
				count += 1;
			}

			out.println("<h3>Have done " + count + " orders for you</h3>");
			rs.close();
		}catch(Exception e){
			out.println("<b>Error: " + e.getMessage() + "</b>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
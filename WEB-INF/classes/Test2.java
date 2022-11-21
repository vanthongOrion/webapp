package servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import mysql.*;

@WebServlet("/hellopage")
public class Test2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	IOException,ServletException{
		//Set contentType with text/html
		response.setContentType("text/html");
		//Allocate printwriter 
		PrintWriter out = response.getWriter();

		//print out html
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<title>QueryPage</title></head>");
		out.println("<body>");

		//use ResultSet to print your result
		try{	
			String query = "SELECT * FROM prefs";

			ResultSet rs;
			rs = ConnectMysql.executeQuery(query);

			out.println("<h3>Thanks you for Query</h3>");
			while(rs.next()){
				String code = rs.getString("Code");
				String region = rs.getString("Region");
				String prefName = rs.getString("PrefName");
				String prefCapital = rs.getString("PrefCapital");
				out.println("<p>[Code=" + code + ",Region=" + region + ",PrefName=" + prefName + ",PrefCapital=" + prefCapital
					 + "]</p><br>" );
			}
			rs.close();

		} catch(Exception e){
			out.println("<p>Error" + e.getMessage() + "</p>");
			e.printStackTrace();
		}
		out.println("</body></html>");

	}
}
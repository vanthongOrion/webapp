import java.io.*;
import jakarta.servlet.*;				//tomcat10
import jakarta.servlet.http.*;			//tomcat10
import jakarta.servlet.annotation.*;	//tomcat10
//import javax.servlet.*;				//tomcat9
//import javax.servlet.http.*;			//tomcat9
//import javax.servlet.annotation.*;	//tomcat9

@WebServlet("/hello")
public class ConnectServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Set the response MIME type of the response message
		response.setContentType("text/html");
		//Allocate a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();

		//Write the reponse message, in an HTML page
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Hello, World</title></head>");
		out.println("<body>");
		out.println("<h1>Hello, World!</h1>");

		//echo clients's request information
		out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
		out.println("<p>Protocol: " + request.getProtocol() + "</p>");
		out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
		out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

		//Generate a random number upon each request
		out.println("<p>A random Number: <strong> " + Math.random() + "</strong></p>");
		out.println("</body></html>");
		out.close();
	}
}


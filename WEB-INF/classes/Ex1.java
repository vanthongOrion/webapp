import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;


@WebServlet("/test")
public class Ex1 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws 
	IOException,ServletException {
		//set response type
		response.setContentType("text/html");
		//allocate a output writer
		PrintWriter out = response.getWriter();

		out.println("<!doctype HTML>");
		out.println("<html><head>");
		out.println("<title>Example1</title></head>");
		out.println("<body>");
		for(int i=0;i<10;i++){
			out.println("<h2>Van Thong " + (i+1) + "</h2><br>");
		}
		out.println("</body></html>");
		out.close();
	}
}


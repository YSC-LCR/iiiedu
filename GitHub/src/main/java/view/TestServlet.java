package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		PrintWriter out = response.getWriter();
		for(Enumeration<String> names = request.getHeaderNames();names.hasMoreElements();){
			String name = names.nextElement();
			out.println("<h3>"+name);
			for(Enumeration<String> values = request.getHeaderNames();values.hasMoreElements();){
				String value = values.nextElement();
				out.println(value+",");
			}
			out.println("</h3>");
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

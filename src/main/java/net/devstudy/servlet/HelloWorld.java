package net.devstudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello-world")
public class HelloWorld extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//String attr1 = (String) req.getAttribute("attr1");
		
		/*String attr1 = (String)req.getSession().getAttribute("attr1");
		req.getSession().removeAttribute("attr1");*/
		
		String attr1 = req.getParameter("attr1");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Hello world"+attr1);
		// out.close();
	}
}

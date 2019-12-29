package net.devstudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv2")
public class Servlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		// do not call out.close inside hello-world!!!
		req.setAttribute("attr1", "serv1");
		req.getRequestDispatcher("/hello-world").include(req, resp);
		out.println("!!!");
		out.println("</body></html>");
		out.close();
	}
}

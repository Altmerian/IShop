package net.devstudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test-req-resp")
public class TestRequestResponseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setDateHeader("Date", System.currentTimeMillis());
		resp.addHeader("autor", "devstudy.net");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setLocale(Locale.ITALIAN);
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<form action='/test-req-resp' method='post'>");
		out.println("Your name: <input name='name'><br>");
		out.println("<input type='submit'>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(" Request method: " + req.getMethod());
		out.println("<br>Request URI: " + req.getRequestURI());
		out.println("<br>Protocol Version: " + req.getProtocol());
		out.println("<br>Header 'User-Agent': " + req.getHeader("User-Agent"));
		out.println("<br>Header 'Accept-Language': " + req.getLocale());
		out.println("<br>Header 'Content-Length': " + req.getContentLength());
		out.println("<br>Header 'Content-Type': " + req.getContentType());
		out.println("<br>Remote address: " + req.getRemoteHost());
		out.println("<br>Request parameter: " + req.getParameter("name"));
		out.close();
	}
}

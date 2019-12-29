package net.devstudy.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv3")
public class Servlet3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().setAttribute("attr1", "serv3");
		resp.sendRedirect("/hello-world?attr1=serv3");
	}
}

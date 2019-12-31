package net.devstudy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebServlet("/trim")
public class TrimServletTest extends HttpServlet {

	private static final long serialVersionUID = 5246864230917731916L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("original.jsp").forward(req, resp);
	}
}

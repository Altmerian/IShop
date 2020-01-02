package net.devstudy.ishop.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public final class RoutingUtils {
	
	public static void forwardToFragment(String jspFragment, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspFragment).forward(req, resp);
	}

	public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPage", "page/" + jspPage);
		req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
	}

	public static void sendHTMLFragment(String text, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println(text);
		resp.getWriter().close();
	}

	public static void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(url);
	}
}

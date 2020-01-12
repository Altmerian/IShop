package net.devstudy.ishop.servlet.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.ishop.servlet.AbstractController;
import net.devstudy.ishop.util.RoutingUtils;

/**
 * 
 * @author devstudy
 * {@see http://devstudy.net}
 */
@WebServlet("/shopping-cart")
public class ShowShoppingCartController extends AbstractController {
	private static final long serialVersionUID = -1916373553298888514L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("shopping-cart.jsp", req, resp);
	}
}

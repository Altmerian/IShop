package net.devstudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.model.ShoppingCart;
import net.devstudy.util.SessionUtils;

/**
 * 
 * @author devstudy
 * {@see http://devstudy.net}
 */
@WebFilter("/*")
public class AutoRestoreShoppingCartFilter implements Filter {
	private static final String SHOPPING_CARD_DESERIALIZATION_DONE = "SHOPPING_CARD_DESERIALIZATION_DONE";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute(SHOPPING_CARD_DESERIALIZATION_DONE) == null){
			if(!SessionUtils.isCurrentShoppingCartCreated(req)) {
				Cookie cookie = SessionUtils.findShoppingCartCookie(req);
				if(cookie != null) {
					ShoppingCart shoppingCart = shoppingCartFromString(cookie.getValue());
					SessionUtils.setCurrentShoppingCart(req, shoppingCart);
				}
			}
			req.getSession().setAttribute(SHOPPING_CARD_DESERIALIZATION_DONE, Boolean.TRUE);
		}
		
		chain.doFilter(req, resp);
	}

	protected ShoppingCart shoppingCartFromString(String cookieValue) {
		ShoppingCart shoppingCart = new ShoppingCart();
		String[] items = cookieValue.split("\\|");
		for (String item : items) {
			String data[] = item.split("-");
			try {
				int idProduct = Integer.parseInt(data[0]);
				int count = Integer.parseInt(data[1]);
				shoppingCart.addProduct(idProduct, count);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return shoppingCart;
	}
	
	@Override
	public void destroy() {
	}
}

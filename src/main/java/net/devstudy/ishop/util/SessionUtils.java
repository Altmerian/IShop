package net.devstudy.ishop.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.ishop.Constants;
import net.devstudy.ishop.model.ShoppingCart;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SessionUtils {
	public static ShoppingCart getCurrentShoppingCart(HttpServletRequest req) {
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			setCurrentShoppingCart(req, shoppingCart);
		}
		return shoppingCart;
	}

	public static boolean isCurrentShoppingCartCreated(HttpServletRequest req) {
		return req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART) != null;
	}

	public static void setCurrentShoppingCart(HttpServletRequest req, ShoppingCart shoppingCart) {
		req.getSession().setAttribute(Constants.CURRENT_SHOPPING_CART, shoppingCart);
	}

	public static void clearCurrentShoppingCart(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute(Constants.CURRENT_SHOPPING_CART);
		WebUtils.setCookie(Constants.Cookie.SHOPPING_CART.getName(), null, 0, resp);
	}

	public static Cookie findShoppingCartCookie(HttpServletRequest req) {
		return WebUtils.findCookie(req, Constants.Cookie.SHOPPING_CART.getName());
	}

	public static void updateCurrentShoppingCartCookie(String cookieValue, HttpServletResponse resp) {
		WebUtils.setCookie(Constants.Cookie.SHOPPING_CART.getName(), cookieValue,
				Constants.Cookie.SHOPPING_CART.getTtl(), resp);
	}

	private SessionUtils() {
	}
}

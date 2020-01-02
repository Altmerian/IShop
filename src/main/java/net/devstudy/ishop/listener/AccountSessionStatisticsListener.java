package net.devstudy.ishop.listener;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.devstudy.ishop.Constants;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebListener
@SuppressWarnings("unchecked")
public class AccountSessionStatisticsListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		List<String> actions = (List<String>) se.getSession().getAttribute(Constants.ACCOUNT_ACTIONS_HISTORY);
		if (actions != null) {
			logCurrentActionHistory(se.getSession().getId(), actions);
		}
	}

	private void logCurrentActionHistory(String sessionId, List<String> actions) {
		System.out.println(sessionId + " ->\n\t" + String.join("\n\t", actions));
	}
}

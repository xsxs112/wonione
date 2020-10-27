package cafe24.wio;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	    se.getSession().setMaxInactiveInterval(60*60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}
	
}

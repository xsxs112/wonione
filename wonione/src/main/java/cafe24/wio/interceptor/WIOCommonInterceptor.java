package cafe24.wio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WIOCommonInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(WIOCommonInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// controller 진행 전
		log.info("=================CommonInterceptor========================START");
		log.info("=================ACCESS INFO==============================START");
		log.info("Port :::: {} ", request.getLocalPort());
		log.info("serverName :::: {} ", request.getServerName());
		log.info("mrId ::::{}",(String)request.getSession().getAttribute("SID"));
		log.info("getMethod :::: {} ", request.getMethod());
		log.info("getRequestURI :::: {} ", request.getRequestURI());
		log.info("=================ACCESS INFO==============================END");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// controller 진행 후
		log.info("CommonInterceptor=================END");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}

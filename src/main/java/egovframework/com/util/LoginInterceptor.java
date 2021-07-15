package egovframework.com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class LoginInterceptor extends WebContentInterceptor {

	static Logger logger = Logger.getLogger(LoginInterceptor.class);


	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	         // Controller 및 View(jsp) 까지 모두 호출 된 후에 수행 됩니다.
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// Controller가 호출 되어 수행되고, View(jsp) 호출되기전에 수행 됩니다.
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) {
			System.out.println("인터셉터 확인");
		try {
		   //제일 많이 쓰이며, Controller 가 수행되기전에 수행 됩니다.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}

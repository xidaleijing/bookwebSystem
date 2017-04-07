package com.bookwebsystem.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;  

public class LoginInterceptor implements HandlerInterceptor  {

    private final String ADMINSESSION = "usersession";  
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		 Object sessionObj = arg0.getSession().getAttribute(ADMINSESSION);  
		    if(sessionObj!=null) {   
		      return true;  
		    }   
		    arg1.sendRedirect(arg0.getContextPath()+"/login");  
		    return false;  
	}

}

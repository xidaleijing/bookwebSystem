package com.bookwebsystem.web.controller;



import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookwebsystem.service.UserService;

@Controller
public class indexController extends LoginInterceptor {

	private static final Logger LOGGER = Logger.getLogger(indexController.class); 
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView view=new ModelAndView();
		view.setViewName("index");
		view.addObject("message", "Hello World");
		return view;
	}
}

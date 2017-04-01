package com.bookwebsystem.web.controller;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

	private static final Logger LOGGER = Logger.getLogger(indexController.class); 
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView view=new ModelAndView();
		view.setViewName("index");
		view.addObject("message", "Hello World");
		return view;
	}
}

package com.bookwebsystem.web.controller;

import java.io.Reader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookwebsystem.service.UserService;
import com.bookwebsystem.vo.UserVo;

@Controller
public class signinController extends LoginInterceptor {

	@Resource
	private UserService userService;
	
	@RequestMapping("/signin")
	public String signin(){
		return "signin";
	}
	
	@RequestMapping(value="/signin",method={RequestMethod.POST})
	public String signin(HttpServletRequest request,HttpServletResponse response,UserVo user){
		try {
			userService.addUser(user);
			return "redirect:login";
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			return "signin";
		}
		
	}
}

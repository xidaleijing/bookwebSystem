package com.bookwebsystem.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookwebsystem.dao.UserDao;
import com.bookwebsystem.helper.CookieUtil;
import com.bookwebsystem.helper.EncryptionUtil;
import com.bookwebsystem.model.User;
import com.bookwebsystem.service.UserService;

@Controller
public class loginController extends LoginInterceptor {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public String login(HttpServletRequest request,HttpServletResponse response,String userName,String passWord,ModelMap modelMap){
		User user=userService.getUserByUserName(userName);
		if(user!=null){
			if(!user.getPassWord().equals(passWord))
			{
				modelMap.addAttribute("message", "密码错误");
				return "/login";
			}else{
				HttpSession session =request.getSession();  
				session.setAttribute("usersession",userName);
				CookieUtil.addCookie(response, new Cookie("userName", userName));
				CookieUtil.addCookie(response, new Cookie("password", EncryptionUtil.md5Hex(passWord)));
				return "redirect:index";
			}
		}else{
			modelMap.addAttribute("message", "用户不存在，请注册");
			return "/login";
		}
	}
	
	@RequestMapping("/login")
	public String login(){
		return "/login";
	}
}

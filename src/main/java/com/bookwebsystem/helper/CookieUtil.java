package com.bookwebsystem.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 添加一个新的cookie
	 * @param response
	 * @param cookie
	 */
	public static void addCookie(HttpServletResponse response,Cookie cookie){
		if(cookie!=null){
			response.addCookie(cookie);
		}
			
	}
	
	/**
	 * 添加cookie
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param domain
	 * @param path
	 * @param secure
	 */
	public static void addCookie(HttpServletResponse response,String cookieName,String cookieValue,String domain,String path,Boolean secure){
		if(cookieName!=null&&!cookieName.equals("")){
			if(cookieValue==null)
				cookieValue="";
			Cookie cookie=new Cookie(cookieName, cookieValue);
			if(domain!=null)
				cookie.setDomain(domain);
			if(path==null)
				cookie.setPath("/");
			else
				cookie.setPath(path);
			cookie.setSecure(secure);
			addCookie(response, cookie);
		}
	}
	
	/**
	 * 添加cookie
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param domain
	 */
	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain) {
		addCookie(response, cookieName, cookieValue, domain, "/", false);
	}
	
	/**
	 * 添加cookie
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 */
	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
		addCookie(response, cookieName, cookieValue, null, "/", false);
	}
	
	/**
	 * 获得cookie
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request,String cookieName){
		Cookie[] cookies = request.getCookies();

		if (cookies == null || cookieName == null || cookieName.equals(""))
			return null;

		for (Cookie c : cookies) {
			if (c.getName().equals(cookieName))
				return (Cookie) c;
		}
		return null;
	}
	
	/**
	 * 获得cookie的值
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie cookie = getCookie(request, cookieName);
		if (cookie == null)
			return null;
		else
			return cookie.getValue();
	}
	
	/**
	 * 删除cookie
	 * @param response
	 * @param cookie
	 */
	public static void delCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setPath("/"); 
			cookie.setMaxAge(0);
			cookie.setValue(null);
			response.addCookie(cookie);
		}
	}
	
	/**
	 * 删除cookie
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void delCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie c = getCookie(request, cookieName);
		if (c != null && c.getName().equals(cookieName)) {
			delCookie(response, c);
		}
	}
	
	/**
	 * 修改cookie
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param domain
	 */
	public static void editCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
			String cookieValue,String domain) {
		Cookie c = getCookie(request, cookieName);
		if (c != null && cookieName != null && !cookieName.equals("") && c.getName().equals(cookieName)) {
			addCookie(response, cookieName, cookieValue, domain);
		}
	}

}

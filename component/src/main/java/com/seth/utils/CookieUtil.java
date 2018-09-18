package com.seth.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  SethMessenger
 * @desc    cookie操作工具
 */
public class CookieUtil {
	
    /**
     * 新增默认路径"/"下的cookie
     * @param response
     * @param cookieName
     * @param value
     * @param maxAge
     * @param domain
     * @return
     */
	public static Cookie addCookie(HttpServletResponse response, String cookieName, String value, Integer maxAge, String domain) {
        return addCookie(response, cookieName, value, maxAge, domain, "/");
    }

    /**
     * 新增cookie
     * @param response
     * @param cookieName
     * @param value
     * @param maxAge
     * @param domain
     * @param path
     * @return
     */
	public static Cookie addCookie(HttpServletResponse response, String cookieName, String value, Integer maxAge, String domain, String path) {
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath(path);
        response.addCookie(cookie);
        return cookie;  
    }

    /**
     * 获取 cookie
      * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {  
            for (Cookie cookie : cookies) {
                if (cookieName.equalsIgnoreCase(cookie.getName())) {  
                    return cookie.getValue();  
                }  
            }  
        }  
        return null;
    }

    /**
     * 删除 cookie
      * @param response
     * @param cookieName
     */
    public static void delCookie(HttpServletResponse response, String cookieName) {
    	Cookie cookie = new Cookie(cookieName,null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}


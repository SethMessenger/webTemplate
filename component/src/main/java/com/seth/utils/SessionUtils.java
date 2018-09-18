package com.seth.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 	SethMessenger
 * @desc	Cookie 工具类
 */
public final class SessionUtils {
	
	/**
	  * 设置session的值
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static void setAttr(HttpServletRequest request, String key, Object value){
		 request.getSession(true).setAttribute(key, value);
	 }
	 
	 
	 /**
	  * 获取session的值
	  * @param request
	  * @param key
	  */
	 public static Object getAttr(HttpServletRequest request, String key){
		 return request.getSession(true).getAttribute(key);
	 }
	 
	 /**
	  * 删除Session值
	  * @param request
	  * @param key
	  */
	 public static void removeAttr(HttpServletRequest request, String key){
		 request.getSession(true).removeAttribute(key);
	 }
	 
}
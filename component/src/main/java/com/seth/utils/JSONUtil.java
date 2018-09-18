package com.seth.utils;

import com.alibaba.fastjson.*;
import org.apache.commons.lang.StringUtils;

public class JSONUtil {

	/**
	 * 判断当前字符串是否为json格式
	 * @param str
	 * @return
	 */
	public static boolean isJson(String str){
		if(StringUtils.isNotEmpty(str)){
			try {
				JSONObject.parseObject(str);
			} catch (JSONException ex) {
				try {
					JSONObject.parseArray(str);
				} catch (JSONException ex1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 可以将任何key-vlaue格式的对象转成json格式<br/>
	 * </p>
	 *
	 * @param obj 需要转成json格式的任何对象
	 * @return
	 */
	public static String objectToJson(Object obj) {
		String json = "";
		json = JSONObject.toJSONString(obj);
		return json;
	}

	/**
	 * <p>
	 * 将一个JSON的字符串转成指定的对象
	 * </p>
	 * <p>
	 * List<HotelSimpleFilterInfoEntity> list = JSON.parseObject(text, new TypeReference<List<HotelSimpleFilterInfoEntity>>(){});
	 * </p>
	 *
	 * @param type 需要转成的对象的类型
	 * @param json 被转换的字符串
	 * @return
	 * @throws IllegalAccessException
	 * @throws
	 * @ref T-00027
	 */
	public static <T> T jsonToObject(TypeReference<T> type, String json) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		T t = null;
		try {
			t = JSON.parseObject(json, type);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ClassCastException(e1.getMessage()+"####"+"TypeReference Function:####"+json);
		}
		return t;
	}

	/**
	 * 将指定的字符串转成数组
	 *
	 * @param json 需要转成数组的json格式字符串
	 * @param t 数组的类型
	 * @return 返回指定类型的数组
	 */
	public static <T> T[] jsonToArray(String json, T[] t) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		JSONArray arr = JSONObject.parseArray(json);
		T[] rt = arr.toArray(t);
		return rt;
	}

	public static Object[] jsonToArray(String json) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		JSONArray arr = JSONObject.parseArray(json);
		return arr.toArray();
	}

}

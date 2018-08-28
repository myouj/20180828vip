package com.ma.common;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/** 
 * @ClassName: AssertThrowUtil 
 * @Description: TODO
 * @author: youj
 * @date: 2018年8月20日 下午7:51:26  
 */
public class AssertThrowUtil {

	/**
	 * @param message
	 * @param target
	 * TODO:不为空白
	 */
	public static void assertNotBlank(String message, String target) {
		if (target == null || (target = target.trim()).length() == 0) {
			throw new ThisSystemException(message);
		}
	}

	public static void $(String message, String target) {
		assertNotBlank(message, target);
	}

	
	/**
	 * @param message
	 * @param o 
	 * TODO:不为空
	 */
	public static void assertNotNull(String message, Object o) {
		if (o == null) {
			throw new ThisSystemException(message);
		}

	}

	/**
	 * @param message
	 * @param o 
	 * TODO:为空
	 */
	public static void assertNull(String message, Object o) {
		if (o != null) {
			throw new ThisSystemException(message);
		}

	}

	
	/**
	 * @param message
	 * @param a
	 * @param b 
	 * TODO:相等
	 */
	public static void assertEquals(String message, Object a, Object b) {
		if (a == null ? a != b : !a.equals(b)) {
			throw new ThisSystemException(message);
		}
	}

	/**
	 * @param message
	 * @param a
	 * @param b 
	 * TODO:不相等
	 */
	public static void assertNotEquals(String message, Object a, Object b) {
		if (a == null ? a == b : a.equals(b)) {
			throw new ThisSystemException(message);
		}
	}

	
	/**
	 * @param message
	 * @param b 
	 * TODO:为true
	 */
	public static void assertTrue(String message, boolean b) {
		if (!b) {
			throw new ThisSystemException(message);
		}
	}

	/**
	 * @param message
	 * @param b 
	 * TODO:为false
	 */
	public static void assertFalse(String message, boolean b) {
		if (b) {
			throw new ThisSystemException(message);
		}
	}
	
	/**
	 * @param message
	 * @param reg
	 * @param target 
	 * TODO:正则表达式验证
	 */
	public static void assertMatchPattern(String message,String reg, String target){
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(target);
		if(!matcher.matches()){
			throw new ThisSystemException(message);
		}
	}
	
	/**
	 * @param message
	 * @param list 
	 * TODO:list不为空
	 */
	@SuppressWarnings("rawtypes")
	public static void assertListNotNull(String message, List list){
		if(list.size() == 0){
			throw new ThisSystemException(message);
		}
	}

}

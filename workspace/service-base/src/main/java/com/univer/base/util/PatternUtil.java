package com.univer.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guwei
 */
public class PatternUtil {

	private static final Pattern USERNAME = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*$");
	private static final Pattern EMAIL = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
	private static final Pattern PHONE = Pattern.compile("[0-9]{11}");

	/**
	 * 用户名校验
	 */
	public static boolean matchUsername(String userName) {
		boolean flag = false;
		if (userName != null) {
			Matcher m = USERNAME.matcher(userName);
			if (m.matches()) {
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * email校验
	 */
	public static boolean matchEmail(String email) {
		boolean flag = false;
		if (email != null) {
			Matcher m = EMAIL.matcher(email);
			if (m.matches()) {
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 手机号校验
	 */
	public static boolean matchPhone(String phone) {
		boolean flag = false;
		if (phone != null) {
			Matcher m = PHONE.matcher(phone);
			if (m.matches()) {
				flag = true;
			}
		}
		return flag;
	}
	
}

package com.zwsec.service.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonUtils {

	@SuppressWarnings("rawtypes")
	public static Object getValue(Object data, String field) {
		if (data instanceof Map) {
			Map map = (Map) data;
			return map.get(field);
		}
		try {
			String method = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
			Method m = data.getClass().getMethod(method, null);
			if (m != null) {
				return m.invoke(data, null);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isNumber(Object v) {
		if (v == null)
			return false;
		if (v instanceof Number) {
			return true;
		} else if (v.toString().matches("^\\d+$")) {
			return true;
		} else if (v.toString().matches("^-?\\d+\\.?\\d+$")) {
			return true;
		} else {
			try {
				Double.parseDouble(v.toString());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * ���� #{} ���� ${} �а�����ֵ
	 * 
	 * @param str
	 * @param type
	 * @return eg:#{name} ${ages}
	 */
	public static String[] getWildcard(String str) {
		List<String> list = new ArrayList<String>();
		int start = 0;
		while (start < str.length() && start >= 0) {
			start = str.indexOf("{", start);
			int end = str.indexOf("}", start);
			if (start > 0) {
				String wc = str.substring(start - 1, end + 1);
				list.add(wc);
			}
			if (start < 0)
				break;
			start = end + 1;
		}
		return list.toArray(new String[0]);
	}
}

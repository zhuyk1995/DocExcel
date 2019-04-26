package com.zwsec.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zwsec.service.util.DocUtil;
/**
 * �������
 * @author ZHUYK
 *
 */
public class DocServiceImpl {

	static DocUtil docUtil = new DocUtil();

	public static void test() throws IOException {

		List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i < 9; i++) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("rowNum", i);
			dataMap.put("fullName", "��" + i + "������fullName");
			dataMap.put("shortName", "��" + i + "������shortName");
			dataMap.put("line", "��" + i + "������line");
			dataMapList.add(dataMap);
		}
		System.out.println(docUtil.createDocArea(dataMapList, "D:\\jira\\attach", "jira"));
	}
	
	public static void main(String[] args) throws IOException {
		test();
	}
}

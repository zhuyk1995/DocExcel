package com.zwsec.controller;

import java.io.File;

/**
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��7�� ����5:30:51
*/
public class ReadExcelPath {

	
	public static void main(String[] arge) {
		//String path = ReadExcelPath.class.getClassLoader().getResource("/model/jira.xls").getPath();
		String srcPath = "/DocCreate/src/main/resources/model/jira.xls";
		File file = new File(srcPath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
		System.out.println(file.exists());
	}
}

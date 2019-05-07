package com.zwsec.twoexcel.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��7�� ����6:34:26
*/
public class DataListRlt implements Serializable{
	
	private static final long serialVersionUID = 6639126963154537711L;
	
	private String queryVersionName;
	
	private String queryVersionNum;
	
	private List<Map<String, Object>> datas;

	public String getQueryVersionName() {
		return queryVersionName;
	}

	public void setQueryVersionName(String queryVersionName) {
		this.queryVersionName = queryVersionName;
	}

	public String getQueryVersionNum() {
		return queryVersionNum;
	}

	public void setQueryVersionNum(String queryVersionNum) {
		this.queryVersionNum = queryVersionNum;
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}
	
	
}

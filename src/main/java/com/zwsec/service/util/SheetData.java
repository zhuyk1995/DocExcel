package com.zwsec.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * sheetҳ���ݶ���
 * 
 * @author ZUOSHICHAO
 *
 */
public class SheetData {
	/**
	 * sheetҳ�д洢 #{key} ������
	 */
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * �б����ݴ洢 sheetҳ���滻${key} ������Ϊ��λ���¸�ֵ
	 */
	private List<Object> datas = new ArrayList<Object>();

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public SheetData(String name) {
		super();
		this.name = name;
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public void remove(String key) {
		map.remove(key);
	}

	public Object get(String key) {
		return map.get(key);
	}

	/**
	 * ����map�洢�����ݴ洢
	 */
	public void clear() {
		map.clear();
		datas.clear();
	}

	public void addData(Object t) {
		datas.add(t);
	}

	public void addDatas(List<? extends Object> list) {
		datas.addAll(list);
	}

	public List<Object> getDatas() {
		return datas;
	}

}

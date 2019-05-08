package com.zwsec.excel.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zwsec.excel.utils.ExcelUtils;
import com.zwsec.twoexcel.createdata.CreateDateEntity;
import com.zwsec.twoexcel.pojo.DatEntity;
import com.zwsec.twoexcel.response.DataListRlt;
import com.zwsec.twoexcel.response.DataListRltFalse;

public class ExportRExcell {

	public static void exportExcell(HttpServletRequest request, HttpServletResponse response) {

		ExcelUtils excelUtils = new ExcelUtils();

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		for (int i = 0; i < 2; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("preAmount", "2.0");
			map.put("plusAmount", "2.0");
			map.put("reduceAmount", "2.0");
			map.put("afterAmount", "2.0");
			map.put("accountsType", "66");
			data.add(map);
		}
		File file = new File("D:\\test.xlsx");
		if (!file.exists()) {
			try {
				file.createNewFile();
				OutputStream outputStream = new FileOutputStream(file);
				excelUtils.createExcel(data, outputStream, request);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// exportExcell(null, null);
		//List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		// ��������
		List<DatEntity> datEntities = new CreateDateEntity().createDate(6);
		// ����Map����
		DataListRlt dataListRlt = new DataListRlt();
		dataListRlt.setDatas(new ArrayList<Map<String, Object>>());
		dataListRlt.setQueryVersionName("com.zwsec.codeservice.impl");
		dataListRlt.setQueryVersionNum("INC2019050700012");
		// ����ʵ���༯��
		DataListRltFalse dataListRltFalse = new DataListRltFalse();
		dataListRltFalse.setDatas(new ArrayList<DatEntity>());
		dataListRltFalse.setQueryVersionName("com.zwsec.codeservice.implements");
		dataListRltFalse.setQueryVersionNum("INC2019050700013");
		// ��ʼ��ֵ
		for (int i = 0; i < datEntities.size(); i++) {
			// ��Ӧʵ����
			DatEntity datEntity = new DatEntity();
			// �� Map �д�ֵ
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rowNum", datEntities.get(i).getRowNum());
			map.put("fileName", datEntities.get(i).getFileName());
			map.put("line", datEntities.get(i).getLine());
			map.put("shortName", datEntities.get(i).getShortName());
			//mapList.add(map);
			// ��ʵ�����ֵ
			datEntity.setRowNum(datEntities.get(i).getRowNum());
			datEntity.setFileName(datEntities.get(i).getFileName());
			datEntity.setLine(datEntities.get(i).getLine());
			datEntity.setShortName(datEntities.get(i).getShortName());
			// ����Ӧ�������Ӧ��ֵ
			dataListRltFalse.getDatas().add(datEntity);
			dataListRlt.getDatas().add(map);
		}
		System.out.println(JSON.toJSON(dataListRlt));
		System.out.println(JSON.toJSON(dataListRltFalse));
	}
}

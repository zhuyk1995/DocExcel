package com.zwsec.twoexcel.test;

import java.util.List;

import com.zwsec.twoexcel.createdata.CreateDateEntity;
import com.zwsec.twoexcel.pojo.DatEntity;
import com.zwsec.twoexcel.util.ExcelUtil;
/**
 * ���ܜyԇ�
 * @author ZUOSHICHAO
 *
 */
public class TwoExcelMain {

	private static final String srcXlsPath = "D:\\jira.xls";
	private static final String desXlsPath = "D:\\jira\\attach\\test.xls";
	private static final String sheetName = "©����Ϣ�����";

	public static void main(String[] args) {
		CreateDateEntity createDateEntity = new CreateDateEntity();
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.setSrcXlsPath(srcXlsPath);
		excelUtil.setDesXlsPath(desXlsPath);
		excelUtil.setSheetName(sheetName);
		excelUtil.getSheet();
		List<DatEntity> datEntities = createDateEntity.createDate();
		DatEntity datEntityMin = datEntities.get(0);
		DatEntity datEntityMax = datEntities.get(datEntities.size() - 1);
		//��Сֵ��ֵ
		excelUtil.setCellStrValue(2, 0, String.valueOf(datEntityMin.getRowNum() + 1));
		excelUtil.setCellStrValue(2, 1, String.valueOf(datEntityMin.getFileName()));
		excelUtil.setCellStrValue(2, 2, String.valueOf(datEntityMin.getLine()));
		excelUtil.setCellStrValue(2, 3, String.valueOf(datEntityMin.getShortName()));
		//���ֵ��ֵ
		excelUtil.setCellStrValue(2, 4, String.valueOf(datEntityMax.getFileName()));
		excelUtil.setCellStrValue(2, 5, String.valueOf(datEntityMax.getLine()));
		excelUtil.setCellStrValue(2, 6, String.valueOf(datEntityMax.getShortName()));
		// ������
		excelUtil.exportToNewFile();
	}
}

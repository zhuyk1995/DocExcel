package com.zwsec.service.mian;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import com.zwsec.service.entity.DataEntiry;

public class ExportExcel {

	public static void main(String[] args) {
		MakeExcelTest makeExcelTest = new MakeExcelTest();
		String fileName = makeExcelTest.getFileName();

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("table");// ����table������

		Object[][] datas = { { "���", "��ʼ��", "��ֹ��" }, { "����", "�����۶�(��Ԫ)", "������(��Ԫ)�򵥵ı��" }, { "����ʡ", 9045, 2256 },
				{ "�㶫ʡ", 3000, 690 }, { "����ʡ", 6000, 9562312 } };

		// ������
		List<DataEntiry> dataEntiries = new ArrayList<DataEntiry>();
		DataEntiry dataEntiry = new DataEntiry("�����Ʒ�۶�", null, null);
		DataEntiry dataEntiry2 = new DataEntiry("����", "�����۶�(��Ԫ)", "������(��Ԫ)�򵥵ı��");
		DataEntiry dataEntiry3 = new DataEntiry("����ʡ", String.valueOf(9045), String.valueOf(2256));
		DataEntiry dataEntiry4 = new DataEntiry("�㶫ʡ", String.valueOf(3000), String.valueOf(690));
		DataEntiry dataEntiry5 = new DataEntiry("����ʡ", String.valueOf(60000), String.valueOf(895623));
		dataEntiries.add(dataEntiry5);
		dataEntiries.add(dataEntiry4);
		dataEntiries.add(dataEntiry3);
		dataEntiries.add(dataEntiry2);
		dataEntiries.add(dataEntiry);

		HSSFRow row;
		HSSFCell cell;

		short colorIndex = 10;

		HSSFPalette palette = wb.getCustomPalette();
		Color rgb = Color.GREEN;
		short bgIndex = colorIndex++;
		palette.setColorAtIndex(bgIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());
		short bdIndex = colorIndex++;
		rgb = Color.BLACK;
		palette.setColorAtIndex(bdIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());

		for (int i = 0; i < datas.length; i++) {
			row = sheet.createRow(i);// ���������
			for (int j = 0; j < datas[i].length; j++) {
				if (j == 3) {
					
				}
				cell = row.createCell(j);// ���ݱ���д�����Ԫ��
				cell.setCellValue(String.valueOf(datas[i][j]));

				HSSFCellStyle cellStyle = wb.createCellStyle();
				if (i == 0 || i == 1) {
					cellStyle.setFillForegroundColor(bgIndex);// bgIndex ������ɫ�±�ֵ
					cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				}
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				// bdIndex �߿���ɫ�±�ֵ
				cellStyle.setBottomBorderColor(bdIndex);
				cellStyle.setLeftBorderColor(bdIndex);
				cellStyle.setRightBorderColor(bdIndex);
				cellStyle.setTopBorderColor(bdIndex);

				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				if (i == datas.length - 1 && j == datas[0].length - 1) {
					HSSFFont font = wb.createFont();
					font.setItalic(true);
					font.setUnderline(HSSFFont.U_SINGLE);
					font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints((short) 14);
					cellStyle.setFont(font);
				}
				cell.setCellStyle(cellStyle);
			}
		}
		// �ϲ���Ԫ��
		CellRangeAddress region = new CellRangeAddress(0, // first row
				1, // last row
				0, // first column
				0 // last column
		);
		// �ϲ���Ԫ��
		CellRangeAddress region2 = new CellRangeAddress(0, // first row
				0, // last row
				1, // first column
				3 // last column
		);
		sheet.addMergedRegion(region);
		sheet.addMergedRegion(region2);
		// �������֮�������и����п�
		for (int i = 0; i < datas.length; i++) {
			row = sheet.getRow(i);
			row.setHeightInPoints(30);
		}
		try {
			File file = new File(MakeExcelTest.filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			wb.write(new FileOutputStream(MakeExcelTest.filePath + fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

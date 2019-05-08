package com.zwsec.twoexcel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 * �ڶ��γ���excel����ģ�嵼��
 * 
 * ����Ϊ������ɸ���ģ�嵼�� Excel���� ��һ�������� excel ģ���·�� �ڶ���������Ҫ���� excel �ļ�·��
 * ������������ģ�����Ǹ�Sheet�� ���Ĳ�����ȡ����ȡ excel ģ��Ķ��� ���岽���������ݣ���Ϊ���֣� ����������󵼳�
 * 
 * @author ZHUYK
 *
 */
public class ExcelUtil {
	// ģ��·��
	private String srcXlsPath = "";
	// �����ļ�·��
	private String desXlsPath = "";

	private String sheetName = "";

	POIFSFileSystem fs = null;

	HSSFWorkbook wb = null;

	HSSFSheet sheet = null;

	/**
	 * ��һ�������� excel ģ���·��
	 * 
	 * @param srcXlsPath
	 */
	public void setSrcXlsPath(String srcXlsPath) {
		this.srcXlsPath = srcXlsPath;
	}

	/**
	 * �ڶ���������Ҫ���� excel �ļ�·��
	 * 
	 * @param desXlsPath
	 */
	public void setDesXlsPath(String desXlsPath,String fileName) {
		File filePath = new File(desXlsPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		this.desXlsPath = desXlsPath + fileName + ".xls";
	}

	/**
	 * ������������ģ�����Ǹ�Sheet��
	 * 
	 * @param sheetName
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * ���Ĳ�����ȡ����ȡ excel ģ��Ķ���
	 */
	public void getSheet() {
		try {

			File fi = new File(srcXlsPath);
			if (!fi.exists()) {
				System.out.println("ģ���ļ�" + srcXlsPath + "������!");
				return;
			}
			fs = new POIFSFileSystem(new FileInputStream(fi));
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� �����ַ������͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- �ַ������͵���ֵ
	 */
	public void setCellStrValue(int rowIndex, int cellnum, String value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		System.out.println(rowIndex);
		cell.setCellValue(value);
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� ��������/ʱ�����͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- ����/ʱ�����͵���ֵ
	 */
	public void setCellDateValue(int rowIndex, int cellnum, Date value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� ���ø������͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- �������͵���ֵ
	 */
	public void setCellDoubleValue(int rowIndex, int cellnum, double value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� ����Bool���͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- Bool���͵���ֵ
	 */
	public void setCellBoolValue(int rowIndex, int cellnum, boolean value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� �����������͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- �������͵���ֵ
	 */
	public void setCellCalendarValue(int rowIndex, int cellnum, Calendar value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽���������ݣ���Ϊ���֣� ���ø��ı����͵�����
	 * 
	 * @param rowIndex-- ��ֵ
	 * @param cellnum-- ��ֵ
	 * @param value-- ���ı����͵���ֵ
	 */
	public void setCellRichTextStrValue(int rowIndex, int cellnum, RichTextString value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ����������󵼳� ��ɵ���
	 */
	public void exportToNewFile() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(desXlsPath);
			wb.write(out);
			out.close();
			System.out.println("�������");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

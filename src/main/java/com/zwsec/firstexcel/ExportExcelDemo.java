package com.zwsec.firstexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelDemo {

	private HSSFWorkbook workbook = null;

	/**
	 * ��ʾ��������ı���
	 */
	private String title;
	/**
	 * �����������
	 */
	private String[] rowName;

	private List<Object[]> dataList = new ArrayList<Object[]>();

	/**
	 * ���췽��������Ҫ����������
	 *
	 * @param title
	 * @param rowName
	 * @param dataList
	 */
	public ExportExcelDemo(String title, String[] rowName, List<Object[]> dataList) {
		this.title = title;
		this.rowName = rowName;
		this.dataList = dataList;
	}

	/**
	 * �ж��ļ���sheet�Ƿ����
	 * 
	 * @param filePath  �ļ�·��
	 * @param sheetName ���������
	 * @return
	 */
	public boolean sheetExist(String filePath, String sheetName) {
		boolean flag = false;
		File file = new File(filePath);
		if (file.exists()) { // �ļ�����
			// ����workbook
			try {
				workbook = new HSSFWorkbook(new FileInputStream(file)); // ���Worksheet�������sheetʱ���ɵ�xls�ļ���ʱ�ᱨ��)
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet != null)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// �ļ�������
			flag = false;
		}
		return flag;
	}

	/**
	 *
	 * (2003 xls��׺ ����)
	 * 
	 * @param TODO
	 * @return void ��������
	 * @author xsw
	 * @2016-12-7����10:44:00
	 */
	public static void createXLS(String importFilePath, String exportFilePath) throws IOException {
		try { // excelģ��·��
			File fi = new File(importFilePath);
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));// ��ȡexcelģ��
			HSSFWorkbook wb = new HSSFWorkbook(fs); // ��ȡ��ģ��������sheet����
			HSSFSheet sheet = wb.getSheetAt(0); // �������û���ˣ�������ʽ���������Զ������Ч����
			sheet.setForceFormulaRecalculation(true); // ����Ӧ�ĵ�Ԫ����и�ֵ
			HSSFCell cell = sheet.getRow(11).getCell(6);// ��11�� ��6��
			cell.setCellValue(1);
			HSSFCell cell2 = sheet.getRow(11).getCell(7);
			cell2.setCellValue(2);
			sheet.getRow(12).getCell(6).setCellValue(12);
			sheet.getRow(12).getCell(7).setCellValue(12); // �޸�ģ�����ݵ�����ģ��
			FileOutputStream out = new FileOutputStream(exportFilePath);
			wb.write(out);
			out.close();
		} catch (Exception e) {
			System.out.println("�ļ���ȡ����!");
		}
	}
	/**
    *
    *(2007 xlsx��׺ ����)
    * @param
    * @return void ��������
    * @author xsw
    * @2016-12-7����10:44:30
    */
	public static void createXLSX(String importFilePath, String exportFilePath) throws IOException {
		// excelģ��·��
		File fi = new File(importFilePath);
		InputStream in = new FileInputStream(fi); // ��ȡexcelģ��
		XSSFWorkbook wb = new XSSFWorkbook(in); // ��ȡ��ģ��������sheet����
		XSSFSheet sheet = wb.getSheetAt(0); // �������û���ˣ�������ʽ���������Զ������Ч����
		sheet.setForceFormulaRecalculation(true); // ����Ӧ�ĵ�Ԫ����и�ֵ
		XSSFCell cell = sheet.getRow(11).getCell(6);// ��12�� ��7��
		cell.setCellValue(1);
		XSSFCell cell2 = sheet.getRow(11).getCell(7);
		cell2.setCellValue(2);
		sheet.getRow(12).getCell(6).setCellValue(3);
		sheet.getRow(12).getCell(7).setCellValue(4); // �޸�ģ�����ݵ�����ģ��
		FileOutputStream out = new FileOutputStream(exportFilePath);
		wb.write(out);
		out.close();
	}
	/**
	 * @param @param file 
	 * @param @return 
	 * @param @throws IOException 
	 * @return
	 * List<String> (excelÿ��ƴ�ӳ�List�е�String) 
	 * @throws 
	 * @Title: readExcel
	 * @Description: TODO(�����ṩ��ȡexcel �ķ���)
	 */
	 public static synchronized void readExcel(String importFilePath,String exportFilePath) throws IOException {
		 File file=new File(importFilePath); 
		 String fileName = file.getName(); //List<String> list = new ArrayList<String>(); //���������ƻ�ȡ��׺ 
		 String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName .substring(fileName.lastIndexOf(".") + 1);
		 if ("xls".equals(extension)) {
			// read2003Excel(new FileInputStream(file),exportFilePath); 
			 } else if ("xlsx".equals(extension) || "xlsm".equals(extension)) { 
				// read2007Excel(new FileInputStream(file),exportFilePath); 
				 } else if ("tmp".equals(extension)) { 
				//	 read2007Excel(new FileInputStream(file),exportFilePath); 
					 } else { 
						 throw new IOException("��֧�ֵ��ļ�����"); 
						 } 
		 }
	 public static void main(String[] args) throws IOException{ //excle 2007 
		 String importFilePath= "/Users/dataDemo.xlsx"; 
		 String exportFilePath= "/Users/test2.xlsx"; 
		 createXLSX(importFilePath,exportFilePath); 
		// readExcel(importFilePath,exportFilePath); 
		 }
	 }
	 

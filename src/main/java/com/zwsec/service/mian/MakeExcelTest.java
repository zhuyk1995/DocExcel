package com.zwsec.service.mian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zwsec.service.entity.UserEntity;

public class MakeExcelTest {

	final static String filePath ="D:\\jira\\attach\\"; 
	
	/**
	 * ����Ҫ�洢�ļ���
	 * 
	 * @return
	 */
	protected static List<UserEntity> getUserEntiry() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		UserEntity entity = new UserEntity("��ʤ��", "123456");
		UserEntity entity2 = new UserEntity("��ǿ", "12138");
		UserEntity entity3 = new UserEntity("���ʤ", "52912138");

		userList.add(entity3);
		userList.add(entity2);
		userList.add(entity);
		return userList;
	}

	public static void main(String[] args) {
		// ��һ��������һ��workBook��Ӧ��excel�ļ�
		HSSFWorkbook workbook = new HSSFWorkbook();
		// �ڶ�������workBook�д���һ��sheet��Ӧ��excel�е�sheet
		HSSFSheet sheet = workbook.createSheet("©����Ϣ�����");
		// ����������sheet������ӱ�ͷ��0��
		HSSFRow row = sheet.createRow(0);
		// ���Ĳ���������Ԫ�����ñ�ͷ
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("�û���");
		cell = row.createCell(1);
		cell.setCellValue("����");

		// ���岽��д��ʵ�����ݣ�
		// ʵ��Ӧ������Щ���ݴ����ݿ�õ�,�����װ���ݣ����ϰ����󡣶��������ֵ��Ӧ���ÿ�е�ֵ

		List<UserEntity> userList = getUserEntiry();

		for (int i = 0; i < userList.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			UserEntity userEntity = userList.get(i);
			row1.createCell(0).setCellValue(userEntity.getUserName());
			row1.createCell(1).setCellValue(userEntity.getPassWord());
		}

		// ���ļ�������ָ��λ��

		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(filePath + getFileName());
			workbook.write(fos);
			System.out.println("д��ɹ�������");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileName() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhhMMss");
		String date = simpleDateFormat.format(new Date());
		String fileName = "\\��ά��Ϣ�Ƽ���Ȩ���з���ؾ�" + date + ".xls";
		return fileName;
	}
}

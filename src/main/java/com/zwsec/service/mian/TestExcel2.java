//package com.zwsec.service.mian;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//import com.zwsec.service.entity.TestData;
//import com.zwsec.service.util.ExcelUtils;
//import com.zwsec.service.util.SheetData;
//
//public class TestExcel2 {
//
//	public static void main(String[] args) {
//		
//		// ��ȡģ��
//		String model = "test.xls";
//		File f = new File("e:/test.xls");
//
//		SheetData[] sds = new SheetData[5];
//
//		// ����5������sheet
//		for (int i = 0; i < 5; i++) {
//			SheetData sd = new SheetData("����" + i);
//			sd.put("name", "����" + i);
//			sd.put("age", 13);
//
//			// ÿ��sheetҳ����100����������
//			// ע��������Լ���pojoҲ����ֱ��ʹ��map,������map������Ч�ʸ���һЩ
//			for (int j = 0; j < 100; j++) {
//				TestData td = new TestData(j, j * -1, "t" + j);
//				sd.addData(td);
//				;
//			}
//			sds[i] = sd;
//		}
//		try {
//			ExcelUtils.writeData(model, new FileOutputStream(f), sds);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
//}

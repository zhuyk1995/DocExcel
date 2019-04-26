package com.zwsec.service.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * word������
 * @author ZHUYK
 *
 */
public class DocUtil {

	private Configuration configuration;

	public DocUtil() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public byte[] createDocArea(List<Map<String, Object>> dataMapList, String outFilePath, String fileName)
			throws IOException {
		//ģ��·��
		this.configuration.setDirectoryForTemplateLoading(
				new File("D:\\eclipse-workspace\\DocCreate\\src\\main\\resources\\template"));
		Template t = null;
		File outFile = null;
		byte[] bFile = null;
		try {
			//�õ�ģ��
			t = this.configuration.getTemplate(fileName + ".xml", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//����Ŀ¼�Լ��ļ�
		outFile = new File(outFilePath);
		if (!outFile.exists()) {
			outFile.mkdirs();
		}
		outFile = new File(outFilePath + getNowDate());
		
		Writer w = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			w = new BufferedWriter(osw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			for (Map<String, Object> dataMap : dataMapList) {
				//д������
				t.process(dataMap, w);
			}
			if (outFile != null) {
				FileInputStream fis = new FileInputStream(outFile);
				bFile = new byte[(int) outFile.length()];
				fis.read(bFile);
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			w.close();
			fos.close();
		}
		return bFile;
	}

	/**
	 * ����Doc�ļ���
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String date = simpleDateFormat.format(new Date());
		String fileName = "\\jira��������" + date + ".doc";
		return fileName;
	}
}

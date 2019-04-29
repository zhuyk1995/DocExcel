//package com.zwsec.service.util;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
////import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.fasterxml.jackson.databind.util.ArrayIterator;
//
//import freemarker.core._ArrayIterator;
//
//
//public class ExcelUtils {
//
//	/** 
//     * Sheet���� 
//     * @param fromSheet 
//     * @param toSheet 
//     * @param copyValueFlag 
//     */  
//    public static void copySheet(Workbook wb,Sheet fromSheet, Sheet toSheet,  
//            boolean copyValueFlag) {  
//        //�ϲ�������  
//          
//        mergerRegion(fromSheet, toSheet);  
//        int index = 0;  
//        for (Iterator<Row> rowIt = fromSheet.rowIterator(); rowIt.hasNext();) {  
//            Row tmpRow =  rowIt.next();  
//            Row newRow = toSheet.createRow(tmpRow.getRowNum());  
//               
//            CellStyle style = tmpRow.getRowStyle();  
//            if(style != null)  
//                newRow.setRowStyle(tmpRow.getRowStyle());  
//              
//            newRow.setHeight(tmpRow.getHeight());  
//              
//            //��Ե�һ�������п�  
//            if(index == 0) {  
//                int first = tmpRow.getFirstCellNum();  
//                int last = tmpRow.getLastCellNum();  
//                for(int i = first ; i < last ; i++) {  
//                    int w = fromSheet.getColumnWidth(i);  
//                    toSheet.setColumnWidth(i, w + 1);  
//                }  
//                toSheet.setDefaultColumnWidth(fromSheet.getDefaultColumnWidth());  
//            }  
//              
//            //�и���  
//            copyRow(wb,tmpRow,newRow,copyValueFlag);  
//              
//            index++ ;  
//        }  
//    }  
//    /** 
//     * �и��ƹ��� 
//     * @param fromRow 
//     * @param toRow 
//     */  
//     static void copyRow(Workbook wb,Row fromRow,Row toRow,boolean copyValueFlag){  
//        for (Iterator<Cell> cellIt = fromRow.cellIterator(); cellIt.hasNext();) {  
//            Cell tmpCell = cellIt.next();  
//            Cell newCell = toRow.createCell(tmpCell.getColumnIndex());  
//            copyCell(wb,tmpCell, newCell, copyValueFlag);  
//        }  
//    }  
//    /** 
//    * ����ԭ��sheet�ĺϲ���Ԫ���´�����sheet 
//    *  
//    * @param sheetCreat �´���sheet 
//    * @param sheet      ԭ�е�sheet 
//    */  
//     static void mergerRegion(Sheet fromSheet, Sheet toSheet) {  
//       int sheetMergerCount = fromSheet.getNumMergedRegions();  
//       for (int i = 0; i < sheetMergerCount; i++) {  
//             
//           CellRangeAddress cra = fromSheet.getMergedRegion(i);  
//          
//           toSheet.addMergedRegion(cra);  
//       }  
//    }  
//    /** 
//     * ���Ƶ�Ԫ�� 
//     *  
//     * @param srcCell 
//     * @param distCell 
//     * @param copyValueFlag 
//     *            true����ͬcell������һ���� 
//     */  
//    public static void copyCell(Workbook wb,Cell srcCell, Cell distCell,  
//            boolean copyValueFlag) {  
//        CellStyle newstyle=wb.createCellStyle();  
//        newstyle.cloneStyleFrom(srcCell.getCellStyle());  
//        //��ʽ  
//        distCell.setCellStyle(newstyle);  
//        //����  
//        if (srcCell.getCellComment() != null) {  
//            distCell.setCellComment(srcCell.getCellComment());  
//        }  
//        // ��ͬ�������ʹ���  
//        CellType srcCellType = srcCell.getCellTypeEnum();  
//        distCell.setCellType(srcCellType);  
//          
//        if (copyValueFlag) {  
//            if (srcCellType == CellType.NUMERIC) {  
//                if (DateUtil.isCellDateFormatted(srcCell)) {  
//                    distCell.setCellValue(srcCell.getDateCellValue());  
//                } else {  
//                    distCell.setCellValue(srcCell.getNumericCellValue());  
//                }  
//            } else if (srcCellType == CellType.STRING ) {  
//                distCell.setCellValue(srcCell.getRichStringCellValue());  
//            } else if (srcCellType == CellType.BLANK ) {  
//                // nothing21  
//            } else if (srcCellType == CellType.BOOLEAN  ) {  
//                distCell.setCellValue(srcCell.getBooleanCellValue());  
//            } else if (srcCellType == CellType.ERROR ) {  
//                distCell.setCellErrorValue(srcCell.getErrorCellValue());  
//               
//            } else if (srcCellType == CellType.FORMULA  ) {  
//                distCell.setCellFormula(srcCell.getCellFormula());  
//            } else { // nothing29  
//            }  
//        }  
//    }  
//      
//      
//    /** 
//     * д��excel���� 
//     * @param model ���õ�ģ�� λ���� src/model/�� ģ���һ��sheetҳ������ģ��sheet 
//     * @param sheetDatas ģ������ 
//     */  
//       
//    public static void writeData(String model , OutputStream out,SheetData... sheetDatas ) {  
//        Workbook wb = null;  
//        try {  
//            InputStream input = ExcelUtils.class.getResourceAsStream("/model/" + model);  
//            if(input == null) {  
//                throw new RuntimeException("model excel file load error :/model/" + model + " , check model file is exists !");  
//            }  
//            if(model.endsWith(".xlsx"))  
//                wb = new XSSFWorkbook(input);  
//            else if(model.endsWith(".xls"))  
//                wb = new HSSFWorkbook(input);  
//            else  
//                throw new RuntimeException("model file format is not valid , this : " + model + " , eg:.xlsx or xls");  
//        } catch (IOException e) {  
//            throw new RuntimeException("model excel file load error :/model/" + model);  
//        }  
//        Sheet source =  wb.getSheetAt(0);  
//        //��һ���Ļ� ֱ����ģ��  
//        int size = sheetDatas.length ;  
//        for(int i = 0 ; i < size  ; i++) {  
//            if(i == 0) {  
//                wb.setSheetName(0, sheetDatas[0].getName());  
//            } else {  
//                Sheet toSheet = wb.createSheet(sheetDatas[i].getName());  
//                //���Ƹ�ʽ  
//                copySheet(wb, source, toSheet, true);  
//            }  
//        }  
//          
//        for(int i = 0 ; i < size  ; i++) {  
//            //д����  
//            writeData(sheetDatas[i], wb.getSheetAt(i));  
//        }  
//           
//        try {  
//            wb.write(out);  
//            out.flush();  
//            wb.close();  
//            out.close();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//          
//          
//    }  
//      
//    /** 
//     * ��sheetҳ��д������ 
//     * @param values ����Map 
//     * @param sheet sheet 
//     */  
//      public synchronized static void writeData(SheetData sheetData , Sheet sheet) {  
//        //��sheet���ҵ�ƥ��� #{}��ʾ���� , ${}��ʾ����,�Ӹõ�Ԫ��ʼ����׷��  
//    	  Iterator<Row> rowIt = sheet.rowIterator(); 
//        while(rowIt.hasNext()) {  
//        	//for(ArrayIterator<Row> rowIt = (ArrayIterator<Row>) sheet.rowIterator(); rowIt.hasNext();) {
//        	Row row = rowIt.next();//�쳣java.util.ConcurrentModificationException
//            //ȡcell  
//            for(int j = row.getFirstCellNum() ; j < row.getLastCellNum() ; j++) {  
//                Cell cell = row.getCell(j);  
//                //�ж�cell�������Ƿ���� $ ����#  
//                if(cell != null && cell.getCellTypeEnum() == CellType.STRING && cell.getStringCellValue() != null   
//                            && (cell.getStringCellValue().contains("$") || cell.getStringCellValue().contains("#") )) {  
//                    //����# $  
//                    String[] winds = CommonUtils.getWildcard(cell.getStringCellValue().trim());  
//                    for(String wind : winds) {  
//                        writeData(sheetData, wind , cell , sheet);  
//                    }  
//                }  
//            }  
//        }  
//    }  
//      
//    /** 
//     * ������� 
//     * @param values 
//     * @param keyWind #{name}ֻ�滻��ǰ or ${names} �ӵ�ǰ�п�ʼ�����滻 
//     */  
//    static void writeData(SheetData sheetData , String keyWind , Cell cell , Sheet sheet) {  
//        String key = keyWind.substring(2 , keyWind.length() - 1);  
//          
//        if(keyWind.startsWith("#")) {  
//            //���滻  
//            Object value = sheetData.get(key);  
//            //Ϊ�����滻Ϊ���ַ���  
//            if(value == null)   
//                value = "" ;  
//            String cellValue = cell.getStringCellValue();  
//            cellValue = cellValue.replace(keyWind, value.toString());  
//            cell.setCellValue(cellValue);  
//        } else  if(keyWind.startsWith("$")) {  
//            //��list��ÿ��ʵ�忪ʼ��,�����ӵ�ǰ��ʼ  
//            int rowindex = cell.getRowIndex();  
//            int columnindex = cell.getColumnIndex();  
//            List<? extends Object> listdata = sheetData.getDatas();  
//            //��Ϊ�յ�ʱ��ʼ���  
//            if(listdata != null && !listdata.isEmpty()){  
//                for(Object o : listdata) {  
//                    Object cellValue = CommonUtils.getValue(o, key);  
//                    Row row = sheet.getRow(rowindex);  
//                    if(row == null) {  
//                        row = sheet.createRow(rowindex);  
//                    }  
//                    //ȡ��cell  
//                    Cell c = row.getCell(columnindex);  
//                    if(c == null)   
//                        c = row.createCell(columnindex);  
//                    if(cell.getCellStyle() != null){   
//                        c.setCellStyle(cell.getCellStyle());  
//                    }  
//                    if(cell.getCellTypeEnum() != null) {  
//                        c.setCellType(cell.getCellTypeEnum());  
//                    }  
//                    if(cellValue != null) {  
//                        if(cellValue instanceof Number || CommonUtils.isNumber(cellValue) )  
//                            c.setCellValue( Double.valueOf(cellValue.toString()));  
//                        else if(cellValue instanceof Boolean)  
//                            c.setCellValue((Boolean)cellValue);  
//                        else if(cellValue instanceof Date)  
//                            c.setCellValue((Date)cellValue);  
//                        else  
//                            c.setCellValue(cellValue.toString());  
//                    } else {  
//                        //����Ϊ�� �����ǰ��Ԫ���Ѿ�������������Ϊ��  
//                        if(c.getStringCellValue() != null) {  
//                            c.setCellValue("");  
//                        }  
//                    }  
//                    rowindex++ ;  
//                }  
//            } else {  
//                //list����Ϊ����$ȫ���滻���ַ���  
//                String cellValue = "" ;  
//                cell.setCellValue(cellValue);  
//            }  
//        }  
//    }  
//}  
//

package com.wolfgy.util.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/**
	 * 
	 * <p>
	 * Description:删除excel指定行<br />
	 * </p>
	 * @author wolfgy
	 * @version 0.1 2018年1月17日
	 * @param inputFilePath 输入文件路径(eg:"C://test.xlsx")
	 * @param outputFilePath 输出文件路径(最终输出文件类型会与输入文件类型保持一致)
	 * @param rowList 要删除的具体行数
	 * @param sheetIndex 该excel文件中所要处理的sheet索引(第一个sheet的index为0)
	 * @throws Exception
	 * void
	 */
	public static void deleteSpecifiedRows(String inputFilePath,String outputFilePath,List<Integer> rowList,int sheetIndex) throws Exception{
		//获取文件名后缀判断文件类型
        String fileType = inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1,
                inputFilePath.length());
        //根据文件类型及文件输入流新建工作簿对象
        FileInputStream is = new FileInputStream(inputFilePath); 
        Workbook workbook = null;
        if (fileType.equals("xls")) {
        	workbook = new HSSFWorkbook(is);            
        } else if (fileType.equals("xlsx")) {
        	workbook = new XSSFWorkbook(is);
        } else {
        	is.close(); 
            throw new Exception("您输入的excel格式不正确");
        }
        Sheet sheet = workbook.getSheetAt(sheetIndex); 
        int lastRowNum = sheet.getLastRowNum();
        //倒序排列行数集合
        Collections.sort(rowList,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				}else if(o1 < o2){
					return 1;
				}
				return 0;
			}			
		});
        //遍历删除数据行
        for (int row : rowList) {
            sheet.shiftRows(row,lastRowNum--,-1);
		}
        //保证输入输出的文件类型一致。
        FileOutputStream os = new FileOutputStream(outputFilePath.substring(0,
        		inputFilePath.lastIndexOf(".") + 1)+fileType);  
        //写文件
        workbook.write(os);  
        is.close();  
        os.close();  
        workbook.close();
	}
}

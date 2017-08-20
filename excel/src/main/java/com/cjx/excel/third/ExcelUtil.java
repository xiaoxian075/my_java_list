package com.cjx.excel.third;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelUtil {
	public static boolean toExcel(ExcelNode excel, String filaName) {
		OutputStream output = null;
		try {
			output = new FileOutputStream(new File(filaName));
		} catch (FileNotFoundException e) {
			return false;
		}
		
		return toExcel(excel,output);
		
	}
	
	//将数据导出到Excel
		public static boolean toExcel(ExcelNode excel, OutputStream os) {
			List<ExcelSheet> listSheet = excel.getListSheet();
			
			boolean result = false;
			WritableWorkbook bWorkbook = null;
			try {
				// 创建Excel对象
				bWorkbook = Workbook.createWorkbook(os);
				for (ExcelSheet excelSheet : listSheet) {
					List<List<String>> table = excelSheet.getListRow();
					if (table==null)
						continue;

					// 通过Excel对象创建一个选项卡对象
					WritableSheet sheet = bWorkbook.createSheet(excelSheet.getName(), excelSheet.getIndex());
					//使用循环将数据读出
					int i=0,j=0;
					
					for (List<String> row : table) {
						if (row==null)
							continue;
						i=0;
						for (String str : row) {
							sheet.addCell(new Label(i,j,str));
							i++;
						}
						j++;
					}
				}
				
				//写如目标路径
				bWorkbook.write();
				result = true;
			} catch (Exception e) {
				result = false;
			} finally {
				try {
					bWorkbook.close();
				} catch (WriteException | IOException e) {
				}
			}
			return result;
		}
		

		public static ExcelNode fromExcel(String filaName) {
			InputStream input = null;
			try {
				input = new FileInputStream(new File(filaName));
			} catch (FileNotFoundException e) {
				return null;
			}
			
			return fromExcel(input);
			
		}
		//将Excel中的数据导入
		public static ExcelNode fromExcel(InputStream input) {
			List<ExcelSheet> listSheet = new ArrayList<ExcelSheet>();
			Workbook bWorkbook=null;
			try {
				bWorkbook = Workbook.getWorkbook(input);
				Sheet[] sheets = bWorkbook.getSheets();
				for (int j=0; j<sheets.length; j++) {
					
					Sheet sheet = sheets[j];
					String name = sheet.getName();
					ExcelSheet excelSheet = new ExcelSheet(j,name);
					for (int i = 0; i < sheet.getRows(); i++) {
						List<String> listRow = new ArrayList<String>();
						int col = sheet.getColumns();
						for (int k=0; k<col; k++) {
							listRow.add(sheet.getCell(k,i).getContents());
						}
						excelSheet.addRow(listRow);
					}
					listSheet.add(excelSheet);
				}
				
			} catch (BiffException e) {
				//e.printStackTrace();
				return null;
			} catch (IOException e) {
				//e.printStackTrace();
				return null;
			}finally {
				bWorkbook.close();
			}
			return new ExcelNode(listSheet);
		}


		
}

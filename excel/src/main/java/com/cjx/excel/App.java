package com.cjx.excel;

import java.util.ArrayList;
import java.util.List;

import com.cjx.excel.third.ExcelNode;
import com.cjx.excel.third.ExcelSheet;
import com.cjx.excel.third.ExcelUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	ExcelNode excel = new ExcelNode();
//		
//		List<Book> listT1 = new ArrayList<Book>();
//		listT1.add(new Book(1,"xiaoxian1","y1"));
//		listT1.add(new Book(2,"xiaoming1","feo1"));
//		listT1.add(new Book(3,"xiaoxue1","fe1"));
//		ExcelSheet sheet1 = new ExcelSheet(0,"test1");
//		sheet1.set(Book.toHead(),listT1);
//		excel.add(sheet1);
//		
//		List<Book> listT2 = new ArrayList<Book>();
//		listT2.add(new Book(1,"xiaoxian2","y2"));
//		listT2.add(new Book(2,"xiaoming2","feo2"));
//		listT2.add(new Book(3,"xiaoxue2","fe2"));
//		ExcelSheet sheet2 = new ExcelSheet(1,"test2");
//		sheet2.set(Book.toHead(), listT2);
//		excel.add(sheet2);
//		
//		List<Book> listT3 = new ArrayList<Book>();
//		listT3.add(new Book(1,"xiaoxian3","y3"));
//		listT3.add(new Book(2,"xiaoming3","feo3"));
//		listT3.add(new Book(3,"xiaoxue3","fe3"));
//		ExcelSheet sheet3 = new ExcelSheet(2,"test3");
//		sheet3.set(Book.toHead(),listT3);
//		excel.add(sheet3);
//		
//		ExcelUtil.toExcel(excel, "D:/text.xls");
		
		ExcelNode excel2 = ExcelUtil.fromExcel("D:/text.xls");
		List<List<String>> listHead = excel2.getHead();
		List<List<Book>> listBooks = excel2.getData(Book.class);
		System.out.println(listHead);
		System.out.println(listBooks);
    }
}

package com.cjx.excel.third;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ExcelNode {
	private List<ExcelSheet> listSheet;

	public ExcelNode() {
		super();
		listSheet = new ArrayList<ExcelSheet>();
	}
	
	public ExcelNode(List<ExcelSheet> listSheet) {
		super();
		this.listSheet = listSheet;
	}
	
	public boolean add(ExcelSheet excelSheet) {
		if (excelSheet==null)
			return false;
		int index = excelSheet.getIndex();
		String name = excelSheet.getName();
		if (index<0 || StringUtils.isBlank(name))
			return false;
		
		listSheet.add(excelSheet);
		
		return true;
	}
	
	public ExcelSheet getSheet(int index) {
		return listSheet.get(0);
	}

	public List<ExcelSheet> getListSheet() {
		return listSheet;
	}

	public void setListSheet(List<ExcelSheet> listSheet) {
		this.listSheet = listSheet;
	}

	public <T extends ExcelBase> List<List<T>> getAll(Class<T> clazz) {
		List<List<T>> listData = new ArrayList<List<T>>();
		for (ExcelSheet sheet : listSheet) {
			listData.add(sheet.getAll(clazz));
		}
		return listData;
	}
	
	public List<List<String>> getHead() {
		List<List<String>> listData = new ArrayList<List<String>>();
		for (ExcelSheet sheet : listSheet) {
			listData.add(sheet.getHead());
		}
		return listData;
	}
	
	public <T extends ExcelBase> List<List<T>> getData(Class<T> clazz) {
		List<List<T>> listData = new ArrayList<List<T>>();
		for (ExcelSheet sheet : listSheet) {
			listData.add(sheet.getData(clazz));
		}
		return listData;
	}
}


package com.cjx.excel.third;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExcelSheet implements Serializable {
	private static final long serialVersionUID = 8796598610295840575L;
	
	private int index;	//索引
	private String name;	//名称
	private List<List<String>> listRow;	//索引里的内容
	
	public boolean setHead(List<String> head) {
		if (head==null || head.size()==0)
			return false;
		listRow.clear();
		listRow.add(head);
		return true;
	}
	
	public <T extends ExcelBase> boolean set(List<T> listT) {
		if (listT==null || listT.size()==0)
			return false;
		listRow.clear();
		for (T t : listT) {
			listRow.add(t.toList());
		}
		return true;
	}
	
	public <T extends ExcelBase> boolean set(List<String> head, List<T> listT) {
		if (head==null || head.size()==0 || listT==null || listT.size()==0)
			return false;
		listRow.clear();
		listRow.add(head);
		for (T t : listT) {
			listRow.add(t.toList());
		}
		return true;
	}
	
	public <T extends ExcelBase> void add(List<T> listT) {
		if (listT==null || listT.size()==0)
			return;
		for (T t : listT) {
			listRow.add(t.toList());
		}
	}
	
	public <T extends ExcelBase> List<T> getAll(Class<T> clazz) {
		
		List<T> listT = new ArrayList<T>();
		try {
			for (List<String> ls : listRow) {
				T t = clazz.newInstance();
				t.toT(ls);
				listT.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		
		return listT;
	}
	
	public List<String> getHead() {
		if (listRow!=null && listRow.size()>0)
			return listRow.get(0);
		return null;
	}

	public <T extends ExcelBase> List<T> getData(Class<T> clazz) {
		
		List<T> listT = new ArrayList<T>();
		try {
			int count = listRow.size();
			for (int i=1; i<count; i++) {
				List<String> ls = listRow.get(i);
				T t = clazz.newInstance();
				t.toT(ls);
				listT.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		
		return listT;
	}
	
	
	public ExcelSheet() {
		super();
		this.listRow = new ArrayList<List<String>>();
	}
	public ExcelSheet(int index, String name) {
		super();
		this.index = index;
		this.name = name;
		this.listRow = new ArrayList<List<String>>();
	}
	public ExcelSheet(int index, String name, List<List<String>> listRow) {
		super();
		this.index = index;
		this.name = name;
		this.listRow = listRow;
	}
	public void addRow(List<String> row) {
		listRow.add(row);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<List<String>> getListRow() {
		return listRow;
	}
	public void setListRow(List<List<String>> listRow) {
		this.listRow = listRow;
	}
	
	
}

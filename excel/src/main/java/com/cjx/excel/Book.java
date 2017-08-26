package com.cjx.excel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cjx.excel.third.ExcelBase;


public class Book implements ExcelBase,Serializable {
	private static final long serialVersionUID = 4803775458484283217L;
	
	private int id;
	private String name;
	private String type;
	public Book() {
		super();
	}
	public Book(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	public static List<String> toHead() {
		List<String> arrStr = new ArrayList<String>();
		
		arrStr.add("天有");
		arrStr.add("国是");
		arrStr.add("海雨");
		
		return arrStr;
	}
	
	public List<String> toList() {
		List<String> arrStr = new ArrayList<String>();
		
		arrStr.add(String.valueOf(id));
		arrStr.add(name);
		arrStr.add(type);
		
		return arrStr;
	}
	
	public void toT(List<String> listStr) {
		if (listStr!=null) {
			int count = listStr.size();
			if (count>0)
				id = Integer.valueOf(listStr.get(0));
			if (count>1)
				name = listStr.get(1);
			if (count>2)
				type = listStr.get(2);
		}
	}
	
	
}


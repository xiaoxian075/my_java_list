package admin.entity;

import java.io.Serializable;

public class AreaShort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2553839940005440584L;
	private String area_id;
	private String area_name;
	public AreaShort() {
		super();
	}
	public AreaShort(String area_id, String area_name) {
		super();
		this.area_id = area_id;
		this.area_name = area_name;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
}

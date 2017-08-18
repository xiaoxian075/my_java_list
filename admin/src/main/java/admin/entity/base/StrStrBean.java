package admin.entity.base;

import java.io.Serializable;

public class StrStrBean implements Serializable{
	private static final long serialVersionUID = -7823875246750599779L;
	private String id;
	private String name;
	public StrStrBean() {
		super();
	}
	public StrStrBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


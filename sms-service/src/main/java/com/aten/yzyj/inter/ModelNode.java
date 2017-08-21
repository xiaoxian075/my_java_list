package com.aten.yzyj.inter;

import java.io.Serializable;

public class ModelNode implements Serializable {
	private static final long serialVersionUID = 381618178879041822L;
	private long tpl_id;
	private String tpl_content;
	private String check_status;
	private String reason;

	public ModelNode() {
		super();
	}
	public ModelNode(long tpl_id, String tpl_content, String check_status, String reason) {
		super();
		this.tpl_id = tpl_id;
		this.tpl_content = tpl_content;
		this.check_status = check_status;
		this.reason = reason;
	}
	public long getTpl_id() {
		return tpl_id;
	}
	public void setTpl_id(long tpl_id) {
		this.tpl_id = tpl_id;
	}
	public String getTpl_content() {
		return tpl_content;
	}
	public void setTpl_content(String tpl_content) {
		this.tpl_content = tpl_content;
	}
	public String getCheck_status() {
		return check_status;
	}
	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ModelNode [tpl_id=" + tpl_id + ", tpl_content=" + tpl_content + ", check_status=" + check_status
				+ ", reason=" + reason + "]";
	}
	
	
}

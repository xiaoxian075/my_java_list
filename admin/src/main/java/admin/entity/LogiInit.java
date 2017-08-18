package admin.entity;

import java.io.Serializable;
import java.util.List;

import admin.entity.base.StrStrBean;

public class LogiInit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -901243737923508258L;
	private List<LogiAreaList> logiArea;
	private List<StrStrBean> sendtime;
	public LogiInit(List<LogiAreaList> logiArea, List<StrStrBean> sendtime) {
		super();
		this.logiArea = logiArea;
		this.sendtime = sendtime;
	}
	public List<LogiAreaList> getLogiArea() {
		return logiArea;
	}
	public void setLogiArea(List<LogiAreaList> logiArea) {
		this.logiArea = logiArea;
	}
	public List<StrStrBean> getSendtime() {
		return sendtime;
	}
	public void setSendtime(List<StrStrBean> sendtime) {
		this.sendtime = sendtime;
	}
}


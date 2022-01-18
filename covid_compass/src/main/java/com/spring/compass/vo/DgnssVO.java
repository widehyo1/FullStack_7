package com.spring.compass.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DgnssVO implements Serializable{

	private String hsptNo;
	private Date reqYmd = new Date();
	private Date cancleYmd;
	private String childNo;
	private String manageNo;
	private String dgnssNo;
	private String dgnssCode;
	private String type;
	public String getHsptNo() {
		return hsptNo;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);		
	}
	public void setHsptNo(String hsptNo) {
		this.hsptNo = hsptNo;
	}
	public Date getReqYmd() {
		return reqYmd;
	}
	public void setReqYmd(Date reqYmd) {
		this.reqYmd = reqYmd;
	}
	public Date getCancleYmd() {
		return cancleYmd;
	}
	public void setCancleYmd(Date cancleYmd) {
		this.cancleYmd = cancleYmd;
	}
	public String getChildNo() {
		return childNo;
	}
	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}
	public String getManageNo() {
		return manageNo;
	}
	public void setManageNo(String manageNo) {
		this.manageNo = manageNo;
	}
	public String getDgnssNo() {
		return dgnssNo;
	}
	public void setDgnssNo(String dgnssNo) {
		this.dgnssNo = dgnssNo;
	}
	public String getDgnssCode() {
		return dgnssCode;
	}
	public void setDgnssCode(String dgnssCode) {
		this.dgnssCode = dgnssCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

package com.spring.compass.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SmplResultVO implements Serializable{

	private String instNo;
	private Date reqYmd;
	private String pbhtNo;
	private String pstvYn;
	private String manageNo;
	private String chkdYn;
	private Date resYmd = new Date();
	private String smplNo;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);		
	}
	public String getInstNo() {
		return instNo;
	}
	public void setInstNo(String instNo) {
		this.instNo = instNo;
	}
	public Date getReqYmd() {
		return reqYmd;
	}
	public void setReqYmd(Date reqYmd) {
		this.reqYmd = reqYmd;
	}
	public String getPbhtNo() {
		return pbhtNo;
	}
	public void setPbhtNo(String pbhtNo) {
		this.pbhtNo = pbhtNo;
	}
	public String getPstvYn() {
		return pstvYn;
	}
	public void setPstvYn(String pstvYn) {
		this.pstvYn = pstvYn;
	}
	public String getManageNo() {
		return manageNo;
	}
	public void setManageNo(String manageNo) {
		this.manageNo = manageNo;
	}
	public String getChkdYn() {
		return chkdYn;
	}
	public void setChkdYn(String chkdYn) {
		this.chkdYn = chkdYn;
	}
	public Date getResYmd() {
		return resYmd;
	}
	public void setResYmd(Date resYmd) {
		this.resYmd = resYmd;
	}
	public String getSmplNo() {
		return smplNo;
	}
	public void setSmplNo(String smplNo) {
		this.smplNo = smplNo;
	}

}

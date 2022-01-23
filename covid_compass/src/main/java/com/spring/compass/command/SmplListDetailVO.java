package com.spring.compass.command;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SmplListDetailVO {

	private Date reqYmd;
	private String instNm;
	private String pstiNm;
	private String rrn;
	private String pstiTelno;
	private String rechkdYn;
	private String pstiAdres;
	private String reqInstNm;
	private String instTelno;
	private String instAdres;
	private String smplNo;
	private String pbhtNo;
	private String instNo;
	private String manageNo;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	

	public Date getReqYmd() {
		return reqYmd;
	}


	public void setReqYmd(Date reqYmd) {
		this.reqYmd = reqYmd;
	}


	public String getInstNm() {
		return instNm;
	}

	public void setInstNm(String instNm) {
		this.instNm = instNm;
	}

	public String getPstiNm() {
		return pstiNm;
	}

	public void setPstiNm(String pstiNm) {
		this.pstiNm = pstiNm;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getPstiTelno() {
		return pstiTelno;
	}

	public void setPstiTelno(String pstiTelno) {
		this.pstiTelno = pstiTelno;
	}

	public String getRechkdYn() {
		return rechkdYn;
	}

	public void setRechkdYn(String rechkdYn) {
		this.rechkdYn = rechkdYn;
	}

	public String getPstiAdres() {
		return pstiAdres;
	}

	public void setPstiAdres(String pstiAdres) {
		this.pstiAdres = pstiAdres;
	}

	public String getReqInstNm() {
		return reqInstNm;
	}

	public void setReqInstNm(String reqInstNm) {
		this.reqInstNm = reqInstNm;
	}

	public String getInstTelno() {
		return instTelno;
	}

	public void setInstTelno(String instTelno) {
		this.instTelno = instTelno;
	}

	public String getInstAdres() {
		return instAdres;
	}

	public void setInstAdres(String instAdres) {
		this.instAdres = instAdres;
	}

	public String getSmplNo() {
		return smplNo;
	}

	public void setSmplNo(String smplNo) {
		this.smplNo = smplNo;
	}

	public String getPbhtNo() {
		return pbhtNo;
	}

	public void setPbhtNo(String pbhtNo) {
		this.pbhtNo = pbhtNo;
	}

	public String getInstNo() {
		return instNo;
	}

	public void setInstNo(String instNo) {
		this.instNo = instNo;
	}

	public String getManageNo() {
		return manageNo;
	}

	public void setManageNo(String manageNo) {
		this.manageNo = manageNo;
	}
	
}

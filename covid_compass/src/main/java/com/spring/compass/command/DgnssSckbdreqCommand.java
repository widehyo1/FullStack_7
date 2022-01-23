package com.spring.compass.command;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DgnssSckbdreqCommand implements Serializable{

	private String dgnssNo;
	private String dgnssResultCode;
	private String dgnssNote;
	
	private String fromLtctNo;
	private String toLtctNo;
	private String fromHsptNo;
	private String toHsptNo;
	
	private String manageNo;
	
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

	public String getDgnssResultCode() {
		return dgnssResultCode;
	}

	public void setDgnssResultCode(String dgnssResultCode) {
		this.dgnssResultCode = dgnssResultCode;
	}

	public String getDgnssNote() {
		return dgnssNote;
	}

	public void setDgnssNote(String dgnssNote) {
		this.dgnssNote = dgnssNote;
	}

	public String getFromLtctNo() {
		return fromLtctNo;
	}

	public void setFromLtctNo(String fromLtctNo) {
		this.fromLtctNo = fromLtctNo;
	}

	public String getToLtctNo() {
		return toLtctNo;
	}

	public void setToLtctNo(String toLtctNo) {
		this.toLtctNo = toLtctNo;
	}

	public String getFromHsptNo() {
		return fromHsptNo;
	}

	public void setFromHsptNo(String fromHsptNo) {
		this.fromHsptNo = fromHsptNo;
	}

	public String getToHsptNo() {
		return toHsptNo;
	}

	public void setToHsptNo(String toHsptNo) {
		this.toHsptNo = toHsptNo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);	
	}
		
	
}

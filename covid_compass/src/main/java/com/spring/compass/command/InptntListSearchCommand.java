package com.spring.compass.command;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class InptntListSearchCommand 
				extends SearchCriteria 
				implements Serializable{
	
	public InptntListSearchCommand() {}
	public InptntListSearchCommand(int page, int perPageNum, String searchType, String keyword) {
		super(page, perPageNum, searchType, keyword);
		
	}
	
	private String typeCode = "";
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	private String hsptNo = "";

	public String getHsptNo() {
		return hsptNo;
	}

	public void setHsptNo(String hsptNo) {
		this.hsptNo = hsptNo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
}

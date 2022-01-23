package com.spring.compass.command;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class InspPstiRegistCommand implements Serializable {

	private String pstiNo;
	private int maxBrssr;
	private int minBrssr;
	private int bdheight;
	private int bdweight;
	private int bdheat;
	private int rmndKitCnt;
	private String inspNo;
	public String getPstiNo() {
		return pstiNo;
	}
	public void setPstiNo(String pstiNo) {
		this.pstiNo = pstiNo;
	}
	public int getMaxBrssr() {
		return maxBrssr;
	}
	public void setMaxBrssr(int maxBrssr) {
		this.maxBrssr = maxBrssr;
	}
	public int getMinBrssr() {
		return minBrssr;
	}
	public void setMinBrssr(int minBrssr) {
		this.minBrssr = minBrssr;
	}
	public int getBdheight() {
		return bdheight;
	}
	public void setBdheight(int bdheight) {
		this.bdheight = bdheight;
	}
	public int getBdweight() {
		return bdweight;
	}
	public void setBdweight(int bdweight) {
		this.bdweight = bdweight;
	}
	public int getBdheat() {
		return bdheat;
	}
	public void setBdheat(int bdheat) {
		this.bdheat = bdheat;
	}
	public int getRmndKitCnt() {
		return rmndKitCnt;
	}
	public void setRmndKitCnt(int rmndKitCnt) {
		this.rmndKitCnt = rmndKitCnt;
	}
	public String getInspNo() {
		return inspNo;
	}
	public void setInspNo(String inspNo) {
		this.inspNo = inspNo;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}

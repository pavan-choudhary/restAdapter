package com.adapter.restadapter.model;

public class Header {
	private int SourceId;
	private String SourceTime;
	private String Market;

	public void setSourceId(int sourceId) {
		this.SourceId = sourceId;
	}

	public void setSourceTime(String sourceTime) {
		this.SourceTime = sourceTime;
	}

	public void setMarket(String market) {
		this.Market = market;
	}

	public int getSourceId() {
		return SourceId;
	}

	public String getSourceTime() {
		return SourceTime;
	}

	public String getMarket() {
		return Market;
	}

}

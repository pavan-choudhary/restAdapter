package com.adapter.restadapter.model;

public class EquitiesInfo {
	private int Fungible;
	private String MarketPrice;
	private String Exdividend;

	public void setFungible(int fungible) {
		this.Fungible = fungible;
	}

	public void setMarketPrice(String marketPrice) {
		MarketPrice = marketPrice;
	}

	public void setExdividend(String exdividend) {
		Exdividend = exdividend;
	}

	public int getFungible() {
		return Fungible;
	}

	public String getMarketPrice() {
		return MarketPrice;
	}

	public String getExdividend() {
		return Exdividend;
	}

}

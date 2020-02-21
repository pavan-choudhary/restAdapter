package com.adapter.restadapter.model;

public class SecurityList {
	private String Currency;
	private double CurrencyValue;

	public void setCurrency(String currency) {
		this.Currency = currency;
	}

	public void setCurrencyValue(double currencyValue) {
		this.CurrencyValue = currencyValue;
	}

	public String getCurrency() {
		return Currency;
	}

	public double getCurrencyValue() {
		return CurrencyValue;
	}

}

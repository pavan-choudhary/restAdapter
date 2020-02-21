package com.adapter.restadapter.model;

public class BvcSymboInfo {
	private String ISIN;
	private String Reinv;
	private String Transaction;
	private String LiqTerm;
	private String TrdSimType;
	private double CaptureValue;
	private String MktType;
	private String Allowed;
	private String PTI;
	private String PET;
	private int SeqType;
	private int SeqNumber;
	private String HoraOpe;

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public void setReinv(String reinv) {
		this.Reinv = reinv;
	}

	public void setTransaction(String transaction) {
		this.Transaction = transaction;
	}

	public void setLiqTerm(String liqTerm) {
		this.LiqTerm = liqTerm;
	}

	public void setTrdSimType(String trdSimType) {
		this.TrdSimType = trdSimType;
	}

	public void setCaptureValue(double captureValue) {
		this.CaptureValue = captureValue;
	}

	public void setMktType(String mktType) {
		this.MktType = mktType;
	}

	public void setAllowed(String allowed) {
		this.Allowed = allowed;
	}

	public void setPTI(String pTI) {
		PTI = pTI;
	}

	public void setPET(String pET) {
		PET = pET;
	}

	public void setSeqType(int seqType) {
		this.SeqType = seqType;
	}

	public void setSeqNumber(int seqNumber) {
		this.SeqNumber = seqNumber;
	}

	public void setHoraOpe(String horaOpe) {
		this.HoraOpe = horaOpe;
	}

	public String getISIN() {
		return ISIN;
	}

	public String getReinv() {
		return Reinv;
	}

	public String getTransaction() {
		return Transaction;
	}

	public String getLiqTerm() {
		return LiqTerm;
	}

	public String getTrdSimType() {
		return TrdSimType;
	}

	public double getCaptureValue() {
		return CaptureValue;
	}

	public String getMktType() {
		return MktType;
	}

	public String getAllowed() {
		return Allowed;
	}

	public String getPTI() {
		return PTI;
	}

	public String getPET() {
		return PET;
	}

	public int getSeqType() {
		return SeqType;
	}

	public int getSeqNumber() {
		return SeqNumber;
	}

	public String getHoraOpe() {
		return HoraOpe;
	}

}

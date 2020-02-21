package com.adapter.restadapter.model;

import java.util.List;

public class ExecReport {
	private int SourceId;
	private String ExecType;
	private List<Party> Party;
	private String TransactTime;
	private int RdMatchID;
	private String Side;
	private String Symbol;
	private int SettlDate;
	private int SettlType;
	private long LastQty;
	private double LastPx;
	private double GrossTradeAmt;
	private String Yield;
	private String IsPreArrenged;
	private double StipulationValue;
	private String SecuritySubType;
	private String GetSide;

	public void setSourceId(int sourceId) {
		this.SourceId = sourceId;
	}

	public void setExecType(String execType) {
		this.ExecType = execType;
	}

	public void setParty(List<Party> party) {
		this.Party = party;
	}

	public void setTransactTime(String transactTime) {
		this.TransactTime = transactTime;
	}

	public void setRdMatchID(int rdMatchID) {
		this.RdMatchID = rdMatchID;
	}

	public void setSide(String side) {
		this.Side = side;
	}

	public void setSymbol(String symbol) {
		this.Symbol = symbol;
	}

	public void setSettlDate(int settlDate) {
		this.SettlDate = settlDate;
	}

	public void setSettlType(int settlType) {
		this.SettlType = settlType;
	}

	public void setLastQty(long lastQty) {
		this.LastQty = lastQty;
	}

	public void setLastPx(double lastPx) {
		this.LastPx = lastPx;
	}

	public void setGrossTradeAmt(double grossTradeAmt) {
		this.GrossTradeAmt = grossTradeAmt;
	}

	public void setYield(String yield) {
		this.Yield = yield;
	}

	public void setIsPreArrenged(String isPreArrenged) {
		this.IsPreArrenged = isPreArrenged;
	}

	public void setStipulationValue(double stipulationValue) {
		this.StipulationValue = stipulationValue;
	}

	public void setSecuritySubType(String securitySubType) {
		this.SecuritySubType = securitySubType;
	}

	public void setGetSide(String getSide) {
		this.GetSide = getSide;
	}

	public int getSourceId() {
		return SourceId;
	}

	public String getExecType() {
		return ExecType;
	}

	public List<Party> getParty() {
		return Party;
	}

	public String getTransactTime() {
		return TransactTime;
	}

	public int getRdMatchID() {
		return RdMatchID;
	}

	public String getSide() {
		return Side;
	}

	public String getSymbol() {
		return Symbol;
	}

	public int getSettlDate() {
		return SettlDate;
	}

	public int getSettlType() {
		return SettlType;
	}

	public long getLastQty() {
		return LastQty;
	}

	public double getLastPx() {
		return LastPx;
	}

	public double getGrossTradeAmt() {
		return GrossTradeAmt;
	}

	public String getYield() {
		return Yield;
	}

	public String getIsPreArrenged() {
		return IsPreArrenged;
	}

	public double getStipulationValue() {
		return StipulationValue;
	}

	public String getSecuritySubType() {
		return SecuritySubType;
	}

	public String getGetSide() {
		return GetSide;
	}

}

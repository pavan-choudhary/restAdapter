package com.adapter.restadapter.model;

public class Payload {
	private Header Header;
	private BvcSymboInfo BvcSymboInfo;
	private EquitiesInfo EquitiesInfo;
	private SecurityList SecurityList;
	private MecSymbolInfo MecSymbolInfo;
	private ExecReport ExecReport;
	public Header getHeader() {
		return Header;
	}
	public void setHeader(Header header) {
		Header = header;
	}
	public BvcSymboInfo getBvcSymboInfo() {
		return BvcSymboInfo;
	}
	public void setBvcSymboInfo(BvcSymboInfo bvcSymboInfo) {
		BvcSymboInfo = bvcSymboInfo;
	}
	public EquitiesInfo getEquitiesInfo() {
		return EquitiesInfo;
	}
	public void setEquitiesInfo(EquitiesInfo equitiesInfo) {
		EquitiesInfo = equitiesInfo;
	}
	public SecurityList getSecurityList() {
		return SecurityList;
	}
	public void setSecurityList(SecurityList securityList) {
		SecurityList = securityList;
	}
	public MecSymbolInfo getMecSymbolInfo() {
		return MecSymbolInfo;
	}
	public void setMecSymbolInfo(MecSymbolInfo mecSymbolInfo) {
		MecSymbolInfo = mecSymbolInfo;
	}
	public ExecReport getExecReport() {
		return ExecReport;
	}
	public void setExecReport(ExecReport execReport) {
		ExecReport = execReport;
	}
	
	
}

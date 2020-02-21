package com.adapter.restadapter.model;

public class Party {
	private String PartyId;
	private int PartyRole;

	public Party(String id, int role) {
		this.PartyId = id;
		this.PartyRole = role;
	}

	public void setPartyId(String partyId) {
		this.PartyId = partyId;
	}

	public void setPartyRole(int partyRole) {
		this.PartyRole = partyRole;
	}

	public String getPartyId() {
		return PartyId;
	}

	public int getPartyRole() {
		return PartyRole;
	}

}

package com.apple.codeChallange.response;

import java.util.List;

import com.apple.codeChallange.entity.Continent;

public class ContinentResponse {

	private int statusCode;
	
	private List<Continent> continents;

	public ContinentResponse() {
	}
	
	public ContinentResponse(int statusCode,List<Continent> continents) {
		this.statusCode=statusCode;
		this.continents = continents;
	}

	public List<Continent> getContinents() {
		return continents;
	}

	@Override
	public String toString() {
		return "ContinentResponse [statusCode=" + statusCode + ", continents=" + continents + "]";
	}

}

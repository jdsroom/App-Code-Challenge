package com.apple.codeChallange.response;

import java.util.List;

import com.apple.codeChallange.entity.Country;

public class CountryResponse {

	private int statusCode;
	
	private List<Country> countries;

	public CountryResponse() {
	}
	
	public CountryResponse(int statusCode,List<Country> countries) {
		this.statusCode=statusCode;
		this.countries = countries;
	}

	public List<Country> getCountries() {
		return countries;
	}

	@Override
	public String toString() {
		return "CountryResponse [statusCode=" + statusCode + ", countries=" + countries + "]";
	}

}

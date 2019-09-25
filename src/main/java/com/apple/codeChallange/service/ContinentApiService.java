package com.apple.codeChallange.service;

import java.util.List;

import com.apple.codeChallange.entity.Continent;
import com.apple.codeChallange.entity.Country;

public interface ContinentApiService {

	public List<Country> getCountriesByContinent(String name);
	public List<Continent> getAllContinents();
	public String getFlagByCountry(String name);
}

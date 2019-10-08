package com.app.codeChallange.service;

import java.util.List;

import com.app.codeChallange.entity.Continent;
import com.app.codeChallange.entity.Country;

public interface ContinentApiService {

	public List<Country> getCountriesByContinent(String name);
	public List<Continent> getAllContinents();
	public String getFlagByCountry(String name);
}

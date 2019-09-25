package com.apple.codeChallange.repository;

import java.util.List;

import com.apple.codeChallange.entity.Continent;
import com.apple.codeChallange.entity.Country;


public interface ContinentRepository  {

	public List<Continent> getAllContinents();
	public List<Country> getCountriesByContinent(String continentName);
	public String getFlagByCountry(String name);
}

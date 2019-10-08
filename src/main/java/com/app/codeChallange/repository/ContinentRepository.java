package com.app.codeChallange.repository;

import java.util.List;

import com.app.codeChallange.entity.Continent;
import com.app.codeChallange.entity.Country;


public interface ContinentRepository  {

	public List<Continent> getAllContinents();
	public List<Country> getCountriesByContinent(String continentName);
	public String getFlagByCountry(String name);
}

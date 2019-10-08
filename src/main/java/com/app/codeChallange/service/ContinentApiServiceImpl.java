package com.app.codeChallange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.codeChallange.entity.Continent;
import com.app.codeChallange.entity.Country;
import com.app.codeChallange.repository.ContinentRepository;

@Service
public class ContinentApiServiceImpl implements ContinentApiService {

	@Autowired
	private ContinentRepository continentRepository;
	
	@Override
	public List<Country> getCountriesByContinent(String name) {
		return continentRepository.getCountriesByContinent(name);
	}

	@Override
	public List<Continent> getAllContinents() {
		return continentRepository.getAllContinents();
	}

	@Override
	public String getFlagByCountry(String name) {
		return continentRepository.getFlagByCountry(name);
	}

}

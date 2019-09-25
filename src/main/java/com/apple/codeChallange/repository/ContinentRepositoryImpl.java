package com.apple.codeChallange.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apple.codeChallange.entity.Continent;
import com.apple.codeChallange.entity.Country;

@Repository
@Transactional
public class ContinentRepositoryImpl implements ContinentRepository{

	@Autowired
	private EntityManager entityManager;  
	
	@Override
	public List<Continent> getAllContinents() {
		TypedQuery<Continent> query = entityManager.createNamedQuery("query_get_All_continents", Continent.class);
		List<Continent> continents = query.getResultList();
		return continents;
	}

	@Override
	public List<Country> getCountriesByContinent(String continentName) {
		TypedQuery<Continent> query = entityManager.createNamedQuery("query_get_All_countries_by_continent_name", Continent.class);
		query = query.setParameter("continentName", continentName);
		Continent continent = query.getSingleResult();
		List<Country> countries = continent.getCountries();
		return countries;
	}

	@Override
	public String getFlagByCountry(String countryName) {
		TypedQuery<Country> query = entityManager.createNamedQuery("query_get_countryFlag_by_country_name", Country.class);
		query = query.setParameter("countryName", countryName);
		Country country = query.getSingleResult();
		String flag = country.getFlag();
		return flag;
	}

}

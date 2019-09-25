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
public class CrudRepository {

	@Autowired
	private EntityManager entityManager; 
	
	public void insertData(Continent continent) {
		List<Country> countries = continent.getCountries();
		for(Country country:countries) {
			country.setContinent(continent);
			entityManager.persist(country);
		}
		entityManager.persist(continent);
	}

}

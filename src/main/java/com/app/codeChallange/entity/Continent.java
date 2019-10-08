package com.app.codeChallange.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
 @NamedQueries(value = {
		 @NamedQuery(name = "query_get_All_continents", query =
				  "SELECT c FROM Continent c "
				  ),
	     @NamedQuery(name = "query_get_All_countries_by_continent_name", query =
				  "SELECT c FROM Continent c WHERE c.continent =:continentName "
				  ) })
public class Continent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTINENT_ID")
	private Long id;
	
	@Column(name = "CONTINENT_NAME")
	private String continent;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "continent",cascade = CascadeType.ALL)
	private List<Country> countries = new ArrayList<>();
	
	public Continent() {}
	
	public Continent(String continent, List<Country> countries) {
		this.continent = continent;
		this.countries = countries;
	}
	
	public Long getId() {
		return id;
	}

	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", continentName=" + continent + ", countries=" + countries + "]";
	}

	
}

package com.app.codeChallange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@NamedQueries(value = {
	     @NamedQuery(name = "query_get_countryFlag_by_country_name", query =
				  "SELECT c FROM Country c WHERE c.name =:countryName "
				  ) })
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private Long id;
	
	@Column(name = "COUNTRY_NAME")
	private String name;
	
	@Column(name = "COUNTRY_FLAG")
	private String flag;
	
	@ManyToOne
	@JoinColumn(name="CONTINENT_ID")
	@JsonBackReference
	private Continent continent;
	
	public Country() {}
	
	public Country(String name, String flag) {
		this.name = name;
		this.flag = flag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", flag=" + flag + "]";
	}
	
}

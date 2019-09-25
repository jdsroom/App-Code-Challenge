package com.apple.codeChallange.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.codeChallange.entity.Continent;
import com.apple.codeChallange.entity.Country;
import com.apple.codeChallange.exception.ContinentNotFoundException;
import com.apple.codeChallange.exception.CountryNotFoundException;
import com.apple.codeChallange.response.ContinentResponse;
import com.apple.codeChallange.response.CountryResponse;
import com.apple.codeChallange.service.ContinentApiServiceImpl;

@RestController
@RequestMapping("/continent")
public class ContinentApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ContinentApiServiceImpl continentApiServiceImpl;
	
	@RequestMapping(path="/retrieveAllContinents",method = RequestMethod.GET)
	public ResponseEntity<ContinentResponse> retrieveAllContinents(){
		ContinentResponse continentResponse = new ContinentResponse(HttpStatus.OK.value(),continentApiServiceImpl.getAllContinents());
		 logger.info("ContinentResponse -> {}",continentResponse);
		return new ResponseEntity<>(continentResponse, HttpStatus.OK);
	}
	
	@RequestMapping(path="/retrieveCountriesByContinent",method = RequestMethod.GET)
	public ResponseEntity<CountryResponse> retrieveCountriesByContinent(@RequestParam(name = "continent") String continentName){
		List<Country> countries = continentApiServiceImpl.getCountriesByContinent(continentName);
		if(countries==null) {
			throw new ContinentNotFoundException("continentName-"+continentName);
		}
		else {
		CountryResponse countryResponse = new CountryResponse(HttpStatus.OK.value(),countries);
		logger.info("CountryResponse -> {}",countryResponse);
		 return new ResponseEntity<>(countryResponse, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path="/retrieveFlagByCountry",method = RequestMethod.GET)
	public ResponseEntity<String> retrieveFlagByCountry(@RequestParam(name = "country") String countryName){
		String flag = continentApiServiceImpl.getFlagByCountry(countryName);
		logger.info("flag -> {}",flag);
		if(flag==null) {
			throw new CountryNotFoundException("countryName-"+countryName);
		}
		else {
		 return new ResponseEntity<>(flag, HttpStatus.OK);
		}
	}
}

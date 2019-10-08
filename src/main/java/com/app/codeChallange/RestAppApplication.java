package com.app.codeChallange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.app.codeChallange.entity.Continent;
import com.app.codeChallange.repository.CrudRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class RestAppApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CrudRepository crudRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		 Continent[] continents = objectMapper.readValue(ResourceUtils.getFile("classpath:continents.json"), Continent[].class);
		 logger.info("Continents -> {}",(Object)continents);
		 for(Continent continent:continents) {
			 crudRepository.insertData(continent);
			 logger.info("Continent -> {}",continent);
					 }
		
	}

}

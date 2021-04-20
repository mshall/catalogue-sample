package com.shall.catalogue.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shall.catalogue.demo.util.DataRetrievalUtil;
import com.shall.catalogue.demo.util.DatabaseUtil;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = CatalogueRepositoryImpl.class)
public class DemoApplication implements CommandLineRunner {

	@Value("${mydatabase.name}")
	private String databaseName;

	@Autowired
	DataRetrievalUtil networkUtil;

	@Autowired
	DatabaseUtil databaseUtil;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {

		databaseUtil.initializeDatabase();

	}

	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("***********************************");
		System.out.println("DemoApplication.getRestTemplate -> Start");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, mappingJacksonHttpMessageConverter());
		return restTemplate;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		return mapper;
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper());
		return converter;
	}

}

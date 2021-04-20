package com.shall.catalogue.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.shall.catalogue.demo.repository")
public class MongoConfig {

	@Value("${spring.data.mongodb.uri}")
	private String databaseURL;

	@Value("${mydatabase.name}")
	private String databaseName;

	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString(databaseURL);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), databaseName);
	}

}
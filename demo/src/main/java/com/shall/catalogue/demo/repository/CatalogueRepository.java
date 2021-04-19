package com.shall.catalogue.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shall.catalogue.demo.model.CatalogueItem;

public interface CatalogueRepository extends MongoRepository<CatalogueItem, String> {

	@Query("{'sim': {$regex: /eSim/i}}")
	List<CatalogueItem> findByQuery(String itemValue);

	List<CatalogueItem> findAll();

	@Query("{'release.priceEur': ?0}")
	List<CatalogueItem> findByPrice(final int priceEur);

	@Query("{'release.announceDate': ?0, 'release.priceEur': ?1}")
	List<CatalogueItem> findByAnnounceDateAndPrice(String announceDate, int price);
}
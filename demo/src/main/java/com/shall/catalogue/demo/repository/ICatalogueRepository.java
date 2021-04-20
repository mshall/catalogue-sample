package com.shall.catalogue.demo.repository;

import java.util.List;

import com.shall.catalogue.demo.model.CatalogueItem;

public interface ICatalogueRepository {

	List<CatalogueItem> findCatalogueItems(com.shall.catalogue.demo.dto.CatalogueItem item);
	CatalogueItem save(CatalogueItem item);
	List<CatalogueItem> findAll();
}

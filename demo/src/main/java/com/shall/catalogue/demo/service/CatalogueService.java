package com.shall.catalogue.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.repository.CatalogueRepository;

@Service
public class CatalogueService {

	Logger logger = LoggerFactory.getLogger(CatalogueService.class);

	private final CatalogueRepository catalogueRepository;

	public CatalogueService(CatalogueRepository catalogueRepository) {
		this.catalogueRepository = catalogueRepository;
	}

	public List<CatalogueItem> search(int priceEuro, String sim, String announceDate) {
		logger.debug("***********************************");
		logger.debug("CatalogueService.search -> Start");
		List<CatalogueItem> items = null;
		if (announceDate != null && !announceDate.isEmpty()) {
			items = findByAnnounceDateAndPrice(announceDate, priceEuro);
			return items;
		}
		if (sim == null || sim.isEmpty()) {
			items = searchByPrice(priceEuro);
			return items;
		} else if (sim != null && !sim.isEmpty()) {
			items = searchBySim(sim);
			return items;
		}
		logger.debug("CatalogueService.search -> End");
		logger.debug("***********************************");
		return items;
	}

	public List<CatalogueItem> searchByPrice(int priceEuro) {
		logger.debug("***********************************");
		logger.debug("CatalogueService.searchByPrice -> Start");
		List<CatalogueItem> items = catalogueRepository.findByPrice(priceEuro);
		logger.info("Returned items: " + items);

		logger.debug("CatalogueService.searchByPrice -> End");
		logger.debug("***********************************");
		return items;
	}

	public List<CatalogueItem> searchBySim(String sim) {
		logger.debug("***********************************");
		logger.debug("CatalogueService.searchBySim -> Start");
		List<CatalogueItem> items = catalogueRepository.findBySimContainingIgnoreCase(sim);
		logger.info("Returned items: " + items);
		logger.debug("CatalogueService.searchBySim -> End");
		logger.debug("***********************************");
		return items;
	}

	public List<CatalogueItem> findAllItems() {
		logger.debug("***********************************");
		logger.debug("CatalogueService.findAll -> Start");
		List<CatalogueItem> items = catalogueRepository.findAll();
		logger.info("Returned items: " + items);
		logger.debug("CatalogueService.findAll -> End");
		logger.debug("***********************************");
		return items;
	}

	public List<CatalogueItem> findByAnnounceDateAndPrice(String announceDate, int price) {
		logger.debug("***********************************");
		logger.debug("CatalogueService.findByAnnounceDateAndPrice -> Start");
		List<CatalogueItem> items = catalogueRepository.findByAnnounceDateAndPrice(announceDate, price);
		logger.info("Returned items: " + items);
		logger.debug("CatalogueService.findByAnnounceDateAndPrice -> End");
		logger.debug("***********************************");
		return items;
	}
}

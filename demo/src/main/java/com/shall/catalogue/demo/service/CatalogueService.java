package com.shall.catalogue.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.repository.CatalogueRepository;

@Service
public class CatalogueService {

	private final CatalogueRepository catalogueRepository;

	public CatalogueService(CatalogueRepository catalogueRepository) {
		this.catalogueRepository = catalogueRepository;
	}

	public List<CatalogueItem> search(int priceEuro, String sim, String announceDate) {
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
		return items;
	}

	public List<CatalogueItem> searchByPrice(int priceEuro) {
		System.out.println("***********************************");
		System.out.println("CatalogueService.searchByPrice -> Start");
		List<CatalogueItem> items = catalogueRepository.findByPrice(priceEuro);
		System.out.println("Returned items: " + items);

		System.out.println("CatalogueService.searchByPrice -> End");
		System.out.println("***********************************");
		return items;
	}

	public List<CatalogueItem> searchBySim(String sim) {
		System.out.println("***********************************");
		System.out.println("CatalogueService.searchBySim -> Start");
		List<CatalogueItem> items = catalogueRepository.findByQuery(sim);
		System.out.println("Returned items: " + items);
		System.out.println("CatalogueService.searchBySim -> End");
		System.out.println("***********************************");
		return items;
	}

	public List<CatalogueItem> findAllItems() {
		System.out.println("***********************************");
		System.out.println("CatalogueService.findAll -> Start");
		List<CatalogueItem> items = catalogueRepository.findAll();
		System.out.println("Returned items: " + items);
		System.out.println("CatalogueService.findAll -> End");
		System.out.println("***********************************");
		return items;
	}

	public List<CatalogueItem> findByAnnounceDateAndPrice(String announceDate, int price) {
		System.out.println("***********************************");
		System.out.println("CatalogueService.findByAnnounceDateAndPrice -> Start");
		List<CatalogueItem> items = catalogueRepository.findByAnnounceDateAndPrice(announceDate, price);
		System.out.println("Returned items: " + items);
		System.out.println("CatalogueService.findByAnnounceDateAndPrice -> End");
		System.out.println("***********************************");
		return items;
	}
}

package com.shall.catalogue.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shall.catalogue.demo.dto.Hardware;
import com.shall.catalogue.demo.dto.Release;
import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.repository.ICatalogueRepository;

@Service
public class CatalogueService {

	Logger logger = LoggerFactory.getLogger(CatalogueService.class);

	@Autowired
	public ICatalogueRepository catalogueRepositoryImpl;

	public CatalogueService() {
	}

	public List<CatalogueItem> search(String brand, String phone, String picture, String sim, String resolution,
			String announcementDate, int priceEuro, String audioJack, String gps, String battery) {
		logger.debug("CatalogueService.search -> Start");
		List<CatalogueItem> items = null;
		com.shall.catalogue.demo.dto.CatalogueItem item = new com.shall.catalogue.demo.dto.CatalogueItem();

		Release release = new Release();
		Hardware hardware = new Hardware();

		release.setAnnounceDate(announcementDate);
		release.setPriceEur(priceEuro);
		hardware.setAudioJack(audioJack);
		hardware.setGps(gps);
		hardware.setBattery(battery);

		item.setRelease(release);
		item.setHardware(hardware);

		item.setBrand(brand);
		item.setPhone(phone);
		item.setPicture(picture);
		item.setResolution(resolution);
		item.setSim(sim);

		items = catalogueRepositoryImpl.findCatalogueItems(item);

//		if (announceDate != null && !announceDate.isEmpty()) {
//			items = findByAnnounceDateAndPrice(announceDate, priceEuro);
//			return items;
//		}
//		if (sim == null || sim.isEmpty()) {
//			items = searchByPrice(priceEuro);
//			return items;
//		} else if (sim != null && !sim.isEmpty()) {
//			items = searchBySim(sim);
//			return items;
//		}
		logger.debug("CatalogueService.search -> End");
		return items;
	}

	public List<CatalogueItem> findAllItems() {
		return catalogueRepositoryImpl.findAll();
	}

}

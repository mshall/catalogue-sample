package com.shall.catalogue.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.shall.catalogue.demo.dto.CatalogueItem;
import com.shall.catalogue.demo.dto.Hardware;
import com.shall.catalogue.demo.dto.Release;
import com.shall.catalogue.demo.repository.CatalogueRepository;

@Configuration
public class DatabaseUtil {

	Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

	private final CatalogueRepository catalogueRepository;

	private final NetworkUtil networkUtil;

	public DatabaseUtil(NetworkUtil networkUtil, CatalogueRepository catalogueRepository) {
		this.networkUtil = networkUtil;
		this.catalogueRepository = catalogueRepository;
	}

	public void initializeDatabase() {
		logger.debug("***********************************");
		logger.debug("DatabaseUtil.initializeDatabase -> Start");
		CatalogueItem[] networkitems = networkUtil.initializeCatalogueFetching();

		for (int i = 0; i < networkitems.length; i++) {
			CatalogueItem networkItem = networkitems[i];
			catalogueRepository.save(mapItems(networkItem));
		}
		logger.debug("DatabaseUtil.initializeDatabase -> End");
		logger.debug("***********************************");
	}

	public com.shall.catalogue.demo.model.CatalogueItem mapItems(CatalogueItem item) {
		logger.debug("***********************************");
		logger.debug("DatabaseUtil.mapItems -> Start");
		com.shall.catalogue.demo.model.CatalogueItem dbItem = new com.shall.catalogue.demo.model.CatalogueItem();
		dbItem.setBrand(item.getBrand());
		dbItem.setId(item.getId());
		dbItem.setPhone(item.getPhone());
		dbItem.setPicture(item.getPicture());
		dbItem.setResolution(item.getResolution());
		dbItem.setSim(item.getSim());
		Hardware hardware = item.getHardware();
		Release release = item.getRelease();
		com.shall.catalogue.demo.model.Release rl = new com.shall.catalogue.demo.model.Release();
		com.shall.catalogue.demo.model.Hardware hw = new com.shall.catalogue.demo.model.Hardware();
		hw.setAudioJack(hardware.getAudioJack());
		hw.setBattery(hardware.getBattery());
		hw.setGps(hardware.getGps());
		rl.setAnnounceDate(release.getAnnounceDate());
		rl.setPriceEur(release.getPriceEur());
		dbItem.setHardware(hw);
		dbItem.setRelease(rl);
		logger.debug("DatabaseUtil.mapItems -> Item: " + dbItem.toString());
		logger.debug("DatabaseUtil.mapItems -> End");
		logger.debug("***********************************");
		return dbItem;
	}
}

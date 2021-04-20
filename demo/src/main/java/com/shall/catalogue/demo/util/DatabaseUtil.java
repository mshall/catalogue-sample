package com.shall.catalogue.demo.util;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.shall.catalogue.demo.dto.CatalogueItem;
import com.shall.catalogue.demo.dto.Hardware;
import com.shall.catalogue.demo.dto.Release;
import com.shall.catalogue.demo.repository.ICatalogueRepository;

@Configuration
public class DatabaseUtil {

	Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

	private final ICatalogueRepository catalogueRepository;

	private final DataRetrievalUtil dataRetrievalUtil;

	public DatabaseUtil(DataRetrievalUtil networkUtil, ICatalogueRepository catalogueRepository) {
		this.dataRetrievalUtil = networkUtil;
		this.catalogueRepository = catalogueRepository;
	}

	public void initializeDatabase() {
		logger.debug("DatabaseUtil.initializeDatabase -> Start");
		CatalogueItem[] networkitems = dataRetrievalUtil.initializeCatalogueFetching();
		Arrays.stream(networkitems).forEach(item -> catalogueRepository.save(mapItems(item)));
		logger.debug("DatabaseUtil.initializeDatabase -> End");
	}

	public com.shall.catalogue.demo.model.CatalogueItem mapItems(CatalogueItem item) {
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
		return dbItem;
	}
}

package com.shall.catalogue.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.shall.catalogue.demo.dto.CatalogueItem;
import com.shall.catalogue.demo.dto.Hardware;
import com.shall.catalogue.demo.dto.Release;
import com.shall.catalogue.demo.repository.CatalogueRepository;

@Configuration
public class DatabaseUtil {

	@Autowired
	public CatalogueRepository catalogueRepository;

	private final NetworkUtil networkUtil;

	public DatabaseUtil(NetworkUtil networkUtil) {
		this.networkUtil = networkUtil;
	}

	public void initializeDatabase() {
		CatalogueItem[] networkitems = networkUtil.initializeCatalogueFetching();

		for (int i = 0; i < networkitems.length; i++) {
			CatalogueItem networkItem = networkitems[i];
			catalogueRepository.save(mapItems(networkItem));
		}
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

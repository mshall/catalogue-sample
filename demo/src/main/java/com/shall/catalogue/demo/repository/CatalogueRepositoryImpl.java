package com.shall.catalogue.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.util.Constants;

@Repository
public class CatalogueRepositoryImpl implements ICatalogueRepository {

	Logger logger = LoggerFactory.getLogger(CatalogueRepositoryImpl.class);
	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public List<CatalogueItem> findCatalogueItems(com.shall.catalogue.demo.dto.CatalogueItem item) {
		logger.debug("CatalogueRepositoryImpl.findItems -> Start");
		Query query = new Query();
//		query.addCriteria(Criteria.where("locationId").in(locationId));
		if (!StringUtils.isEmpty(item.getBrand())) {
			query.addCriteria(Criteria.where(Constants.BRAND).is(item.getBrand()));
		}
		if (!StringUtils.isEmpty(item.getPhone())) {
			// query.addCriteria(Criteria.where("history.0.code").is(status));
			query.addCriteria(Criteria.where(Constants.PHONE).is(item.getPhone()));
		}

		if (!StringUtils.isEmpty(item.getPicture())) {
			query.addCriteria(Criteria.where(Constants.PICTURE).is(item.getPicture()));
		}

		if (!StringUtils.isEmpty(item.getRelease().getAnnounceDate())) {
			query.addCriteria(Criteria.where(Constants.RELEASE + "." + Constants.ANNOUNCEMENT_DATE)
					.is(item.getRelease().getAnnounceDate()));
		}

		if (item.getRelease().getPriceEur() > 0) {
			query.addCriteria(
					Criteria.where(Constants.RELEASE + "." + Constants.PRICE_EURO).is(item.getRelease().getPriceEur()));
		}

		if (!StringUtils.isEmpty(item.getResolution())) {
			query.addCriteria(Criteria.where(Constants.RESOLUTION).is(item.getResolution()));
		}

		if (!StringUtils.isEmpty(item.getSim())) {
			Criteria regex = Criteria.where(Constants.SIM).regex(".*" + item.getSim() + ".*", "i");
			query.addCriteria(regex);
		}

		if (!StringUtils.isEmpty(item.getHardware().getAudioJack())) {
			query.addCriteria(Criteria.where(Constants.HARDWARE + "." + Constants.AUDIO_JACK)
					.is(item.getHardware().getAudioJack()));
		}

		if (!StringUtils.isEmpty(item.getHardware().getBattery())) {
			query.addCriteria(
					Criteria.where(Constants.HARDWARE + "." + Constants.BATTERY).is(item.getHardware().getBattery()));
		}

		if (!StringUtils.isEmpty(item.getHardware().getGps())) {
			query.addCriteria(Criteria.where(Constants.HARDWARE + "." + Constants.GPS).is(item.getHardware().getGps()));
		}
		List<CatalogueItem> testItems = mongoTemplate.findAll(CatalogueItem.class);
		logger.debug("CatalogueRepositoryImpl.findItems -> Test Res: " + testItems);
		List<CatalogueItem> resultItems = mongoTemplate.find(query, CatalogueItem.class);
		logger.debug("CatalogueRepositoryImpl.findItems -> End");
		return resultItems;
	}

	@Override
	public CatalogueItem save(CatalogueItem item) {
		return mongoTemplate.save(item);
	}

	@Override
	public List<CatalogueItem> findAll() {
		return mongoTemplate.findAll(CatalogueItem.class);
	}
}

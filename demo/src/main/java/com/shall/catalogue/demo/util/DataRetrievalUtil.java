package com.shall.catalogue.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.shall.catalogue.demo.dto.CatalogueItem;

@Configuration
public class DataRetrievalUtil {

	Logger logger = LoggerFactory.getLogger(DataRetrievalUtil.class);

	private final RestTemplate restTemplate;

	public DataRetrievalUtil(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${catalogue.url}")
	private String catalogueURL;

	public CatalogueItem[] initializeCatalogueFetching() {
		logger.debug("NetworkUtil.initializeCatalogueFetching -> Start");
		CatalogueItem[] response = restTemplate.getForObject(catalogueURL, CatalogueItem[].class);
		logger.debug("NetworkUtil.initializeCatalogueFetching -> End");
		return response;
	}
}

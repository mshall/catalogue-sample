package com.shall.catalogue.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.shall.catalogue.demo.dto.CatalogueItem;

@Configuration
public class NetworkUtil {

	Logger logger = LoggerFactory.getLogger(NetworkUtil.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${catalogue.url}")
	private String catalogueURL;

	public CatalogueItem[] initializeCatalogueFetching() {
		logger.debug("***********************************");
		logger.debug("NetworkUtil.initializeCatalogueFetching -> Start");
		CatalogueItem[] response = restTemplate.getForObject(catalogueURL, CatalogueItem[].class);
		logger.debug("NetworkUtil.initializeCatalogueFetching -> End");
		logger.debug("***********************************");
		return response;
	}
}

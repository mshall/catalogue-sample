package com.shall.catalogue.demo.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.shall.catalogue.demo.dto.CatalogueItem;

@Configuration
public class NetworkUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${catalogue.url}")
	private String catalogueURL;

	public CatalogueItem[] initializeCatalogueFetching() {
		System.out.println("***********************************");
		System.out.println("NetworkUtil.initializeCatalogueFetching -> Start");
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
////		HttpEntity<String> entity = new HttpEntity<String>(headers);
		CatalogueItem[] response = restTemplate.getForObject(catalogueURL, CatalogueItem[].class);
		// System.out.println("Response: " + response);
		System.out.println("NetworkUtil.initializeCatalogueFetching -> End");
		System.out.println("***********************************");
		return response;
	}
}

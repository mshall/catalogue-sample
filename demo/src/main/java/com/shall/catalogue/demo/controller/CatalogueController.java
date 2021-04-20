package com.shall.catalogue.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.network.response.ResponseVO;
import com.shall.catalogue.demo.service.CatalogueService;

@CrossOrigin
@RestController
@RequestMapping("/mobile")
public class CatalogueController {
	Logger logger = LoggerFactory.getLogger(CatalogueController.class);
	private final CatalogueService catalogueService;

	public CatalogueController(CatalogueService catalogueService) {
		this.catalogueService = catalogueService;
	}

	@CrossOrigin
	@RequestMapping(value = "/search", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<List<CatalogueItem>>> searchItems(
			@RequestParam(required = false, name = "sim") String sim,
			@RequestParam(defaultValue = "0", required = false, name = "priceEur") Integer priceEuro,
			@RequestParam(required = false, name = "announceDate") String announceDate) {
		logger.debug("***********************************");
		logger.debug("CatalogueController.searchItems -> Start");
		List<CatalogueItem> result;
		result = catalogueService.search(priceEuro, sim, announceDate);
		logger.debug("CatalogueController.searchItems -> End");
		logger.debug("***********************************");
		return ResponseEntity.ok(new ResponseVO<>(result));
	}

	@CrossOrigin
	@RequestMapping(value = "/all", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<List<CatalogueItem>>> getCatalogue() {
		return ResponseEntity.ok(new ResponseVO<>(catalogueService.findAllItems()));
	}
}

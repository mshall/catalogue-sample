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
import com.shall.catalogue.demo.util.Constants;

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
			@RequestParam(required = false, name = Constants.BRAND) String brand,
			@RequestParam(required = false, name = Constants.PHONE) String phone,
			@RequestParam(required = false, name = Constants.PICTURE) String picture,
			@RequestParam(required = false, name = Constants.SIM) String sim,
			@RequestParam(required = false, name = Constants.RESOLUTION) String resolution,
			@RequestParam(required = false, name = Constants.ANNOUNCEMENT_DATE) String announceDate,
			@RequestParam(defaultValue = "0", required = false, name = Constants.PRICE_EURO) Integer priceEuro,
			@RequestParam(required = false, name = Constants.AUDIO_JACK) String audioJack,
			@RequestParam(required = false, name = Constants.GPS) String gps,
			@RequestParam(required = false, name = Constants.BATTERY) String battery) {
		logger.debug("CatalogueController.searchItems -> Start");
		List<CatalogueItem> result;
		result = catalogueService.search(brand, phone, picture, sim, resolution, announceDate, priceEuro, audioJack,
				gps, battery);
		logger.debug("CatalogueController.searchItems -> End");
		return ResponseEntity.ok(new ResponseVO<>(result));
	}

	@CrossOrigin
	@RequestMapping(value = "/all", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<List<CatalogueItem>>> getCatalogue() {
		return ResponseEntity.ok(new ResponseVO<>(catalogueService.findAllItems()));
	}
}

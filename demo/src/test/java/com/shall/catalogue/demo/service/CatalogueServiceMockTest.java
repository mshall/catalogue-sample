package com.shall.catalogue.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.repository.CatalogueRepositoryImpl;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogueServiceMockTest {

	@Mock
	private CatalogueRepositoryImpl catalogueRepository;

	@InjectMocks
	private CatalogueService catalogueService;

	com.shall.catalogue.demo.dto.CatalogueItem sampleItem;
	CatalogueItem databaseItem = new CatalogueItem();
	List<CatalogueItem> sampleItems;

	@BeforeAll
	public void setMockOutput() {
		sampleItem = new com.shall.catalogue.demo.dto.CatalogueItem();
		databaseItem = new CatalogueItem();
		sampleItems = new ArrayList<>();
		sampleItem.setBrand("Test Brand");
		sampleItem.setId("1");
		sampleItem.setPicture("Test Picture");
		com.shall.catalogue.demo.dto.Release release = new com.shall.catalogue.demo.dto.Release();
		release.setAnnounceDate("2021-04-20");
		release.setPriceEur(10);
		sampleItem.setRelease(release);

		sampleItems.add(databaseItem);

	}

//	@Test
//	public void givenPriceWhenSearchByPriceThenReturnItems() {
//		sampleItem.getRelease().setPriceEur(200);
//		when(catalogueRepository.findCatalogueItems(sampleItem)).thenReturn(sampleItems);
//
//		List<CatalogueItem> items = catalogueService.search("brand", "phone", "picture", "sim", "resolution",
//				"announceDate", 0, "audioJack", "gps", "battery");
//		assertNotNull(items);
//		assertThat(items.size()).isGreaterThan(0);
//		assertThat(items.get(0).getRelease().getPriceEur()).isEqualTo(200);
//	}
	
	@Test
	public void givenValuesWhenSelectAllThenReturnList() {
		when(catalogueRepository.findAll()).thenReturn(sampleItems);
		List<CatalogueItem> items = catalogueService.findAllItems();
		assertNotNull(items);
		assertThat(items.size()).isGreaterThan(0);
		assertThat(items.size()).isEqualTo(1);
	}
}

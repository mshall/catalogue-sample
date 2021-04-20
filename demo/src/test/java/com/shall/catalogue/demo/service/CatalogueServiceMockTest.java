//package com.shall.catalogue.demo.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.shall.catalogue.demo.model.CatalogueItem;
//import com.shall.catalogue.demo.model.Release;
//import com.shall.catalogue.demo.repository.CatalogueRepository;
//
//@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class CatalogueServiceMockTest {
//
//	@Mock
//	private CatalogueRepository catalogueRepository;
//
//	@InjectMocks
//	private CatalogueService catalogueService;
//
//	CatalogueItem sampleItem;
//	List<CatalogueItem> sampleItems;
//
//	@BeforeAll
//	public void setMockOutput() {
//		sampleItem = new CatalogueItem();
//		sampleItems = new ArrayList<>();
//		sampleItem.setBrand("Test Brand");
//		sampleItem.setId("1");
//		sampleItem.setPicture("Test Picture");
//		Release release = new Release();
//		release.setAnnounceDate("2021-04-20");
//		release.setPriceEur(10);
//		sampleItem.setRelease(release);
//		sampleItems.add(sampleItem);
//
//	}
//
//	@Test
//	public void givenPriceWhenSearchByPriceThenReturnItems() {
//		sampleItem.getRelease().setPriceEur(200);
//		when(catalogueRepository.findByPrice(200)).thenReturn(sampleItems);
//
//		List<CatalogueItem> items = catalogueService.searchByPrice(200);
//		assertNotNull(items);
//		assertThat(items.size()).isGreaterThan(0);
//		assertThat(items.get(0).getRelease().getPriceEur()).isEqualTo(200);
//	}
//}

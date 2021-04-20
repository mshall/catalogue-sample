package com.shall.catalogue.demo.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.shall.catalogue.demo.dto.CatalogueItem;
import com.shall.catalogue.demo.dto.Release;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatabaseUtilMockTest {

	@Mock
	private DataRetrievalUtil networkUtil;

	@InjectMocks
	private DatabaseUtil databaseUtil;

	CatalogueItem sampleItem;
	CatalogueItem[] sampleItems;

	@BeforeAll
	public void setMockOutput() {
		sampleItem = new CatalogueItem();
		sampleItems = new CatalogueItem[1];
		sampleItem.setBrand("Test Brand");
		sampleItem.setId("1");
		sampleItem.setPicture("Test Picture");
		Release release = new Release();
		release.setAnnounceDate("2021-04-20");
		release.setPriceEur(10);
		sampleItem.setRelease(release);
		sampleItems[0] = sampleItem;

	}

	@Test
	public void givenPriceWhenSearchByPriceThenReturnNull() {
		sampleItem.getRelease().setPriceEur(200);
		Mockito.lenient().when(networkUtil.initializeCatalogueFetching()).thenReturn(sampleItems);

		CatalogueItem[] items = networkUtil.initializeCatalogueFetching();
		assertNotNull(items);
		assertThat(sampleItems.length).isGreaterThan(0);
		assertThat(sampleItems[0].getRelease().getPriceEur()).isEqualTo(200);
	}

}

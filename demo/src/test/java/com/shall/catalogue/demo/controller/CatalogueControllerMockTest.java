package com.shall.catalogue.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.http.ResponseEntity;

import com.shall.catalogue.demo.model.CatalogueItem;
import com.shall.catalogue.demo.network.response.ResponseVO;
import com.shall.catalogue.demo.service.CatalogueService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogueControllerMockTest {

	@Mock
	private CatalogueService catalogueService;

	@InjectMocks
	private CatalogueController catalogueController;

	CatalogueItem sampleItem;
	List<CatalogueItem> sampleItems;

	@BeforeAll
	public void setMockOutput() {
		sampleItem = new CatalogueItem();
		sampleItems = new ArrayList<>();
		sampleItem.setBrand("Test Brand");
		sampleItem.setId("1");
		sampleItem.setPicture("Test Picture");
		sampleItems.add(sampleItem);

	}

	@Test
	public void givenResultsWhenSearchThenLengthThree() {
		when(catalogueService.search(200, "hi", "hi")).thenReturn(sampleItems);

		ResponseEntity<ResponseVO<List<CatalogueItem>>> response = catalogueController.searchItems("hi", 200, "hi");
		assertThat(response.getBody().getResults().size()).isEqualTo(sampleItems.size());
	}
}

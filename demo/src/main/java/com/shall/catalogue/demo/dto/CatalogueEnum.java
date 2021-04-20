package com.shall.catalogue.demo.dto;

public enum CatalogueEnum {
	BRAND("brand"), PHONE("phone"), PICTURE("picture"), ANNOUNCEMENT_DATE("announceDate"), PRICE_EURO("priceEur"),
	RESOLUTION("resolution"), SIM("sim"), AUDIO_JACK("audioJack"), GPS("gps"), BATTERY("battery"), RELEASE("release"),
	HARDWARE("hardware");

	public final String label;

	private CatalogueEnum(String label) {
		this.label = label;
	}

}

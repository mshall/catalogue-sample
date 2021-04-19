package com.shall.catalogue.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CatalogueItem {

	public String id;
	public String brand;
	public String phone;
	public String picture;
	public Release release;
	public String sim;
	public String resolution;
	public Hardware hardware;
}

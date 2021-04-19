package com.shall.catalogue.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "catalogue")
public class CatalogueItem {
	
	@Id
	public String id;
	public String brand;
	public String phone;
	public String picture;
	public Release release;
	public String sim;
	public String resolution;
	public Hardware hardware;
}

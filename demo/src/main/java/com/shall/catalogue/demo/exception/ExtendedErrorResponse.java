package com.shall.catalogue.demo.exception;

import java.util.Map;

import lombok.Data;

@Data
public class ExtendedErrorResponse extends ErrorResponse {

	private Map<String, String> additionalInfo;
}
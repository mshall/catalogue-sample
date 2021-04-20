package com.shall.catalogue.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * response body that returned in case of error
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ErrorResponse {

	private String message;
	private String description;
	private String error;
	private String transactionId;
	private int eCode;

}

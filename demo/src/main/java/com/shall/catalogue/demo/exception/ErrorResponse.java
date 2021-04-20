package com.shall.catalogue.demo.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * response body that returned in case of error
 */

public class ErrorResponse {

	private String message;
	private String description;
	private String error;
	private String transactionId;
	private int eCode;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, String description, String error, String transactionId, int eCode) {
		super();
		this.message = message;
		this.description = description;
		this.error = error;
		this.transactionId = transactionId;
		this.eCode = eCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getECode() {
		return eCode;
	}

	public void setECode(int eCode) {
		this.eCode = eCode;
	}

}

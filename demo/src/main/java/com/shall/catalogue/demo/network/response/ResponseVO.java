package com.shall.catalogue.demo.network.response;

/**
 * 
 * @author Mohamed S. El-Shall <a href="www.facebook.com/M.S.ElShall">Catch
 *         me</a>
 * @param <T>
 *            of type
 */

public class ResponseVO<T> {
	
	private String message;
	private T results;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseVO(T results) {
		this.results = results;
	}

	public T getResults() {
		return this.results;
	}
}

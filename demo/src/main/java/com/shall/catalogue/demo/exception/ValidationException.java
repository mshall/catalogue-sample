package com.shall.catalogue.demo.exception;

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
public class ValidationException extends BusinessException {

	private static final long serialVersionUID = 1L;

	private String message;
	private int code;

}

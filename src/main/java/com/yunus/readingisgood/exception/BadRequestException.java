package com.yunus.readingisgood.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

}

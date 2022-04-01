package com.yunus.readingisgood.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yunus.readingisgood.dto.Error;
import com.yunus.readingisgood.exception.NotFoundException;
import com.yunus.readingisgood.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Error> handleNotFoundValidationException(NotFoundException e, HttpServletRequest request,
			HttpServletResponse response) {
		log.error("ReadingIsGood exception occured -> NotFoundException: {}", e.getMessage());

		Error exceptionResponse = generateExceptionResponse(Constants.NOT_FOUND, e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Error> handleArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request, HttpServletResponse response) {
		log.error("ReadingIsGood exception occured -> MethodArgumentNotValidException: {}", e.getMessage());

		Error exceptionResponse = generateExceptionResponse(Constants.BAD_REQUEST_CODE, e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}

	@ExceptionHandler({ RuntimeException.class, Exception.class })
	public ResponseEntity<Error> otherExceptions(Exception e, HttpServletRequest request,
			HttpServletResponse response) {
		log.error("ReadingIsGood exception occured -> RuntimeException: {}",
				e.toString().concat(StringUtils.SPACE).concat(e.getMessage()));

		Error exceptionResponse = generateExceptionResponse(Constants.INTERNAL_SERVER_ERROR_CODE,
				e.toString().concat(StringUtils.SPACE).concat(e.getMessage()));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}

	private Error generateExceptionResponse(String code, String message) {
		Error response = new Error();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

}

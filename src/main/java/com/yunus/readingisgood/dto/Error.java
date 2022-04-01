package com.yunus.readingisgood.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("message")
	private String message = null;

}

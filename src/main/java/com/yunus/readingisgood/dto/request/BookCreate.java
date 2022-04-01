package com.yunus.readingisgood.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreate {

	@NotNull(message = "Book isbn must not be null")
	@NotBlank(message = "Book isbn must not be empty")
	private String isbn;

	@NotNull(message = "Book name must not be null")
	@NotBlank(message = "Book name must not be empty")
	private String name;

	@NotNull(message = "Book price must not be null")
	@Positive(message = "Book price must be greater then zero")
	private Long price;

	@NotNull(message = "Book description must not be null")
	@NotBlank(message = "Book description must not be empty")
	private String description;

}

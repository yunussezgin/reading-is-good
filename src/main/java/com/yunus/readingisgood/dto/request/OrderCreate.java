package com.yunus.readingisgood.dto.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.yunus.readingisgood.entity.Book;

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
public class OrderCreate {

	@Min(value = 1, message = "Order quantity must be at least one")
	private int quantity;

	@NotNull(message = "Order totalPrice must not be null")
	@Positive(message = "Order totalPrice must be grather then zero")
	private BigDecimal totalPrice;

	@NotNull(message = "Order books must not be null")
	@Positive(message = "Order books must have at least one book")
	private List<Book> books;

}

package com.yunus.readingisgood.dto.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.yunus.readingisgood.entity.Order;

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
public class CustomerCreate {

	@NotNull(message = "Customer firstName must not be null")
	@NotBlank(message = "Customer firstName must not be empty")
	private String firstName;

	@NotNull(message = "Customer lastName must not be null")
	@NotBlank(message = "Customer lastName must not be empty")
	private String lastName;

	@NotNull(message = "Customer email must not be null")
	@NotBlank(message = "Customer email must not be empty")
	private String email;

	@NotNull(message = "Customer phone must not be null")
	@NotBlank(message = "Customer phone must not be empty")
	private String phone;

	@NotNull(message = "Customer orders must not be null")
	@Min(value = 1, message = "Customer must have at least one order")
	private List<Order> orders;
	
}

package com.yunus.readingisgood.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	@JoinColumn(name = "FK_ORDER_CUSTOMER")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Order.class)
	private List<Order> orders;

}

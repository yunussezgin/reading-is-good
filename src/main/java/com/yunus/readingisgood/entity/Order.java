package com.yunus.readingisgood.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ORDERS")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String trackingNumber;

	private int quantity;

	private BigDecimal totalPrice;

	@CreationTimestamp
	private Date dateCreated;

	@UpdateTimestamp
	private Date lastUpdated;

	@JoinColumn(name = "FK_BOOK_ORDER")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Book.class)
	private List<Book> books = new ArrayList<>();
}

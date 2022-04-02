package com.yunus.readingisgood.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

	private int quantity;

	private BigDecimal totalPrice;

	@CreationTimestamp
	private LocalDateTime createDate;

	@JoinColumn(name = "FK_BOOK_ORDER")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Book.class)
	private List<Book> books;
}

package com.yunus.readingisgood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yunus.readingisgood.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

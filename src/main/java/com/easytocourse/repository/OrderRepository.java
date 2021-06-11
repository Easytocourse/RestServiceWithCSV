package com.easytocourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytocourse.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}

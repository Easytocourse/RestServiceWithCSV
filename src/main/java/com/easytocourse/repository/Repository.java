package com.easytocourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytocourse.model.Medicine;

public interface Repository extends JpaRepository<Medicine, String> {

	List<Medicine> findByCnameContainingIgnoreCase(String title);
}

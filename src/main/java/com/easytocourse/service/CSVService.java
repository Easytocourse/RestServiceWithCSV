package com.easytocourse.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.easytocourse.model.Medicine;
import com.easytocourse.model.Orders;
import com.easytocourse.repository.OrderRepository;
import com.easytocourse.repository.Repository;
import com.easytocourse.util.Csvhelper;

@Service
public class CSVService {

	@Autowired
	Repository repo;

	@Autowired
	OrderRepository orderrepo;

	public List<Medicine> save(MultipartFile file) throws NumberFormatException, ParseException {
		try {
			List<Medicine> Medicines = Csvhelper.csvToMedicines(file.getInputStream());

			return repo.saveAll(Medicines);

		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public int getrecordscount() {

		return (int) repo.findAll().size();
	}

	public List<Medicine> searchMedicine(String title) {

		return repo.findByCnameContainingIgnoreCase(title);
	}

	public Optional<Medicine> getMedicineDetails(String id) {

		return repo.findById(id);
	}

	public Orders orderitem(Orders orders) {

		return orderrepo.save(orders);
	}

	public List<Orders> getallorders() {
		return orderrepo.findAll();
	}

}
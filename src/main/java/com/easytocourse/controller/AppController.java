package com.easytocourse.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easytocourse.model.Medicine;
import com.easytocourse.model.Orders;
import com.easytocourse.service.CSVService;

@RestController
public class AppController {

	@Autowired
	CSVService fileService;

	@PostMapping("/uploadCSV")
	public List<Medicine> uploadFile(@RequestParam("file") MultipartFile file)
			throws NumberFormatException, ParseException {

		return fileService.save(file);

	}

	@GetMapping("/searchMedicine/{title}")
	public List<Medicine> searchMedicine(@PathVariable String title) {
		return fileService.searchMedicine(title);
	}

	@GetMapping("/getMedicineDetails/{id}")
	public Optional<Medicine> getMedicineDetails(@PathVariable String id) {
		return fileService.getMedicineDetails(id);
	}

	@PostMapping("/placeorder")
	public ResponseEntity<?> placeorder(@RequestBody Orders orders) {

		try {
			Orders savedorder = fileService.orderitem(orders);
			return ResponseEntity.status(HttpStatus.OK).body(savedorder);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/orders")
	public List<Orders> getallorders() {
		return fileService.getallorders();
	}

	@GetMapping("/count")
	public int getcount() {
		return fileService.getrecordscount();
	}

}

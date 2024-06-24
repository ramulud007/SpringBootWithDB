package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierRestController {

	@Autowired
	private SupplierService service;

	@PostMapping(value = "/add-Suppliers")
	public ResponseEntity<Boolean> addSupplier(@RequestBody @Valid Supplier supplier) {
		Boolean isAdded = service.addSupplier(supplier);

		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/get-Supplier-By-Id/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long supplierId) {
		Supplier gsbId = service.getSupplierById(supplierId);
		if (gsbId != null) {
			return new ResponseEntity<Supplier>(gsbId, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Supplier>(gsbId, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/get-All-Suppliers")
	public ResponseEntity<List<Supplier>> getAllSupplier() {
		List<Supplier> supplier = service.getAllSupplier();
		if (supplier != null) {
			return new ResponseEntity<List<Supplier>>(supplier, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Supplier>>(supplier, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "/delete-Supplier-By-Id/{id}")
	public ResponseEntity<Boolean> deleteSupplierById(@PathVariable("id") Long supplierId) {

		Boolean isDeleted = service.deleteSupplierById(supplierId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "/update-Supplier")
	public ResponseEntity<Boolean> updateSupplier(@RequestBody Supplier supplier) {
		Boolean isUpdated = service.updateSupplier(supplier);
		if (isUpdated){
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
		}
	}

}
